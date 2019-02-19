package org.wonderming.javapattern.Facade;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: 王德明
 * @Date: 2019/2/18
 * @Time: 14:11
 * @Project: youqu
 * @Package: org.wonderming.javapattern.Facade
 */
public class Nba {
    private Player player = new PlayerImpl();

    public void enterLeague(String ball,String name) {
        player.dribble(ball);
        player.shamgod(ball);
        player.dunk(name);
    }
}
