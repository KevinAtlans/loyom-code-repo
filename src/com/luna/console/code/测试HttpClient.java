package com.luna.console.code;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

public class 测试HttpClient {

    public static void main(String[] args) {

        String uri = "http://www.rsx8.com?method=1213213&uids=212321321&accesstoken=1adasASDhHIhIUHI";

        Map<String, String> paramsMap = getParams(uri);
        for (Entry<String, String> entry : paramsMap.entrySet()) {
            System.out.println("Key:" + entry.getKey() + "\tValue:" + entry.getValue());
        }
    }

    public static String downloader(String uri) {

        String result = null;

        try {
            HttpPost post = new HttpPost(uri);
            HttpClient httpClient = new DefaultHttpClient();
            HttpResponse response = httpClient.execute(post);
            System.out.println(response.getStatusLine().getStatusCode());
            result = EntityUtils.toString(response.getEntity());
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    public static Map<String, String> getParams(String uri) {

        if (uri.indexOf("?") < 0)
            return null;

        Map<String, String> paramsMap = new HashMap<String, String>();

        String paramsUrl = uri.substring(uri.indexOf("?") + 1);
        String[] params = paramsUrl.split("&");
        for (String str : params) {
            paramsMap.put(str.substring(0, str.indexOf("=")), str.substring(str.indexOf("=") + 1));
        }
        return paramsMap;
    }
}
