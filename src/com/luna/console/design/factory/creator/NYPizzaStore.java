package com.luna.console.design.factory.creator;

import com.luna.console.design.factory.product.NYStyleCheesePizza;
import com.luna.console.design.factory.product.Pizza;

public class NYPizzaStore extends PizzaStore {

    @Override
    public Pizza createPizza(String type) {

        if ("cheese".equals(type)) {
            return new NYStyleCheesePizza();
        }
        return null;
    }

}
