package org.wonderming.redislock;

import java.lang.annotation.*;

/**
 * 并发时，方法级别的注解
 * RUNTIME
 *  * 定义注解
 *  * 编译器将把注释记录在类文件中，在运行时 VM 将保留注释，因此可以反射性地读取。
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CacheLock {
    //redis 锁key的前缀
    String lockedPrefix() default "";
    //轮询锁的时间.在阻塞式访问资源时线程上锁，特定时间轮询
    long timeOut() default 2000;
    //key在redis存活的时间,锁超时机制
    int expireTime() default 1000;
}
