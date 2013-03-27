package com.luna.console.code;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class 测试RenRen_API {

	// 这里的值设置为你的 Api Key
	private static String CLIENT_ID = "ca2acb1722a94216ab1b7435b1486f41";
	
	// 这里的值设置为你的 Secret Key
	private static String SECRET_KEY = "03014505f1a54411babfc1f3bfad7e79";
	
	// 这里设置为你的 access_token 可以不用设置
	private static String ACCESS_TOKEN = "194480|6.3fe8b076dfbe7d82d81b0dfc6710a1d4.2592000.1339830000-459923177";
	
	//这里设置你的回调地址(在应用基本信息里面:应用根域名填写:里面你所填写的值)
	private static String REDIRECT_URI = "http://www.rsx8.com";

	public static void main(String[] args) {
		
		String accessTokenURL = getAccessTokenURL();
		System.out.println("复制此链接到浏览器访问:" + accessTokenURL);
		System.out.print("得到Access_Token后请输入:");

		Scanner in = new Scanner(System.in);
		String access_token = in.next();
		ACCESS_TOKEN = access_token;

		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("fields", "albums_count");
//		paramMap.put("uid", "601110122");
//		String uri = getAPILink("users.getProfileInfo", paramMap);
		paramMap.put("page_id", "601110122");
		String uri = getAPILink("pages.getInfo", paramMap);
		
		System.out.print(download(uri, "POST"));
	}

	/**
	 * 通过链接下载数据并且返回
	 * 
	 * @param uri
	 *            需要下载的链接
	 * @param RequestMethod
	 *            下载请求方式:GET? POST?
	 * @return 下载后的数据 或者 错误信息
	 */
	public static String download(String uri, String RequestMethod) {
		System.out.println("需要下载的链接为:" + uri);

		String result = "";
		try {
			//转换String的url为URL类型的url
			URL url = new URL(uri);
			//得到网络链接
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			//设置访问网络方式
			conn.setRequestMethod(RequestMethod);
			//得到数据流
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

	/**
	 * 得到可以访问并返回JSON数据的链接
	 * 
	 * @param methodName
	 *            需要调用的API
	 * @param paramMap
	 *            需要的参数:以及实现的参数: Method=methodName, v=1.0,
	 *            access_token=ACCESS_TOKEN, format=JSON
	 * @return 可以执行的API
	 */
	public static String getAPILink(String methodName,
			Map<String, String> paramMap) {
		//设置链接的基本所需信息
		paramMap.put("method", methodName);
		paramMap.put("v", "1.0");
		paramMap.put("access_token", ACCESS_TOKEN);
		paramMap.put("format", "JSON");

		//设定链接地址
		String uri = "http://api.renren.com/restserver.do?";

		List<String> paramList = new ArrayList<String>(paramMap.size());
		// 1、参数格式化 并且 完成一部分链接的拼接
		for (Map.Entry<String, String> param : paramMap.entrySet()) {
			uri += param.getKey() + "=" + param.getValue() + "&";
			paramList.add(param.getKey() + "=" + param.getValue());
		}
		// 2、排序并拼接成一个字符串
		Collections.sort(paramList);
		StringBuffer buffer = new StringBuffer();
		for (String param : paramList) {
			buffer.append(param);
		}
		// 3、追加script key
		buffer.append(SECRET_KEY);
		// 4、将拼好的字符串转成MD5值
		try {
			java.security.MessageDigest md = java.security.MessageDigest
					.getInstance("MD5");
			StringBuffer result = new StringBuffer();
			try {
				for (byte b : md.digest(buffer.toString().getBytes("UTF-8"))) {
					result.append(Integer.toHexString((b & 0xf0) >>> 4));
					result.append(Integer.toHexString(b & 0x0f));
				}
			} catch (UnsupportedEncodingException e) {
				for (byte b : md.digest(buffer.toString().getBytes())) {
					result.append(Integer.toHexString((b & 0xf0) >>> 4));
					result.append(Integer.toHexString(b & 0x0f));
				}
			}
			uri += "sig=" + result.toString();
		} catch (NoSuchAlgorithmException ex) {
			ex.printStackTrace();
		}
		return uri;
	}

	/**
	 * 获得能获取Access_Token的链接
	 * 
	 * @return 得到Access_Token的获取链接
	 */
	public static String getAccessTokenURL() {
		String uri = String
				.format("https://graph.renren.com/oauth/authorize?client_id=%s&redirect_uri=%s&response_type=token",
						CLIENT_ID, REDIRECT_URI);
		return uri;
	}
}
