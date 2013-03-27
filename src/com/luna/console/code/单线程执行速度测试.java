package com.luna.console.code;

import java.util.Date;

public class 单线程执行速度测试 {

    /**
     * @param args
     */
    public static void main(String[] args) {

        int i = 1;

        Date temp = new Date();
        temp.setSeconds(temp.getSeconds() + 1);

        System.out.print(temp.toString());
        for (;;) {
            System.out.println(i);
            i += 1;
            Date temp1 = new Date();
            if (temp1.after(temp)) {
                break;
            }
        }
    }
}
