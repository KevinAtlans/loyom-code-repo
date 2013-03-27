package com.luna.console.code;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Properties读取测试 {

    private static String param1;

    private static String param2;

    static {
        Properties prop = new Properties();
        InputStream in;
        try {
            in = new BufferedInputStream(new FileInputStream("src/MyProperties.properties"));
            prop.load(in);
            param1 = prop.getProperty("param1").trim();
            param2 = prop.getProperty("param2") == null ? "" : prop.getProperty("param2").trim();
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 私有构造方法，不需要创建对象
     */
    private Properties读取测试() {

    }

    public static String getParam1() {

        return param1;
    }

    public static String getParam2() {

        return param2;
    }

    public static void main(String args[]) {

        System.out.println(getParam1());
        System.out.println(getParam2());
    }
}
