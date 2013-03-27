package com.luna.console.design.decorator;

import com.luna.console.design.decorator.decorator.Mocha;
import com.luna.console.design.decorator.decorator.Soy;
import com.luna.console.design.decorator.decorator.Whip;
import com.luna.console.design.decorator.module.Beverage;
import com.luna.console.design.decorator.module.Espresso;
import com.luna.console.design.decorator.module.HouseBlend;

public class DecoratorLauncher {

    /**
     * @param args
     */
    public static void main(String[] args) {

        Beverage es = new Espresso();
        System.out.println(String.format("%s: %s $", es.getDescription(), es.cost()));

        Beverage beverage = new HouseBlend();
        beverage = new Soy(beverage);
        beverage = new Mocha(beverage);
        beverage = new Whip(beverage);
        System.out.println(String.format("%s: %s $", beverage.getDescription(), beverage.cost()));
    }

}
