package com.luna.console.mina.server.cache;

import java.util.Map;

import com.loyom.utils.Print;
import com.loyom.utils.StrUtil;
import com.luna.console.mina.server.bean.wizard.Player;
import com.luna.console.mina.server.utils.PlayerValueUtil;

/**
 * <p>
 * 人物等级所对应的基础值的缓存
 * </p>
 * 
 * @author kai
 * 
 */
public class LevelValueCache {

	private static Print p = Print.create(LevelValueCache.class);

	private static Map<String, String> cache = null;

	/**
	 * 通过人物等级和职业得到人物的基础属性值
	 * 
	 * @param level
	 * @return
	 */
	public static String getValueByLevel(Player player) {
		if (cache == null) {
			p.debug("Load level value...");
			cache = PlayerValueUtil.loadLevelValue();
		}
		String key = StrUtil.merge("level.", player.getCareer(), ".",
				player.getLevel());
		return cache.get(key);
	}
}
