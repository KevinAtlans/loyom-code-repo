package com.luna.console.design.strategy.behavior.impl;

import com.luna.console.design.strategy.behavior.QuackBehavior;

public class MutweQuack implements QuackBehavior {

    @Override
    public void quack() {

        System.out.println("Silence...");
    }

}
