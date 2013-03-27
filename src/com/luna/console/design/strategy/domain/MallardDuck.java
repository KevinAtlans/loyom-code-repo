package com.luna.console.design.strategy.domain;

import com.luna.console.design.strategy.behavior.FlyBehavior;
import com.luna.console.design.strategy.behavior.QuackBehavior;
import com.luna.console.design.strategy.behavior.impl.FlyNotWay;
import com.luna.console.design.strategy.behavior.impl.MutweQuack;

public class MallardDuck extends Duck {

    public MallardDuck() {

        super();
        FlyBehavior fly = new FlyNotWay();
        QuackBehavior quack = new MutweQuack();
        this.setFly(fly);
        this.setQuack(quack);
    }

    @Override
    public void display() {

        System.out.println("I'm a real Mallard duck!");

    }

}
