package com.luna.console.design.strategy.behavior.impl;

import com.luna.console.design.strategy.behavior.FlyBehavior;

public class FlyNotWay implements FlyBehavior {

    @Override
    public void fly() {

        System.out.println("I can't fly!");
    }
}
