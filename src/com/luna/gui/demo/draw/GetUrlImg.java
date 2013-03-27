package com.luna.gui.demo.draw;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class GetUrlImg {

    public void getUrlImg(String URLName, String target) throws Exception {

        int HttpResult = 0;
        URL url = new URL(URLName);
        URLConnection urlconn = url.openConnection();
        HttpURLConnection httpconn = (HttpURLConnection) urlconn;
        HttpResult = httpconn.getResponseCode();
        System.out.println(HttpResult);
        if (HttpResult != HttpURLConnection.HTTP_OK)
            System.out.print("--");
        else {
            int filesize = urlconn.getContentLength();
            System.out.println(filesize);
            BufferedInputStream bis = new BufferedInputStream(urlconn.getInputStream());
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(target));
            byte[] buffer = new byte[1024]; // 创建存放输入流的缓冲
            int num = -1; // 读入的字节数
            while (true) {
                num = bis.read(buffer); // 读入到缓冲区
                if (num == -1) {
                    bos.flush();
                    break; // 已经读完
                }
                bos.flush();
                bos.write(buffer, 0, num);
            }
            bos.close();
            bis.close();
        }
    }
}
