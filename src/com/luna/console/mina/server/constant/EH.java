package com.luna.console.mina.server.constant;

/**
 * Equip Hierarchy 装备品阶
 * 
 * @author kai
 * 
 */
public class EH {

	/**
	 * 凡品
	 */
	public static final int GENERAL = 1;
	/**
	 * 中品
	 */
	public static final int MEDIUM = 2;
	/**
	 * 上品
	 */
	public static final int HIGHER = 3;
	/**
	 * 精品
	 */
	public static final int DELICATE = 4;
	/**
	 * 极品
	 */
	public static final int BEST = 5;
	/**
	 * 神器
	 */
	public static final int ARTIFACT = 6;

	/**
	 * 通过品阶得到中文
	 * @param eh 品阶值
	 * @return 对应的中文品阶
	 */
	public static String getHierarchy(int eh) {
		String str = "";
		switch (eh) {
		case GENERAL:
			str = "凡品";
			break;
		case MEDIUM:
			str = "中品";
			break;
		case HIGHER:
			str = "上品";
			break;
		case DELICATE:
			str = "精品";
			break;
		case BEST:
			str = "极品";
			break;
		case ARTIFACT:
			str = "神器";
			break;
		}
		return str;
	}

	/**
	 * 通过装备的品阶得到装备可享受的属性加成
	 * @param eh 装备品阶值
	 * @return 可加成的比例
	 */
	public static double getHP(int eh) {
		double h = 0;
		switch (eh) {
		case GENERAL:
			h = 0;
			break;
		case MEDIUM:
			h = 0.01;
			break;
		case HIGHER:
			h = 0.03;
			break;
		case DELICATE:
			h = 0.05;
			break;
		case BEST:
			h = 0.1;
			break;
		case ARTIFACT:
			h = 0.2;
			break;
		}
		return h;
	}
}
