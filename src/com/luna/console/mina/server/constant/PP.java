package com.luna.console.mina.server.constant;

/**
 * <p>
 * 玩家职业
 * </p>
 * 
 * @author kai
 * 
 */
public class PP {

	public static final int WARRIOR = 1; // 战士
	public static final int WIZARD = 2; // 魔法师
	public static final int MEDICAL = 3; // 医生

	/**
	 * 通过对应的职业值得到相应的中文
	 * 
	 * @param profession
	 *            职业值
	 * @return 对应的中文职业
	 */
	public static String getProfession(int profession) {
		String str = "";
		switch (profession) {
		case WARRIOR:
			str = "战士";
			break;
		case WIZARD:
			str = "魔法师";
			break;
		case MEDICAL:
			str = "仙医";
			break;
		}
		return str;
	}
}
