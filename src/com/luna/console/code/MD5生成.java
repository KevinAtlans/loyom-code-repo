package com.luna.console.code;

import org.mortbay.jetty.security.Credential.MD5;

public class MD5生成 {

    /**
     * @param args
     */
    public static void main(String[] args) {

        System.out.print(MD5.digest("admin123"));
    }

}
