package org.wonderming.javapattern.Proxy;

/**
 * @className: UseProxy
 * @package: org.wonderming.javapattern.Proxy
 * @author: wangdeming
 * @date: 2019-03-09 17:22
 **/
public class UseProxy {

    public static void main(String[] args){
        Agent agent = new Agent();
        agent.dribble();
        agent.dunk();

        Agent agent1 = new Agent(new Davis());
        agent1.dribble();
        agent1.dunk();
    }
}
