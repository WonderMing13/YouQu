package org.wonderming.javapattern.FactoryMethod;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: 王德明
 * @Date: 2019/2/18
 * @Time: 11:43
 * @Project: youqu
 * @Package: org.wonderming.javapattern.FactoryMethod
 */
public class BlackMan implements Human {

    @Override
    public void laugh() {
        System.out.println("黑人笑了");
    }

    @Override
    public void cry() {
        System.out.println("黑人哭了");
    }

    @Override
    public void talk() {
        System.out.println("黑人走起来");
    }
}
