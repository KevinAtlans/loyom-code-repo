package com.luna.console.code;

import static com.google.common.collect.Lists.newArrayList;
import static com.google.common.collect.Sets.newHashSet;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class ArrayReflectTest {

    /**
     * @param args
     */
    @SuppressWarnings("rawtypes")
    public static void main(String[] args) throws Exception {

        int[] a = new int[] { 275, 273, 7, 402, 281, 400, 130, 401, 132, 404, 257, 399, 262, 21,
                20, 158, 260, 159, 264, 146, 26, 265, 390, 268, 269, 35, 41, 167, 166, 44, 164, 51,
                55, 188, 52, 179, 56, 62, 68, 204, 202, 351, 350, 349, 198, 74, 75, 84, 216, 219,
                82, 88, 100, 236, 101, 234, 368, 232, 108, 107, 224, 105, 114, 251, 121 };
        Arrays.sort(a);
        for (int temp : a) {
            System.out.print(temp + "\t");
        }

        System.out.println("===================================================");

        int[] b = new int[] { 275, 273, 7, 402, 281, 400, 130, 401, 132, 404, 257, 262, 21, 399,
                20, 158, 260, 159, 146, 264, 265, 26, 390, 268, 269, 35, 41, 167, 166, 44, 164, 51,
                55, 188, 52, 179, 56, 62, 68, 204, 202, 351, 350, 349, 198, 74, 75, 84, 216, 82,
                219, 88, 100, 236, 101, 234, 368, 232, 108, 107, 224, 105, 114, 251, 121 };
        Arrays.sort(b);
        for (int temp : b) {
            System.out.print(temp + "\t");
        }

        // test2(a);

        // test1();
    }

    private static void test2(int[] a) {

        List<String> listStr = newArrayList();
        listStr.add("123");
        listStr.add("123");
        listStr.add("1235");
        listStr.add("1236");

        for (String str : listStr) {
            System.out.print(str + "\t");
        }
        System.out.print("\n====================================\n");
        String[] s = listStr.toArray(new String[0]);
        for (String str : s) {
            System.out.print(str + "\t");
        }
        System.out.print("\n====================================\n");
        Arrays.sort(a);
        List<Integer> te = newArrayList();
        for (int temp : a) {
            System.out.print(temp + "\t");
            te.add(temp);
        }

        Set<Integer> strSet = newHashSet(te);

        for (int str : strSet) {
            // System.out.print(str + "\t");
        }
    }

    private static void test1() throws ClassNotFoundException {

        Class classType = Class.forName("java.lang.String");
        Object array = Array.newInstance(classType, 10); // 指定数组的类型和大小
        // 对索引为5的位置进行赋值
        Array.set(array, 5, "hello");
        String s = (String) Array.get(array, 5);
        System.out.println("A:" + s);
        // 循环遍历这个动态数组
        for (int i = 0; i < ((String[]) array).length; i++) {
            String str = (String) Array.get(array, i);
            System.out.println(i + ":" + str);
        }
    }
}
