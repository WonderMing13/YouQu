package org.wonderming.javapattern.Strategy;

/**
 * @className: CheckStrategy
 * @package: org.wonderming.javapattern.Strategy
 * @author: wangdeming
 * @date: 2019-03-09 17:15
 **/
public class CheckStrategy implements Istrategy {

    @Override
    public void operate() {
        System.out.println("检查策略模式");
    }
}
