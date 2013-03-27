package com.luna.crawler;

import org.apache.log4j.Logger;

public class Launcher {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Logger log = Logger.getLogger(Launcher.class.getName());
		log.debug("this is {}");
		System.out.print("a");
	}
}
