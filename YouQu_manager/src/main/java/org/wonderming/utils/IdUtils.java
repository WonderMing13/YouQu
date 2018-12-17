package org.wonderming.utils;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: 王德明
 * @Date: 2018/12/17
 * @Time: 10:04
 * @Project: youqu
 * @Package: org.wonderming.utils
 */
public class IdUtils {
    /**
     *  日期校验格式,精确到毫秒
     */
    private static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyyMMddHHmmssSSS");
    private static final Random RANDOM = new Random();
    private static int DIGITAL;


    /**
     * 获取随机数,两位随机数.0-99之间.
     * %取模,eg: 3 % 100 = 3
     * @return
     */
    public static int getRandom() {
        Integer max = 99;
        Integer min = 0;
        DIGITAL = RANDOM.nextInt(max) % (max - min + 1) + min;
        return DIGITAL;
    }

    /**
     * 使用重入锁ReentrantLock,对资源进行加锁,同一时刻只会有一个线程能够占有锁.当前锁被线程占有时,其他线程会进入挂起状态,直到该锁被释放,其他挂起的线程会被唤醒并开始新的竞争.
     * @return
     */
    public static long creatKey() {
        Lock lock = new ReentrantLock();
        lock.lock();
        String temp = null;
        try{
            String currentDate = DATE_FORMAT.format(new Date());
            //如果不足两位则补零
            temp = currentDate + String.format("%02d",getRandom());
        } finally {
            lock.unlock();
        }
        return new Long(temp);
    }
}
