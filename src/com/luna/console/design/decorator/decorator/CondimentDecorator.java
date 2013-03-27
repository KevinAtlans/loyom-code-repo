package com.luna.console.design.decorator.decorator;

import com.luna.console.design.decorator.module.Beverage;

public abstract class CondimentDecorator extends Beverage {

    @Override
    public abstract String getDescription();
}
