package org.wonderming.redislock;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @className: RedisLockAspect
 * @package: org.wonderming.redislock
 * @author: wangdeming
 * @date: 2019-01-30 17:01
 **/
@Aspect
@Component
public class RedisLockAspect {

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
    public Object lock(ProceedingJoinPoint pjp,CacheLock cacheLock){
        Object object = null;
        return object;
    }
}
