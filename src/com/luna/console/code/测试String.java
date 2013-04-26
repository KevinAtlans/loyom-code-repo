package com.luna.console.code;

public class 测试String {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String regex = "^((https|http|ftp|rtsp|mms)?://)"
				+ "?(([0-9a-z_!~*'().&=+$%-]+: )?[0-9a-z_!~*'().&=+$%-]+@)?" // ftp的user@
				+ "(([0-9]{1,3}\\.){3}[0-9]{1,3}" // IP形式的URL- 199.194.52.184
				+ "|" // 允许IP和DOMAIN（域名）
				+ "([0-9a-z_!~*'()-]+\\.)*" // 域名- www.
				+ "([0-9a-z][0-9a-z-]{0,61})?[0-9a-z]\\." // 二级域名
				+ "[a-z]{2,6})" // first level domain- .com or .museum
				+ "(:[0-9]{1,4})?" // 端口- :80
				+ "((/?)|" // a slash isn't required if there is no file name
				+ "(/[0-9a-z_!~*'().;?:@&=+$,%#-]+)+/?)$";

		String url = "http:/asdasdasdd/www.asd.com/as";
		System.out.print(url.matches(regex));

		// String str = ".wav";
		// System.out.print(isMusic(str));
		// switch (str) {
		// case "":
		// break;
		// }

	}

	private static boolean isMusic(String realFileName) {

		if (realFileName.lastIndexOf(".") <= 0) {
			return false;
		}
		String extension = realFileName
				.substring(realFileName.lastIndexOf(".") + 1);

		if (extension.isEmpty()) {
			return false;
		}

		String mp3 = "MP3";
		String WAV = "WAV";

		System.out.println(extension);
		if (mp3.toLowerCase().equals(extension.toLowerCase())
				|| WAV.toLowerCase().equals(extension.toLowerCase())) {
			return true;
		}
		return false;
	}
}
