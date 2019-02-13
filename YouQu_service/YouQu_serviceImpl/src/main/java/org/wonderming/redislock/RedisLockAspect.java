package org.wonderming.redislock;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.wonderming.jedis.JedisClientTemplate;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.Collections;
import java.util.UUID;
import java.util.concurrent.TimeUnit;


/**
 * @className: RedisLockAspect
 * @package: org.wonderming.redislock
 * @author: wangdeming
 * @date: 2019-01-30 17:01
 **/
@Aspect
@Component
public class RedisLockAspect {
    /**
     *  redis切面日志
     */
    private static final Logger REDIS_LOCK_LOGGER = LoggerFactory.getLogger(RedisLockAspect.class);
    /**
     *  jedis的操作
     */
    private JedisClientTemplate jedisClientTemplate;
    /**
     * 上锁成功
     */
    private static final String LOCK_SUCCESS = "OK";
    /**
     * 释放成功
     */
    private static final Long RELEASE_SUCCESS = 1L;
    /**
     * redis setnx操作
     */
    private static final String SET_IF_NOT_EXIST = "NX";
    /**
     * redis expire操作
     */
    private static final String SET_WITH_EXPIRE_TIME = "PX";

    /**
     * 定义切点
     */
    @Pointcut("@annotation(org.wonderming.redislock.CacheLock)")
    public void redisLockAspect(){
    }

    /**
     * 环绕通知
     * @param pjp
     * @param cacheLock
     * @return
     */
    @Around("redisLockAspect() && @annotation(cacheLock)")
    public Object lock(ProceedingJoinPoint pjp,CacheLock cacheLock) throws Throwable {
        Object object = null;
        //key的前缀
        String prefixKey = getPrefixKey(pjp,cacheLock.lockedPrefix());
        //key的过期阻塞时间
        long expireTime = cacheLock.expireTime();
        //key的轮询时间
        long sleepTime = cacheLock.sleepTime();
        //唯一标识
        String requestId = UUID.randomUUID().toString();
        try{
            if (redisLock(prefixKey, requestId, expireTime)) {
                object = pjp.proceed();
                System.out.println(requestId);
            }else {
                System.out.println(requestId);
                System.out.println("locked error");
            }
        } finally {
            if (releaseLock(prefixKey, requestId)) {
                System.out.println(requestId);
                System.out.println("delete success");
            }else {
                System.out.println(requestId);
                System.out.println("delete error");
            }
        }
        return object;
    }

    /**
     * 添加前缀
      * @param pjp 环绕切点
     * @param prefixKey 前缀
     * @return 返回前缀
     */
    private String getPrefixKey(ProceedingJoinPoint pjp,String prefixKey){
        StringBuffer stringBuffer = new StringBuffer(pjp.getSignature().getDeclaringTypeName());
        stringBuffer.append(".").append(pjp.getSignature().getName());
        if (!StringUtils.isEmpty(prefixKey)){
            stringBuffer.append(".").append(prefixKey);
        }
        return stringBuffer.toString();
    }

    /**
     *
     * @param prefixKey
     * @param requestId
     * @return
     */
    private  boolean redisLock(String prefixKey,String requestId,long expireTime) {
        String result = jedisClientTemplate.set(prefixKey,requestId,SET_IF_NOT_EXIST,SET_WITH_EXPIRE_TIME,expireTime);
        return LOCK_SUCCESS.equals(result);
    }

    /**
     * 释放锁
     * @param prefixKey
     * @param requestId
     * @return
     */
    private boolean releaseLock(String prefixKey, String requestId) {
        String script = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";
        Object result = jedisClientTemplate.eval(script,Collections.singletonList(prefixKey),Collections.singletonList(requestId));
        return RELEASE_SUCCESS.equals(result);
    }

    public JedisClientTemplate getJedisClientTemplate() {
        return jedisClientTemplate;
    }

    public void setJedisClientTemplate(JedisClientTemplate jedisClientTemplate) {
        this.jedisClientTemplate = jedisClientTemplate;
    }
}
