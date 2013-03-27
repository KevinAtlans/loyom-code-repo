package com.luna.console.code;

public class 位运算符测试 {

    public static void main(String[] args) {

        testExclusiveOR();
        testNonOperator();
        testOr();
        testAnd();
    }

    /**
     * 异或运算符是用符号“^”表示的，其运算规律是： 两个操作数的位中，相同则结果为0，不同则结果为1。下面看一个简单的例子。
     */
    private static void testExclusiveOR() {

        // 分析上面的程序段：a 的值是15，转换成二进制为1111，
        // 而b 的值是2，转换成二进制为0010，
        // 根据异或的运算规律，可以得出其结果为1101 即13。
        int a = 15;
        int b = 2;
        System.out.println("a 与 b 异或的结果是：" + (a ^ b));
    }

    /**
     * 非运算符用符号“~”表示，其运算规律如下： 如果位为0，结果是1，如果位为1，结果是0，下面看一个简单例子。
     */
    private static void testNonOperator() {

        int a = 2;
        System.out.println("a 非的结果是：" + (~a));
    }

    /**
     * 或运算符用符号“|”表示，其运算规律如下： 两个位只要有一个为1，那么结果就是1，否则就为0，下面看一个简单的例子。
     */
    private static void testOr() {

        // a 的值是129，转换成二进制就是10000001，
        // 而b 的值是128，转换成二进制就是10000000，
        // 根据或运算符的运算规律，只有两个位有一个是1，结果才是1，可以知道结果就是10000001，即129。
        int a = 129;
        int b = 128;
        System.out.println("a 和 b 或的结果是：" + (a | b));
    }

    /**
     * 与运算符用符号“&”表示，其使用规律如下： 两个操作数中位都为1，结果才为1，否则结果为0，例如下面的程序段。
     */
    private static void testAnd() {

        // “a”的值是129，转换成二进制就是10000001，
        // 而“b”的值是128，转换成二进制就是10000000。
        // 根据与运算符的运算规律，只有两个位都是1，结果才是1，可以知道结果就是10000000，即128。
        int a = 129;
        int b = 128;
        System.out.println("a 和 b 与的结果是：" + (a & b));
    }
}
