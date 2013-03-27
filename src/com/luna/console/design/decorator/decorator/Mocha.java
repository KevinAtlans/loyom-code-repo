package com.luna.console.design.decorator.decorator;

import com.luna.console.design.decorator.module.Beverage;

public class Mocha extends CondimentDecorator {

    Beverage beverage;

    public Mocha(Beverage beverage) {

        this.beverage = beverage;
    }

    @Override
    public String getDescription() {

        return beverage.getDescription() + ", Mocha";
    }

    @Override
    public double cost() {

        return 0.2 + beverage.cost();
    }

}
