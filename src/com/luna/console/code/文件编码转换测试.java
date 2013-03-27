package com.luna.console.code;

import java.io.UnsupportedEncodingException;

public class 文件编码转换测试 {

    /**
     * @param args
     * @throws UnsupportedEncodingException
     */
    public static void main(String[] args) throws UnsupportedEncodingException {

        String str = "Ô¶µÀ¶øÀŽµÄÍ¬Ñ§²î²»¶à¶ŒÔ€¶šÔÚÍ¬Ò»ŒÒŸÆµê£¬¶øÉÙÊýŒžžöÓÐ³µµÄÍ¬Ñ§œ«žºÔðËÍËûÃÇ¹ýÈ¥¡£";

        // String str1 = "测试";

        String temp = new String(str.getBytes("UTF-8"), "GBK");

        System.out.print(temp);
    }
}
