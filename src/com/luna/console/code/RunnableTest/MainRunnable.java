package com.luna.console.code.RunnableTest;

public class MainRunnable implements Runnable {

    public void run() {

        while (true) {
            SubRunnable sub = new SubRunnable();
            synchronized (sub) {
                sub.run();
            }
        }
    }
}
