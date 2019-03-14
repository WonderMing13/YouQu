package org.wonderming.javapattern.Strategy;

/**
 * @className: UseStrategy
 * @package: org.wonderming.javapattern.Strategy
 * @author: wangdeming
 * @date: 2019-03-09 17:17
 **/
public class UseStrategy {

    public static void main(String[] args){
        Context context;
        context = new Context(new GivenStrategy());
        context.operate();

        context = new Context(new CheckStrategy());
        context.operate();
    }
}
