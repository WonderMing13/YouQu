package org.wonderming.javapattern.Proxy;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: 王德明
 * @Date: 2019/2/18
 * @Time: 10:37
 * @Project: youqu
 * @Package: org.wonderming.javapattern.Proxy
 */
public class Davis implements PlayerMan {

    @Override
    public void dunk() {
        System.out.println("暴力虐框");
    }

    @Override
    public void dribble() {
        System.out.println("中锋运球");
    }
}
