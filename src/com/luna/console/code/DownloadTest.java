package com.luna.console.code;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

import com.loyom.constants.Encoding;
import com.loyom.download.Download;
import com.loyom.download.DownloadResponse;
import com.loyom.utils.Print;

public class DownloadTest {
	public static void main(String[] args) {
		// Map<String, String> params = new HashMap<String, String>();
		// params.put("__EVENTTARGET", "DropDownListEvents");
		// params.put("DropDownListEvents", "14031");
		//
		//
		// DownloadResponse response = Download.post(
		// "http://www.lottery.gov.cn/lottery/dlt/Detail.aspx",
		// Encoding.UTF8, params);
		// Print.print(response);
		
		DecimalFormat df = new DecimalFormat("##.00000000000000000000");
		String dStr = df.format(3.0030029847694095E-4);
		
		Print.println(Double.parseDouble("3.0030029847694095E-4"));
		Print.println(dStr);
	}
}
