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
     * 毫微秒
     */
    private static long MILLI_NANO_TIME = 1000000;
    /**
     *  redis切面日志
     */
    private static final Logger REDIS_LOCK_LOGGER = LoggerFactory.getLogger(RedisLockAspect.class);
    /**
     *  spring data redis 对jedis的支持
     */
    private StringRedisTemplate stringRedisTemplate;
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

    private JedisPool jedisPool;

    private JedisConnectionFactory jedisConnectionFactory;

    public JedisConnectionFactory getJedisConnectionFactory() {
        return jedisConnectionFactory;
    }

    public void setJedisConnectionFactory(JedisConnectionFactory jedisConnectionFactory) {
        this.jedisConnectionFactory = jedisConnectionFactory;
    }

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
            }
        } finally {
            releaseLock(prefixKey,requestId);
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
    private boolean redisLock(String prefixKey,String requestId,long expireTime) {
        Object connection = getConnection();
        String result = null;
        if (connection instanceof Jedis) {
            result = ((Jedis)connection).set(prefixKey, requestId, SET_IF_NOT_EXIST, SET_WITH_EXPIRE_TIME, expireTime);
            ((Jedis) connection).close();
        }
        return LOCK_SUCCESS.equals(result);
    }

    /**
     * 释放锁
     * @param prefixKey
     * @param requestId
     * @return
     */
    private boolean releaseLock(String prefixKey, String requestId) {
        Object connection = getConnection();
        Object result = null;
        String script = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";
        if (connection instanceof Jedis) {
            result = ((Jedis)connection).eval(script, Collections.singletonList(prefixKey), Collections.singletonList(requestId));
            ((Jedis) connection).close();
        }
        return RELEASE_SUCCESS.equals(result);
    }

    private Object getConnection() {
        Object connection ;
        RedisConnection redisConnection = jedisConnectionFactory.getConnection();
        connection = redisConnection.getNativeConnection();
        return connection;
    }


    /**
     * redis "SET IF NOT EXISTS" 当且仅当 key 不存在，将 key 的值设为 value ，并返回1；若给定的 key 已经存在，则 SETNX 不做任何动作，并返回0。
     * @param prefixKey
     * @param expireTime
     * @return
     */
    // private Boolean setIfAbsent(String prefixKey,Long expireTime){
    //    if(stringRedisTemplate.opsForValue().setIfAbsent(prefixKey,expireTime.toString())){
    //        stringRedisTemplate.expire(prefixKey,expireTime, TimeUnit.NANOSECONDS);
    //        return true;
    //    }
    //    return false;
    // }

    /**
     * 自动将key对应到value并且返回原来key对应的value。如果key存在但是对应的value不是字符串，就返回错误。
     * @param prefixKey
     * @param expireTime
     * @return
     */
    // private Long getSet(String prefixKey,Long expireTime){
    //     String oldExpireTime = stringRedisTemplate.opsForValue().getAndSet(prefixKey,expireTime.toString());
    //     if (StringUtils.isEmpty(oldExpireTime)){
    //         return 0L;
    //     }
    //     return Long.parseLong(oldExpireTime) * MILLI_NANO_TIME;
    // }

    /**
     * 获取当前锁
     * @param prefixKey
     * @return
     */
    // private Long getLock(String prefixKey){
    //     String currentExpireTime = stringRedisTemplate.opsForValue().get(prefixKey);
    //     if (StringUtils.isEmpty(currentExpireTime)){
    //         return 0L;
    //     }
    //     return Long.parseLong(currentExpireTime) * MILLI_NANO_TIME;
    // }

    /**
     * 释放锁
     * @param
     */
    // private void unLock(String prefixKey){
    //     stringRedisTemplate.delete(prefixKey);
    // }

    // private String jedisSet(String prefixKey,)

    public StringRedisTemplate getStringRedisTemplate() {
        return stringRedisTemplate;
    }

    public void setStringRedisTemplate(StringRedisTemplate stringRedisTemplate) {
        this.stringRedisTemplate = stringRedisTemplate;
    }

    public JedisClientTemplate getJedisClientTemplate() {
        return jedisClientTemplate;
    }

    public void setJedisClientTemplate(JedisClientTemplate jedisClientTemplate) {
        this.jedisClientTemplate = jedisClientTemplate;
    }

    public JedisPool getJedisPool() {
        return jedisPool;
    }

    public void setJedisPool(JedisPool jedisPool) {
        this.jedisPool = jedisPool;
    }
}
