package com.luna.console.design.factory.product;

import java.util.ArrayList;

public abstract class Pizza {

    String name;

    String dough;

    String sauce;

    ArrayList<String> toppings = new ArrayList<String>();

    public void prepare() {

        System.out.println("Preparing " + name);
        System.out.println("Tossing dough...");
        System.out.println("Adding sauce..");
        System.out.println("Adding toppings...");
        for (String str : toppings) {
            System.out.println("   " + str);
        }
    }

    public void bake() {

        System.out.println("Bake for 25 minutes at 350...");
    }

    public void cut() {

        System.out.println("Cutting the pizza into diagonal slices");
    }

    public void box() {

        System.out.println("Place pizza in official PizzaStore box");
    }

    public String getName() {

        return name;
    }
}
