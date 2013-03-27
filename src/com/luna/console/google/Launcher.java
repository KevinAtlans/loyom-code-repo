package com.luna.console.google;

import com.luna.console.google.plus.Download;

public class Launcher {

    /**
     * @param args
     */
    public static void main(String[] args) {

        Download download = new Download();
        String str = download.downloadByGet("https://plus.google.com/+HTC/posts");
        System.out.print(str.matches(".*<div dir=\"ltr\" class=\"qFa wta\">.*</div>.*"));
    }
}
