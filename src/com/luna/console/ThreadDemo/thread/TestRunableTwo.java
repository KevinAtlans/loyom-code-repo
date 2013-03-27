package com.luna.console.ThreadDemo.thread;

public class TestRunableTwo implements Runnable {

    @Override
    public void run() {

        System.out.println(Thread.currentThread().getName());
    }
}
