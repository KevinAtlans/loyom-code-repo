package com.luna.console.design.strategy.domain;

import com.luna.console.design.strategy.behavior.FlyBehavior;
import com.luna.console.design.strategy.behavior.QuackBehavior;

public abstract class Duck {

    public Duck() {

        display();
    }

    private FlyBehavior fly;

    private QuackBehavior quack;

    public abstract void display();

    public void swim() {

        System.out.println("All ducks float, even decoys!");
    }

    public void performFly() {

        fly.fly();
    }

    public void performQuack() {

        quack.quack();
    }

    public void setFly(FlyBehavior fly) {

        this.fly = fly;
    }

    public void setQuack(QuackBehavior quack) {

        this.quack = quack;
    }
}
