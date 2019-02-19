package org.wonderming.javapattern.Facade;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: 王德明
 * @Date: 2019/2/18
 * @Time: 14:08
 * @Project: youqu
 * @Package: org.wonderming.javapattern.Facade
 */
public class PlayerImpl implements Player {

    @Override
    public void dribble(String ball) {
        System.out.println("球员运着" + ball);
    }

    @Override
    public void shamgod(String ball) {
        System.out.println("球员使用" + ball + "完成过人");
    }

    @Override
    public void dunk(String name) {
        System.out.println("球员隔扣了" + name);
    }
}
