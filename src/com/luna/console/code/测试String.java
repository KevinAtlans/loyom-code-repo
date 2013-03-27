package com.luna.console.code;

public class 测试String {

    /**
     * @param args
     */
    public static void main(String[] args) {

        String str = ".wav";
        System.out.print(isMusic(str));
        // switch (str) {
        // case "":
        // break;
        // }

    }

    private static boolean isMusic(String realFileName) {

        if (realFileName.lastIndexOf(".") <= 0) {
            return false;
        }
        String extension = realFileName.substring(realFileName.lastIndexOf(".") + 1);

        if (extension.isEmpty()) {
            return false;
        }

        String mp3 = "MP3";
        String WAV = "WAV";

        System.out.println(extension);
        if (mp3.toLowerCase().equals(extension.toLowerCase())
                || WAV.toLowerCase().equals(extension.toLowerCase())) {
            return true;
        }
        return false;
    }
}
