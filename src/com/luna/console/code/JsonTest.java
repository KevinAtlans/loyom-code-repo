package com.luna.console.code;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

public class JsonTest {

    /**
     * @param args
     */
    public static void main(String[] args) {

        // testJson();

        String json = "{\"deliveryTag\":\"1\",\"isLastMessage\":\"true\",\"javaScriptObject\":\"jsObject\",\"pageNumber\":\"1\",\"payload\":\"\",\"subsourceId\":\"null\",\"url\":\"http://nymag.com/daily/intel/2012/12/fox-news-puts-karl-rove-on-the-bench.html\"} ";

        JsonConfig con = new JsonConfig();
        JSONObject jsonobj = JSONObject.fromObject(json, con);

        System.out.print(jsonobj.get("javaScriptObject"));
    }

    private static void testJson() {

        JSONObject json = new JSONObject();
        json.accumulate("name", "Kevin");
        json.accumulate("level", "55");
        json.accumulate("sign", "this is json sign...");
        json.accumulate("head", "images/head.jpg");
        System.out.print(json.toString());
    }
}
