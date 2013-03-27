package com.luna.console.design.factory;

import com.luna.console.design.factory.creator.ChicagoPizzaStore;
import com.luna.console.design.factory.creator.NYPizzaStore;
import com.luna.console.design.factory.creator.PizzaStore;
import com.luna.console.design.factory.product.Pizza;

public class FactoryLauncher {

    /**
     * @param args
     */
    public static void main(String[] args) {

        PizzaStore nyStore = new NYPizzaStore();
        Pizza pizza = nyStore.orderPizza("cheese");
        System.out.println("Ethan ordered a " + pizza.getName());

        System.out.println();
        PizzaStore chicagoStore = new ChicagoPizzaStore();
        pizza = chicagoStore.orderPizza("cheese");
        System.out.println("Joel ordered a " + pizza.getName());
    }
}
