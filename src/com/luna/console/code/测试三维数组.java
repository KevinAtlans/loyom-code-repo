package com.luna.console.code;

public class 测试三维数组 {

    /**
     * @param args
     */
    public static void main(String[] args) {

        test1();
    }

    public static void test1() {

        String index = "A";

        String[][][] str = new String[3][3][3];

        for (int i = 0; i < str.length; i++) {
            String[][] str1 = str[i];
            for (int j = 0; j < str1.length; j++) {
                String[] str2 = str1[i];
                for (int l = 0; l < str2.length; l++) {
                    str2[l] = index;
                    index = index + "A";
                }
                str1[j] = str2;
            }
            str[i] = str1;
        }

        for (String[][] str1 : str)
            for (String[] str2 : str1)
                for (String str3 : str2)
                    System.out.println(str3);
    }
}
