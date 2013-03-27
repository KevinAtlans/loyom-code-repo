package com.luna.console.tencent.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Map;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import sun.misc.BASE64Encoder;

public class SigEncrypt {

    public static String makeSIG(String method, String api_name, Map<String, String> paramMap) {

        try {
            String temp = getSourceURL(method, api_name, paramMap);
            return enctypt(temp);

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String getSourceURL(String method, String api_name, Map<String, String> paramMap)
            throws UnsupportedEncodingException {

        method = method.toUpperCase();
        api_name = encode(api_name);
        Object[] keys = paramMap.keySet().toArray();
        Arrays.sort(keys);

        StringBuffer bufferTemp = new StringBuffer();
        for (Object temp : keys) {
            bufferTemp.append(temp + "=");
            bufferTemp.append(paramMap.get(temp) + "&");
        }
        String sigTemp = bufferTemp.toString();
        sigTemp = sigTemp.substring(0, sigTemp.length() - 1);
        sigTemp = String.format("%s&%s&%s", method, api_name, encode(sigTemp));

        return sigTemp;
    }

    private static String enctypt(String str) throws UnsupportedEncodingException,
            InvalidKeyException, NoSuchAlgorithmException {

        Mac mac = Mac.getInstance(Constant.ENCTYPT_TYPE);
        String key = Constant.APP_KEY + "&";
        SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(Constant.ENCODING),
                mac.getAlgorithm());
        mac.init(secretKey);
        byte[] hash = mac.doFinal(str.getBytes(Constant.ENCODING));
        str = new BASE64Encoder().encode(hash);
        return str;
    }

    public static String encode(String str) throws UnsupportedEncodingException {

        return URLEncoder.encode(str, Constant.ENCODING).replace("+", "%20").replace("*", "%2A");
    }
}
