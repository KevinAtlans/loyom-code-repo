package com.luna.console.design.adapter;

import com.luna.console.design.adapter.adapter.TurkeyAdapter;
import com.luna.console.design.adapter.domain.Duck;
import com.luna.console.design.adapter.domain.MallardDuck;
import com.luna.console.design.adapter.domain.WildTurkey;

public class AdapterLauncher {

    public static void main(String[] args) {

        MallardDuck duck = new MallardDuck();
        WildTurkey turkey = new WildTurkey();
        Duck turkeyAdapter = new TurkeyAdapter(turkey);

        System.out.println("The Turkey says...");
        turkey.gobble();
        turkey.fly();

        System.out.println("\nThe Duck says...");
        testDuck(duck);

        System.out.println("\nThe TurkeyAdapter says...");
        testDuck(turkeyAdapter);
    }

    public static void testDuck(Duck duck) {

        duck.quack();
        duck.fly();
    }
}
