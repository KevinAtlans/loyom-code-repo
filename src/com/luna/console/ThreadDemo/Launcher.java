package com.luna.console.ThreadDemo;

import com.luna.console.ThreadDemo.thread.TestRunableOne;

public class Launcher {

    /**
     * @param args
     */
    public static void main(String[] args) {

        TestRunableOne tro = new TestRunableOne();

        Thread thread = new Thread(tro);

        System.out.println("线程启动之前--->" + thread.isAlive());
        thread.start();
        System.out.println("线程启动之后--->" + thread.isAlive());
    }

}
