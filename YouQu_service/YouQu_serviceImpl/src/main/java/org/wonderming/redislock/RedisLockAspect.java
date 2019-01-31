package org.wonderming.redislock;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;


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

    private static final Logger REDIS_LOCK_LOGGER = LoggerFactory.getLogger(RedisLockAspect.class);

    private StringRedisTemplate stringRedisTemplate;

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
        //轮询时间
        long timeOut = cacheLock.timeOut();
        //key过期时间
        long expireTime = cacheLock.expireTime();
        //key的前缀
        String prefixKey = getPrefixKey(pjp,cacheLock.lockedPrefix());
        //获取jvm的启用时间
        long nanoTime = System.nanoTime();
        //获取锁超时 是否继续等待
        Boolean isWait = cacheLock.isWait();
        boolean lock = false;
        Object object = null;
        while (!lock){
            try {
                //没有锁并加上锁并设置过期时间 执行业务逻辑
                if (setIfAbsent(prefixKey,expireTime * MILLI_NANO_TIME)){
                    object = pjp.proceed();
                 //存在锁但是锁刚好过期情况下 仍可执行业务逻辑 但接下来不会进入循环会直接释放锁
                }else if ((System.nanoTime() - nanoTime > getLock(prefixKey)) && (System.nanoTime() - nanoTime > getSet(prefixKey,expireTime * MILLI_NANO_TIME))){
                    lock = true;
                    object = pjp.proceed();
                //既有锁也没有过期 进行轮询
                }else{
                    //线程休眠轮询时间
                    Thread.sleep(timeOut);
                }
            } catch (Exception e) {
                REDIS_LOCK_LOGGER.error("锁发生异常",e);
            } finally {
                //释放锁
                if (lock) {
                    unLock(prefixKey);
                }
            }
        }
        return object;
    }

    /**
     * 添加前缀
      * @param pjp
     * @param prefixKey
     * @return
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
     * redis "SET IF NOT EXISTS" 当且仅当 key 不存在，将 key 的值设为 value ，并返回1；若给定的 key 已经存在，则 SETNX 不做任何动作，并返回0。
     * @param prefixKey
     * @param expireTime
     * @return
     */
    private Boolean setIfAbsent(String prefixKey,Long expireTime){
       if(stringRedisTemplate.opsForValue().setIfAbsent(prefixKey,expireTime.toString())){
           stringRedisTemplate.expire(prefixKey,expireTime, TimeUnit.NANOSECONDS);
           return true;
       }
       return false;
    }

    /**
     * 自动将key对应到value并且返回原来key对应的value。如果key存在但是对应的value不是字符串，就返回错误。
     * @param prefixKey
     * @param expireTime
     * @return
     */
    private Long getSet(String prefixKey,Long expireTime){
        String oldExpireTime = stringRedisTemplate.opsForValue().getAndSet(prefixKey,expireTime.toString());
        if (StringUtils.isEmpty(oldExpireTime)){
            return 0L;
        }
        return Long.parseLong(oldExpireTime) * MILLI_NANO_TIME;
    }

    /**
     * 获取当前锁
     * @param prefixKey
     * @return
     */
    private Long getLock(String prefixKey){
        String currentExpireTime = stringRedisTemplate.opsForValue().get(prefixKey);
        if (StringUtils.isEmpty(currentExpireTime)){
            return 0L;
        }
        return Long.parseLong(currentExpireTime) * MILLI_NANO_TIME;
    }

    /**
     * 释放锁
     * @param prefixKey
     */
    private void unLock(String prefixKey){
        stringRedisTemplate.delete(prefixKey);
    }

    public StringRedisTemplate getStringRedisTemplate() {
        return stringRedisTemplate;
    }

    public void setStringRedisTemplate(StringRedisTemplate stringRedisTemplate) {
        this.stringRedisTemplate = stringRedisTemplate;
    }
}
