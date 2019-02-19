package org.wonderming.javapattern.Strategy;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: 王德明
 * @Date: 2019/2/18
 * @Time: 10:01
 * @Project: youqu
 * @Package: org.wonderming.javapattern
 */
public class GivenStrategy implements Istrategy {

    @Override
    public void operate() {
        System.out.println("这是策略模式");
    }
}
