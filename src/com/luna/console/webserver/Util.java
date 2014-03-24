package com.luna.console.webserver;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.loyom.utils.IntUtil;
import com.loyom.utils.StrUtil;

public class Util {

	public static int[] convertToInt(String str) {
		if (StrUtil.isNotEmpty(str)) {
			String[] strs = str.split(",");
			int[] result = new int[strs.length];
			for (int i = 0; i < strs.length; i++) {
				result[i] = IntUtil.getInt(strs[i]);
			}
			return result;
		}
		return new int[0];
	}

	public static List<String> fetchContent(String str) {
		Pattern pattern = Pattern.compile("<Line>(\\d+,?)+</Line>");
		Matcher matcher = pattern.matcher(str);
		List<String> strs = new ArrayList<String>();
		while (matcher.find()) {
			strs.add(matcher.group().replace("<Line>", "")
					.replace("</Line>", ""));
		}
		return strs;
	}
}
