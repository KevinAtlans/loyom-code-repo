package com.luna.console.design.singleton;

public class Singleton {

    // volatile 关键字 确保
    // 当uniqueInstance变量被初始化成Singleton实例时，多个线程正确地处理uniqueInstance变量
    // Java 5 及以上版本支持
    private volatile static Singleton uniqueInstance;

    private String name;

    private Singleton() {

    }

    public static Singleton getInstance() {

        if (uniqueInstance == null) {
            synchronized (Singleton.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new Singleton();
                }
            }
        }
        return uniqueInstance;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }
}
