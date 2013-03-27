package com.luna.console.code;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Queue测试 {

    private final static Queue<String> userList = new ConcurrentLinkedQueue<String>();

    /**
     * @param args
     */
    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            System.out.println(getUser());

        }
    }

    private static void getUserToQueue() {

        for (int i = 1; i < 6; i++) {
            userList.add("this is " + i);
        }
    }

    private static String getUser() {

        String temp = userList.poll();
        if (temp == null) {
            getUserToQueue();
            temp = getUser();
        }
        return temp;
    }
}
