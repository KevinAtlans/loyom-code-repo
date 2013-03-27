package com.luna.console.design.adapter.adapter;

import com.luna.console.design.adapter.domain.Duck;
import com.luna.console.design.adapter.domain.Turkey;

public class TurkeyAdapter implements Duck {

    private Turkey turkey;

    public TurkeyAdapter(Turkey turkey) {

        this.turkey = turkey;
    }

    @Override
    public void quack() {

        turkey.gobble();
    }

    @Override
    public void fly() {

        // 因为火鸡的飞行距离短，所以想要达到鸭子的飞行距离就需要飞5次
        for (int i = 0; i < 5; i++)
            turkey.fly();
    }

    public Turkey getTurkey() {

        return turkey;
    }

    public void setTurkey(Turkey turkey) {

        this.turkey = turkey;
    }

}
