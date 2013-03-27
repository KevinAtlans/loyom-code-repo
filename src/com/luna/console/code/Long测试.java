package com.luna.console.code;

public class Long测试 {

    /**
     * @param args
     */
    public static void main(String[] args) {

        // test1();
        // test2();

        String time = "12312.3";
        Long t = Double.valueOf(time).longValue();
        System.out.print(t);

    }

    private static void test2() {

        String id = "34";
        Long ids = 34L;

        if (id.equals(String.valueOf(null))) {
            System.out.print("==");
        } else {
            System.out.print("!=");
        }
    }

    private static void test1() {

        System.out.println(System.currentTimeMillis());

        System.out.println(Long.MAX_VALUE);

        Long[] longArray = new Long[] { 1L, 2L, 4L, 5L, null };
        for (Long l : longArray) {
            System.out.println(l);
        }
    }
}
