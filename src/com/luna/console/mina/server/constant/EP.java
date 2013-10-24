package com.luna.console.mina.server.constant;

/**
 * <p>
 * Equip Position
 * </p>
 * <b>装备位置的常量类:</b> <br/>
 * 用于定义装备在人物身上的位置
 * 
 * @author kai
 */
public class EP {
	/**
	 * 头盔
	 */
	public static final int HELMET = 0;
	/**
	 * 耳环
	 */
	public static final int EARRING = 1;
	/**
	 * 项链
	 */
	public static final int NECKLACE = 2;
	/**
	 * 衣服
	 */
	public static final int CLOTHES = 3;
	/**
	 * 手镯
	 */
	public static final int BRACELET = 4;
	/**
	 * 戒指
	 */
	public static final int RING = 5;
	/**
	 * 手套
	 */
	public static final int GLOVES = 6;
	/**
	 * 武器
	 */
	public static final int WEAPON = 7;
	/**
	 * 裤子
	 */
	public static final int TROUSERS = 8;
	/**
	 * 鞋子
	 */
	public static final int SHOES = 9;

	/**
	 * 通过装备的位置值得到装备的中文位置
	 * @param ep 位置值
	 * @return 对应的中文位置
	 */
	public static String getEquip(int ep) {
		String str = "";
		switch (ep) {
		case HELMET:
			str = "头盔";
			break;
		case EARRING:
			str = "耳环";
			break;
		case NECKLACE:
			str = "项链";
			break;
		case CLOTHES:
			str = "衣服";
			break;
		case BRACELET:
			str = "手镯";
			break;
		case RING:
			str = "戒指";
			break;
		case GLOVES:
			str = "手套";
			break;
		case WEAPON:
			str = "武器";
			break;
		case TROUSERS:
			str = "裤子";
			break;
		case SHOES:
			str = "鞋子";
			break;
		}
		return str;
	}
}
