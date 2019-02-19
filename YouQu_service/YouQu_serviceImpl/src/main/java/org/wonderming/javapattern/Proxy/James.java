package org.wonderming.javapattern.Proxy;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: 王德明
 * @Date: 2019/2/18
 * @Time: 10:28
 * @Project: youqu
 * @Package: org.wonderming.javapattern.Proxy
 */
public class James implements PlayerMan {

    @Override
    public void dunk() {
        System.out.println("LBJ战斧劈扣");
    }

    @Override
    public void dribble() {
        System.out.println("LBJ鬼魅运球");
    }
}
