package com.luna.console.design.decorator.module;

public class HouseBlend extends Beverage {

    public HouseBlend() {

        description = "HouseBlend";
    }

    @Override
    public double cost() {

        return 0.89;
    }

}