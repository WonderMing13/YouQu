package org.wonderming.javapattern.FactoryMethod;

/**
 * @className: UseFactoryMethod
 * @package: org.wonderming.javapattern.FactoryMethod
 * @author: wangdeming
 * @date: 2019-03-10 18:17
 **/
public class UseFactoryMethod {

    public static void main(String[] args){
        Human blackman = HumanFactory.createHuman(BlackMan.class);
        blackman.cry();
        blackman.laugh();
        blackman.talk();
    }
}
