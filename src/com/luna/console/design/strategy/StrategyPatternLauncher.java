package com.luna.console.design.strategy;

import com.luna.console.design.strategy.behavior.impl.FlyWithWings;
import com.luna.console.design.strategy.behavior.impl.Qucak;
import com.luna.console.design.strategy.domain.Duck;
import com.luna.console.design.strategy.domain.MallardDuck;

/**
 * 策略模式 Demo
 * 
 * @author xukai
 * 
 *         策略模式：定义了算法族，分别封装起来，让他们之间可以互相替换，此模式让算法的变化独立于使用算法的客户。
 */
public class StrategyPatternLauncher {

    /**
     * @param args
     */
    public static void main(String[] args) {

        Duck mallard = new MallardDuck();
        System.out.println("======================================");
        mallard.performFly();
        mallard.performQuack();
        System.out.println("======================================");
        mallard.setFly(new FlyWithWings());
        mallard.setQuack(new Qucak());
        mallard.performFly();
        mallard.performQuack();
    }
}
