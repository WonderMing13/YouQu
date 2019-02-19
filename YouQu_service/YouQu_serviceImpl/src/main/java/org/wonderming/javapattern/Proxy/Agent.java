package org.wonderming.javapattern.Proxy;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: 王德明
 * @Date: 2019/2/18
 * @Time: 10:31
 * @Project: youqu
 * @Package: org.wonderming.javapattern.Proxy
 */
public class Agent implements PlayerMan {

    private PlayerMan playerMan;

    public Agent() {
        this.playerMan = new James();
    }

    public Agent(PlayerMan playerMan) {
        this.playerMan = playerMan;
    }

    @Override
    public void dunk() {
        this.playerMan.dunk();
    }

    @Override
    public void dribble() {
        this.playerMan.dribble();
    }
}
