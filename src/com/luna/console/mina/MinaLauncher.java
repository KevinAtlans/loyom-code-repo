package com.luna.console.mina;

import com.loyom.utils.Print;
import com.luna.console.mina.server.bean.wizard.Player;
import com.luna.console.mina.server.constant.PP;
import com.luna.console.mina.server.utils.PlayerValueUtil;

public class MinaLauncher {

	public static void main(String[] args) {
		Player p = new Player();
		p.setCareer(PP.WARRIOR);
		p.setLevel(1);
		PlayerValueUtil.buildBasePlayer(p);
		//PlayerValueUtil.buildEquipPlayer(p);
		Print.println(p);
		p.setLevel(2);
		PlayerValueUtil.buildBasePlayer(p);
		PlayerValueUtil.buildEquipPlayer(p);
		Print.println(p);
	}
}
