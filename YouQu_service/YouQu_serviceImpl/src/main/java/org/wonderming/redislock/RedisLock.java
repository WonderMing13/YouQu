package org.wonderming.redislock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.concurrent.TimeUnit;

/**
 * @className: RedisLock
 * @package: org.wonderming.rediscachelock
 * @author: wangdeming
 * @date: 2019-01-30 14:37
 **/
public class RedisLock {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    //毫微秒
    private static long MILLI_NANO_TIME = 1000000;

    public boolean lock(long timeout,int expire,String key,String value){
        //获取jvm的启用时间
        long nanoTime = System.nanoTime();
        //过期时间转换成豪微秒
        timeout *= MILLI_NANO_TIME;
        //轮询锁查询是否有锁
        while (System.nanoTime() - nanoTime < timeout){
            if (stringRedisTemplate.opsForValue().setIfAbsent(key,value)){
                stringRedisTemplate.expire(key,expire, TimeUnit.MILLISECONDS);
                return true;
            }
        }
        return false;
    }

    public void unlock(String key){
        stringRedisTemplate.delete(key);
    }
}
