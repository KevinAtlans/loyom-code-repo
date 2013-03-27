package com.luna.console.code;

import com.luna.utils.DESPlus;

public class 加密解密算法测试 {

    /**
     * @param args
     */
    public static void main(String[] args) {

        try {
            String test = "xukai9213@qq.com";
            // DESPlus des = new DESPlus();//默认密钥
            DESPlus des = new DESPlus("updateAccessToken");// 自定义密钥
            System.out.println("加密前的字符：" + test);
            System.out.println("加密后的字符：" + des.encrypt(test));
            System.out.println("解密后的字符：" + des.decrypt(des.encrypt(test)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
