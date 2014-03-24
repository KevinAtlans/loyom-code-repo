package com.luna.console.code;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import com.loyom.utils.Print;

public class 时间测试 {

    public static void main(String[] args) {

    	Print.print(System.currentTimeMillis());
    	
        // test6();

        // test5();
        // test4();
        // test3();
        // test2();

    }

    private static void test6() {

        SimpleDateFormat format = new SimpleDateFormat("MM");

        Date date = new Date();

        String dateStr = format.format(date);

        System.out.print(dateStr);
    }

    private static void test5() {

        Date d = new Date();
        if (d instanceof Date) {
            System.out.println("Date");
        } else {
            System.out.println("not Date");
        }

        Object a = d.getTime();
        if (a instanceof String) {
            System.out.println("Date");
        } else {
            System.out.println("not Date");
        }
    }

    private static void test4() {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MMM.dd", Locale.ENGLISH);

        String date = simpleDateFormat.format(new Date());

        System.out.println(date);
    }

    private static void test3() {

        String idStr = "12321312312";
        long id = 12321312312L;

        if (idStr.equals(id + "")) {
            System.out.print("true");
        } else {
            System.out.print("false");
        }
    }

    @SuppressWarnings("deprecation")
    public static void test1() {

        Date d = new Date("2012/07/31 13:09:33");
        System.out.println(d.getTime());

        System.out.println(System.currentTimeMillis());
        System.out.println(new Date().getTime());

        for (int i = 0; i < 10000; i++) {

        }
        System.out.println(System.currentTimeMillis());
    }

    public static void test2() {

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Date date1 = new Date();
        System.out.println("1:" + format.format(date1));

        long time = date1.getTime();
        System.out.println("2:" + time);

        time = time - 24 * 60 * 60 * 1000;
        Date date2 = new Date(time);
        System.out.println("3:" + format.format(date2));

        long time1 = date2.getTime();
        System.out.println("4:" + time1);

        long tempTime = 1344838902857l;
        Date tempDate = new Date(tempTime);
        System.out.println("5:" + format.format(tempDate));
    }
}
