package com.luna.console.design.decorator.decorator;

import com.luna.console.design.decorator.module.Beverage;

public class Soy extends CondimentDecorator {

    Beverage beverage;

    public Soy(Beverage beverage) {

        this.beverage = beverage;
    }

    @Override
    public String getDescription() {

        return beverage.getDescription() + ", Soy";
    }

    @Override
    public double cost() {

        return 0.8 + beverage.cost();
    }
}
