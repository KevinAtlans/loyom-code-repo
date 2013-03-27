package com.luna.console.design.decorator.decorator;

import com.luna.console.design.decorator.module.Beverage;

public class Whip extends CondimentDecorator {

    Beverage beverage;

    public Whip(Beverage beverage) {

        this.beverage = beverage;
    }

    @Override
    public String getDescription() {

        return beverage.getDescription() + ", Whip";
    }

    @Override
    public double cost() {

        return 0.6 + beverage.cost();
    }
}
