package org.wonderming.javapattern.AbstractFactory;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: 王德明
 * @Date: 2019/2/18
 * @Time: 13:44
 * @Project: youqu
 * @Package: org.wonderming.javapattern.AbstractFactory
 */
public abstract class AbstractHuman implements Human{

    @Override
    public void dunk(){
        System.out.println("KB扣篮！");
    }
}
