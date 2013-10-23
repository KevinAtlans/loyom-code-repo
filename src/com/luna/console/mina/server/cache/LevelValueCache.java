package com.luna.console.mina.server.cache;

import java.util.Map;

import com.loyom.utils.Print;
import com.loyom.utils.StrUtil;
import com.luna.console.mina.server.utils.PlayerValueUtil;

public class LevelValueCache {

	private static Print p = Print.create(LevelValueCache.class);

	private static Map<String, String> cache = null;

	public static String getValueByLevel(int level) {
		if (cache == null) {
			p.debug("Load level value...");
			cache = PlayerValueUtil.loadLevelValue();
		}
		String key = StrUtil.merge("level.", level);
		return cache.get(key);
	}
}
