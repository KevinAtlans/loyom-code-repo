package com.luna.console.code;

public class Integer测试 {

    /**
     * @param args
     */
    public static void main(String[] args) {

        testRecursion(10);
    }

    /**
     * 测试递归
     * 
     * @param num
     */
    public static void testRecursion(int num) {

        System.out.print(num + " ");
        if (num > 0)
            testRecursion(num - 1);
        else
            System.out.print("<----->");
        System.out.print(" " + num);
    }
}
