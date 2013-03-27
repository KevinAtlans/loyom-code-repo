package com.luna.console.design.adapter.domain;

public class MallardDuck implements Duck {

    @Override
    public void quack() {

        System.out.println("Quack");
    }

    @Override
    public void fly() {

        System.out.println("I'm flying...");
    }

}
