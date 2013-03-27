package com.luna.console.design.command.object;

public class Light {

    private String name;

    public Light(String name) {

        this.name = name;
    }

    public void on() {

        System.out.println(String.format("The %s is on!", this.name));
    }

    public void off() {

        System.out.println(String.format("The %s is off!", this.name));
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

}
