package com.luna.console.design.factory.product;

public class ChicagoStyleCheesePizza extends Pizza {

    public ChicagoStyleCheesePizza() {

        name = "Chicago Style Deep Dish Cheese Pizza";
        dough = "Extra Thick Crust Dough";
        sauce = "Plum Tomato Sauce";
        toppings.add("Shredded Mozzarella Cheese");
    }

    @Override
    public void cut() {

        System.out.println("Cutting the Pizza into square slices");
    }
}
