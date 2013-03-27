package com.luna.console.ThreadDemo.thread;

public class TestRunableOne implements Runnable {

    @Override
    public void run() {

        System.out.println(Thread.currentThread().getName());
    }
}
