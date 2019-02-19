package org.wonderming.javapattern.Strategy;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: 王德明
 * @Date: 2019/2/18
 * @Time: 9:58
 * @Project: youqu
 * @Package: org.wonderming.javapattern
 */
public class Context {
    private Istrategy istrategy;

    public Context(Istrategy istrategy) {
        this.istrategy = istrategy;
    }

    public void operate() {
        this.istrategy.operate();
    }
}
