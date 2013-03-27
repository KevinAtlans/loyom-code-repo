package com.luna.console.code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 测试ListAndMap {

    /**
     * @param args
     */
    public static void main(String[] args) {

        Map<String, Integer> map = buildMap();

        List<String> list = new ArrayList<String>();
        list.addAll(map.keySet());
        Collections.sort(list);
        for (String str : list)
            System.out.print(str + "\t");
    }

    private static Map<String, Integer> buildMap() {

        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("1", 1);
        map.put("2", 1);
        map.put("3", 1);
        return map;
    }
}
