package com.luna.console.code;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import org.apache.catalina.util.Base64;

import sun.misc.BASE64Encoder;

public class 编码实验室 {

    private static char[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/="
            .toCharArray();

    public static char[] encode(byte[] data) {

        char[] out = new char[((data.length + 2) / 3) * 4];

        for (int i = 0, index = 0; i < data.length; i += 3, index += 4) {
            boolean quad = false;
            boolean trip = false;

            int val = (0xFF & data[i]);
            val <<= 8;
            if ((i + 1) < data.length) {
                val |= (0xFF & data[i + 1]);
                trip = true;
            }
            val <<= 8;
            if ((i + 2) < data.length) {
                val |= (0xFF & data[i + 2]);
                quad = true;
            }
            out[index + 3] = alphabet[(quad ? (val & 0x3F) : 64)];
            val >>= 6;
            out[index + 2] = alphabet[(trip ? (val & 0x3F) : 64)];
            val >>= 6;
            out[index + 1] = alphabet[val & 0x3F];
            val >>= 6;
            out[index + 0] = alphabet[val & 0x3F];
        }
        return out;
    }

    public static String getBase64(String str) {

        if (str == null || str.isEmpty())
            return null;
        return (new BASE64Encoder()).encode(str.getBytes());
    }

    public static void main(String[] args) throws UnsupportedEncodingException {

        String temp = "t2c0g0d1p";

        System.out.println(Base64.encode(temp.getBytes()));

        String str = "淘宝网";

        System.out.println(getBase64(str));

        String keyWord = URLDecoder.decode(
                "0100641F464F0BB508E93E05C7C3E0872AAA64-B6EC-D4C2-87D3-DF70B0D977F4", "gb2312");

        System.out.println(keyWord);

        String urlStr = URLEncoder.encode("秦时明月", "gb2312");

        System.out.println(urlStr);
    }
}
