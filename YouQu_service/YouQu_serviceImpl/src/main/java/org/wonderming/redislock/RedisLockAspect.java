package org.wonderming.redislock;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.redisson.api.RLock;
import org.redisson.api.RReadWriteLock;
import org.redisson.api.RedissonClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.wonderming.exception.BaseException;


import java.util.Objects;
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
     *  redisson操作
     */
    private RedissonClient redissonClient;

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
        String prefixKey = getPrefixKey(pjp,cacheLock.lockedPrefix());
        RReadWriteLock readWriteLock = redissonClient.getReadWriteLock(prefixKey);
        if (readWriteLock.writeLock().isLocked()){
            System.out.println("其他线程已经获取到锁" + prefixKey);
        }
        try{
            boolean isLock = readWriteLock.writeLock().tryLock(5,10, TimeUnit.SECONDS);
            if (!isLock){
                System.out.println("没有获取到锁" + prefixKey);
            }
            object = pjp.proceed();
        }catch (Exception e){
            REDIS_LOCK_LOGGER.error("发生异常",e);
        } finally {
            readWriteLock.writeLock().forceUnlock();
            System.out.println("已释放锁" + prefixKey);
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


    public RedissonClient getRedissonClient() {
        return redissonClient;
    }

    public void setRedissonClient(RedissonClient redissonClient) {
        this.redissonClient = redissonClient;
    }
}
