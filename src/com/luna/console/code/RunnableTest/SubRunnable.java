package com.luna.console.code.RunnableTest;

import java.util.Date;

public class SubRunnable implements Runnable {

    public void run() {

        try {
            System.out.println("SubRunnable:run-begin:" + new Date());
            wait(5000);
            System.out.println("SubRunnable:run-end:" + new Date());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
