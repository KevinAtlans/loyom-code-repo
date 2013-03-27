package com.luna.console.code;

public class 判断测试 {

    /**
     * @param args
     */
    public static void main(String[] args) {

        // &&的两边条件， 如果条件1是否 那么就不会去看条件2是真还是假
        // &的两边条件是都要去判断 然后在做运算得出是真还是假

        // trueOrFalse();
        // trueAndFalse();
        falseAndTrue();
        // trueAFalse();
        // trueATrue();
        // falseATrue();
    }

    private static void trueATrue() {

        if (isTrue(1) & isTrue(1)) {
            System.out.println("true & true");
        }
    }

    private static void falseATrue() {

        if (isTrue(0) & isTrue(1)) {
            System.out.println("false & true");
        }
    }

    private static void trueAFalse() {

        if (isTrue(1) & isTrue(0)) {
            System.out.println("true & false");
        }
    }

    private static void trueAndFalse() {

        if (isTrue(1) && isTrue(0)) {
            System.out.println("true && false");
        }
    }

    private static void falseAndTrue() {

        if (isTrue(0) && isTrue(1)) {
            System.out.println("false && true");
        }
    }

    private static void trueOrFalse() {

        if (isTrue(1) || isTrue(0)) {
            System.out.println("true || false");
        }
    }

    private static boolean isTrue(int isTrue) {

        System.out.println("============");
        System.out.println(" ||   1   ||");
        System.out.println("============");

        if (isTrue == 1)
            return true;
        return false;
    }
}
