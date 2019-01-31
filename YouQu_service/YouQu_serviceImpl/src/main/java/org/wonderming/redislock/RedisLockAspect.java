package org.wonderming.redislock;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.concurrent.TimeoutException;

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
        Boolean lock = false;
        Object object = null;
        while (!lock){
            //超时时间
            long keepexpireTime = System.nanoTime() + expireTime * MILLI_NANO_TIME;
            //已经有锁 执行业务逻辑
            if (setIfAbsent(prefixKey,keepexpireTime)){
                object = pjp.proceed();
            //锁已经过期 仍可执行业务逻辑 但接下来不会进入循环会直接释放锁
            }else if ((System.nanoTime() - nanoTime > getLock(prefixKey)) && (System.nanoTime() - nanoTime > getSet(prefixKey,keepexpireTime))){
                lock = true;
                object = pjp.proceed();
            }else{

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
     * redis "SET IF NOT EXISTS" 如果key存在则进行set操作，如果key不存在什么也不做
     * @param prefixKey
     * @param expireTime
     * @return
     */
    private Boolean setIfAbsent(String prefixKey,Long expireTime){
       return stringRedisTemplate.opsForValue().setIfAbsent(prefixKey,expireTime.toString());
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
