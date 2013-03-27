package com.luna.console.code;

import java.io.UnsupportedEncodingException;

public class 异常测试 {

    /**
     * @param args
     */
    public static void main(String[] args) {

        test();
    }

    private static void test() {

        String str = "asdsadasd";
        try {
            String temp = new String(str.getBytes("UTF-8"), "GBK");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException();
        }
    }
}
