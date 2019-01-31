package org.wonderming.redislock;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

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
    public Object lock(ProceedingJoinPoint pjp,CacheLock cacheLock){
        //轮询时间
        long timeOut = cacheLock.timeOut();
        //key过期时间
        long expireTime = cacheLock.expireTime();
        //key的前缀
        String prefixKey = getPrefixKey(pjp,cacheLock.lockedPrefix());
        //获取jvm的启用时间
        long nanoTime = System.nanoTime();
        while (System.nanoTime() - nanoTime < timeOut){

        }



        Object object = null;
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
     * redis SET if Not eXists
     * @param prefixKey
     * @param expireTime
     * @return
     */
    private Boolean setIfAbsent(String prefixKey,Long expireTime){
       return stringRedisTemplate.opsForValue().setIfAbsent(prefixKey,expireTime.toString());
    }

    public StringRedisTemplate getStringRedisTemplate() {
        return stringRedisTemplate;
    }

    public void setStringRedisTemplate(StringRedisTemplate stringRedisTemplate) {
        this.stringRedisTemplate = stringRedisTemplate;
    }
}
