package org.wonderming.javapattern.FactoryMethod;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: 王德明
 * @Date: 2019/2/18
 * @Time: 11:45
 * @Project: youqu
 * @Package: org.wonderming.javapattern.FactoryMethod
 */
public class HumanFactory {
    public static Human createHuman(Class c) {
        Human human = null;
        try {
            human = (Human) Class.forName(c.getName()).newInstance();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return human;
    }
}
