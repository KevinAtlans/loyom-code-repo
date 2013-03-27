package com.luna.console.design.factory.creator;

import com.luna.console.design.factory.product.ChicagoStyleCheesePizza;
import com.luna.console.design.factory.product.Pizza;

public class ChicagoPizzaStore extends PizzaStore {

    @Override
    public Pizza createPizza(String type) {

        if ("cheese".equals(type)) {
            return new ChicagoStyleCheesePizza();
        }
        return null;
    }

}
