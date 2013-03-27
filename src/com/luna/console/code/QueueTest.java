package com.luna.console.code;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class QueueTest {

    /**
     * @param args
     */
    public static void main(String[] args) {

        Queue<String> queue = new ConcurrentLinkedQueue<String>();
        queue.add("123");
        queue.add("123");
        queue.add("123");
        queue.add("123");
        queue.add("123");
        queue.add("123");
        queue.add("1234");
        queue.add("12345");
        queue.add("123456");

        System.out.println(queue.contains("123"));

        String str = queue.peek();
        while (str != null) {
            str = queue.poll();
            System.out.println(str);
        }
    }
}
