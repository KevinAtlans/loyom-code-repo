package com.luna.console.mina.server.utils;

import java.util.Map;

import com.google.gson.Gson;
import com.loyom.utils.PropertiesUtil;
import com.loyom.utils.StrUtil;
import com.luna.console.mina.server.bean.vo.EquipValue;
import com.luna.console.mina.server.bean.vo.LevelValue;
import com.luna.console.mina.server.bean.wizard.Player;
import com.luna.console.mina.server.cache.LevelValueCache;

/**
 * <p>
 * 玩家属性值计算工具类
 * </p>
 * 
 * @author kai
 * 
 */
public class PlayerValueUtil {

	/**
	 * 加载人物基础值
	 * 
	 * @return
	 */
	public static Map<String, String> loadLevelValue() {
		return PropertiesUtil
				.loadProperties("src/com/luna/console/mina/server/bean/vo/LevelValue.properties");
	}

	/**
	 * 通过人物等级和职业得到相应的基础值然后加到玩家自身上
	 * 
	 * @param player
	 */
	public static void buildBasePlayer(Player player) {
		if (player != null) {
			String value = LevelValueCache.getValueByLevel(player);
			if (StrUtil.isNotEmpty(value)) {
				Gson gson = new Gson();
				LevelValue lv = gson.fromJson(value, LevelValue.class);
				player.setBaseHP(lv.getBaseHP());
				player.setBaseMP(lv.getBaseMP());
				player.setBasePA(lv.getBasePA());
				player.setBaseMA(lv.getBaseMA());
				player.setBasePD(lv.getBasePD());
				player.setBaseMD(lv.getBaseMD());
				player.setRestoreHP(lv.getRestoreHP());
				player.setRestoreMP(lv.getRestoreMP());
				player.setSpeed(lv.getSpeed());
				player.setCurrentHP(player.getBaseHP());
				player.setCurrentMP(player.getBaseMP());
			}
		}
	}

	/**
	 * 通过玩家身上穿戴的装备计算出玩家属性值的加成然后设置到玩家自身上
	 * 
	 * @param player
	 */
	public static void buildEquipPlayer(Player player) {
		EquipValue equipValue = new EquipValue();
		equipValue.addToPlayer(player);
	}
}
