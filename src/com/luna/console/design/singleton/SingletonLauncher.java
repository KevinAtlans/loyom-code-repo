package com.luna.console.design.singleton;

public class SingletonLauncher {

    public static void main(String[] args) {

        Singleton si = Singleton.getInstance();
        si.setName("This is Singleton Class");
        System.out.println(si.getName());

        Singleton sin = Singleton.getInstance();
        System.out.println(sin.getName());
    }
}
