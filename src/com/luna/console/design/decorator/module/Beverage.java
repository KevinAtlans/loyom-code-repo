package com.luna.console.design.decorator.module;

public abstract class Beverage {

    String description = "Unknown Beverage";

    public String getDescription() {

        return this.description;
    }

    public abstract double cost();
}
