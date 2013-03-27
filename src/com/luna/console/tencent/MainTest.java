package com.luna.console.tencent;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.luna.console.tencent.utils.Constant;
import com.luna.console.tencent.utils.SigEncrypt;

public class MainTest {

    public static void main(String[] args) throws UnsupportedEncodingException,
            NoSuchAlgorithmException, InvalidKeyException {

        String api_name = "/v3/user/get_info";
        Map<String, String> params = new HashMap<String, String>();
        params.put("appid", Constant.APP_ID);
        String sig = SigEncrypt.makeSIG("GET", api_name, params);

        String url = String.format("%s%s%s%s", "http://", Constant.TEST_IP, api_name, "?");

        StringBuffer sb = new StringBuffer();

        for (Entry<String, String> val : params.entrySet()) {
            sb.append(String.format("%s=%s&", val.getKey(), val.getValue()));
        }
        sb.append(String.format("%s=%s", "sig", sig));

        url = url + SigEncrypt.encode(sb.toString());

        String result = download(url, Constant.METHOD_GET);

        System.out.print(result);
    }

    public static String download(String uri, String RequestMethod) {

        System.out.println("需要下载的链接为:" + uri);

        String result = "";
        try {
            // 转换String的url为URL类型的url
            URL url = new URL(uri);
            // 得到网络链接
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            // 设置访问网络方式
            conn.setRequestMethod(RequestMethod);

            // 得到数据流
            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            String line = null;
            while ((line = reader.readLine()) != null) {
                result += line;
            }
            reader.close();
            return result;

        } catch (IOException e) {
            result = e.getMessage();
            System.out.println(e.getMessage());
        }
        return result;
    }
}
