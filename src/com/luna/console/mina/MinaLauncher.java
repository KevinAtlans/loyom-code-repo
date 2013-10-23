package com.luna.console.mina;

import java.util.Map;

import com.loyom.utils.Print;
import com.luna.console.mina.server.MudServer;
import com.luna.console.mina.server.bean.vo.LevelValue;
import com.luna.console.mina.server.bean.wizard.Player;
import com.luna.console.mina.server.cache.LevelValueCache;
import com.luna.console.mina.server.constant.EP;
import com.luna.console.mina.server.utils.PlayerValueUtil;

public class MinaLauncher {

	public static void main(String[] args) {
		Player p = new Player();
		p.setLevel(1);
		PlayerValueUtil.buildPlayer(p);
		Print.println(p.getBaseHP());
		// try {
		//
		// MudServer server = new MudServer();
		// server.start();
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
	}
}
