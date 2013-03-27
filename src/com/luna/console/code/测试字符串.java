package com.luna.console.code;

import static com.google.common.collect.Maps.newHashMap;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class 测试字符串 {

    public static void main(String[] args) {

        // String response =
        // "access_token=2d960b859c2422faca6cd7dd15a415c6&expires_in=604800&refresh_token=7cf07effa61926389443580d09dd7530&openid=3c3093e86905e5577196ce2f9681ea6e&name=Loyom_Kevin&nick=晒月亮de风&state=";
        // Map<String, String> params = parseTheResponseData(response);
        //
        // for (Entry<String, String> entry : params.entrySet()) {
        // System.out.println("Key:" + entry.getKey() + "\tValue:" +
        // entry.getValue());
        // }
        // testLastChart();
        // testTrim();

        // removeLast();
        // subString();
        //
        // replaceString();
        //
        // System.out.println("请输入您需要的圣诞树的大小<数字>");
        // Scanner input = new Scanner(System.in);
        // int a = input.nextInt();
        // ChristmasTree(2 * a);

        StringBuffer b = new StringBuffer("我去.");
        System.out.print(b.reverse());
    }

    private static void ChristmasTree(int n) {

        int i, j, k, m;
        for (i = 1; i <= n / 2; i++) {
            for (j = 1; j < n / 2 + i; j++) {
                if (j <= n / 2 - i)
                    System.out.print(" ");
                else {
                    if (j % 2 == 0)
                        System.out.print("$");
                    else
                        System.out.print("*");
                }
            }
            System.out.print("\n");
        }
        for (k = n / 2 + 1; k <= n - n / 4; k++) {
            for (m = 1; m <= n + 1; m++) {
                if (m != n / 2)
                    System.out.print(" ");
                else
                    System.out.print("||");
            }
            System.out.print("\n");
        }
        String d = "圣诞节快乐？";
        System.out.println("圣诞节快乐？");
    }

    private static Map<String, String> parseTheResponseData(String response) {

        Map<String, String> resultMap = newHashMap();
        String[] keyToValues = response.split("&");
        for (String tempStr : keyToValues) {
            String[] keyToValue = tempStr.split("=");
            if (keyToValue.length == 2) {
                resultMap.put(keyToValue[0], keyToValue[1]);
            }
        }
        return resultMap;
    }

    private static void testLastChart() {

        String str = ",1,2,";
        String[] strs = str.split(",");
        System.out.println(strs.length);
        for (String s : strs) {
            System.out.println(s);
        }

        System.out.println("====================================");
        List<String> metrics = Arrays.asList(str.split(","));
        System.out.println(metrics.size());
        // for (String s : metrics) {
        // if (s.isEmpty())
        // metrics.remove(s);
        // }

        for (String s : metrics) {
            System.out.println(s);
        }

        assert metrics.size() == 2 : "metrics size not 3~";
    }

    private static void testTrim() {

        String str = "1    1";

        if (str.trim().isEmpty()) {
            System.out.print("null");
        } else {
            System.out.print("not null");
        }
    }

    private static void removeLast() {

        String str = "1,123,1,2,12,31,23,12,3,213,21,321,3,21,321,321, ";

        String[] temp = str.split(",");

        System.out.print(str.substring(0, str.lastIndexOf(",")));
    }

    private static void replaceString() {

        StringBuffer uids = new StringBuffer("123,312,213,123,123,213,213,213213,31232132131,");
        uids.replace(uids.length() - 1, uids.length(), "");
        System.out.print(uids);
    }

    private static void subString() {

        String uids = "123,312,213,123,123,213,213,213213,31232132131,";
        if (uids.length() > 0)
            uids = uids.substring(0, uids.length() - 1);
        System.out.print(uids);
    }
}
