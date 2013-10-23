package com.luna.console.mina.server.utils;

import java.util.Map;

import com.google.gson.Gson;
import com.loyom.utils.PropertiesUtil;
import com.loyom.utils.StrUtil;
import com.luna.console.mina.server.bean.vo.LevelValue;
import com.luna.console.mina.server.bean.wizard.Player;
import com.luna.console.mina.server.cache.LevelValueCache;

public class PlayerValueUtil {

	/**
	 * 
	 * @return
	 */
	public static Map<String, String> loadLevelValue() {
		return PropertiesUtil
				.loadProperties("src/com/luna/console/mina/server/bean/vo/LevelValue.properties");
	}

	/**
	 * 
	 * @param player
	 */
	public static void buildPlayer(Player player) {
		if (player != null) {
			String value = LevelValueCache.getValueByLevel(player.getLevel());
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
			}
		}
	}
}
