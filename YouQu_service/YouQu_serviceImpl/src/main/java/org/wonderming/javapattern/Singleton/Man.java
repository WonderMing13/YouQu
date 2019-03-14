package org.wonderming.javapattern.Singleton;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: 王德明
 * @Date: 2019/2/18
 * @Time: 11:01
 * @Project: youqu
 * @Package: org.wonderming.javapattern.Singleton
 */
public class Man {
    private static final Man man = new Man();

    private Man() {
    }

    public synchronized static Man getInstance(){
        return man;
    }
}
