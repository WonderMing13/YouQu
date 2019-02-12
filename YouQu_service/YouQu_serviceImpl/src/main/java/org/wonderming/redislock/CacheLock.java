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

    //轮询锁的时间.在阻塞式访问资源时线程上锁，特定时间轮询 2秒
    long sleepTime() default 20*1000;

    //key在redis存活的时间,锁超时机制20秒，即阻塞时间
    long expireTime() default 1000;

    //获取锁失败 是否继续等待.默认阻塞式，采用轮询；非阻塞式，直接返回
    //boolean isWait() default true;

}
