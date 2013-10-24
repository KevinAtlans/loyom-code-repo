package com.luna.console.mina.server.bean.vo;

import java.util.List;

import com.loyom.utils.CollectionUtil;
import com.loyom.utils.DoubleUtil;
import com.loyom.utils.IntUtil;
import com.luna.console.mina.server.bean.props.Equip;
import com.luna.console.mina.server.bean.wizard.Player;
import com.luna.console.mina.server.constant.EH;

/**
 * 装备值计算后的存放类
 * 
 * @author kai
 * 
 */
public class EquipValue {

	private int increaseHP = 0; // 增加总血量
	private int increaseMP = 0; // 增加总蓝量

	private int increaseRestoreHP = 0; // 增加每秒恢复的HP值
	private int increaseRestoreMP = 0; // 增加每秒恢复的MP值

	private int increaseMaxPA = 0; // Max Physical Attack : 增加最大物理攻击力
	private int increaseMinPA = 0; // Min Physical Attack : 最小物理攻击力

	private int increaseMaxMA = 0; // Max Magic Attack : 最大魔法攻击力
	private int increaseMinMA = 0; // Min Magic Attack : 最小魔法攻击力

	private int increaseMaxPD = 0; // Max Physical Defense : 最大物理防御力
	private int increaseMinPD = 0; // Min Physical Defense : 最小物理防御力

	private int increaseMaxMD = 0; // Max Magic Defense : 最大魔法防御力
	private int increaseMinMD = 0; // Min Magic Defense : 最小魔法防御力

	/**
	 * 计算装备可使用的属性后加到装备属性类里面
	 * 
	 * @param equip
	 *            穿在身上的装备
	 */
	private void addEquip(Equip equip) {
		double dp = getDurableProportion(equip);

		this.setIncreaseHP(this.getIncreaseHP()
				+ mul(equip.getIncreaseHP(), dp));
		this.setIncreaseMP(this.getIncreaseMP()
				+ mul(equip.getIncreaseMP(), dp));

		this.setIncreaseRestoreHP(this.getIncreaseRestoreHP()
				+ mul(equip.getIncreaseRestoreHP(), dp));
		this.setIncreaseRestoreMP(this.getIncreaseRestoreMP()
				+ mul(equip.getIncreaseRestoreMP(), dp));

		this.setIncreaseMaxPA(this.getIncreaseMaxPA()
				+ mul(equip.getIncreaseMaxPA(), dp));
		this.setIncreaseMinPA(this.getIncreaseMinPA()
				+ mul(equip.getIncreaseMinPA(), dp));

		this.setIncreaseMaxMA(this.getIncreaseMaxMA()
				+ mul(equip.getIncreaseMaxMA(), dp));
		this.setIncreaseMinMA(this.getIncreaseMinMA()
				+ mul(equip.getIncreaseMinMA(), dp));

		this.setIncreaseMaxPD(this.getIncreaseMaxPD()
				+ mul(equip.getIncreaseMaxPD(), dp));
		this.setIncreaseMinPD(this.getIncreaseMinPD()
				+ mul(equip.getIncreaseMinPD(), dp));

		this.setIncreaseMaxMD(this.getIncreaseMaxMD()
				+ mul(equip.getIncreaseMaxMD(), dp));
		this.setIncreaseMinMD(this.getIncreaseMinMD()
				+ mul(equip.getIncreaseMinMD(), dp));
	}

	/**
	 * <p>
	 * 计算装备可使用属性的比例
	 * <p>
	 * 主要通过装备的耗损度和品阶来计算可使用的程度
	 * 
	 * @param equip
	 *            装备
	 * @return 可使用比例
	 */
	private double getDurableProportion(Equip equip) {
		if (equip.getCurrentDurability() <= 0) {
			return 0;
		}
		double result = DoubleUtil.divide(equip.getCurrentDurability(),
				equip.getMaxDurability());
		double value = 0;
		if (result > 0.6) {
			value = 1;
		} else if (result > 0.3) {
			value = 0.5 + (DoubleUtil.divide(result, 2));
		} else {
			value = 0.1 + (DoubleUtil.divide(result, 2));
		}
		value += EH.getHP(equip.getHierarchy());
		return DoubleUtil.format(value, "#.0000");
	}

	/**
	 * 把玩家穿的装备可以增加的属性加到人物属性上
	 * 
	 * @param player
	 */
	public void addToPlayer(Player player) {
		buildEquips(player.getItems());
		if (player != null) {
			player.setMaxHP(IntUtil.add(player.getBaseHP(),
					this.getIncreaseHP()));
			player.setMaxMP(IntUtil.add(player.getBaseMP(),
					this.getIncreaseMP()));

			player.setRestoreHP(IntUtil.add(player.getRestoreHP(),
					this.getIncreaseRestoreHP()));
			player.setRestoreMP(IntUtil.add(player.getRestoreMP(),
					this.getIncreaseRestoreMP()));

			player.setMaxPA(IntUtil.add(this.getIncreaseMaxPA(),
					player.getBasePA()));
			player.setMinPA(IntUtil.add(this.getIncreaseMinPA(),
					player.getBasePA()));

			player.setMaxMA(IntUtil.add(this.getIncreaseMaxMA(),
					player.getBaseMA()));
			player.setMinMA(IntUtil.add(this.getIncreaseMinMA(),
					player.getBaseMA()));

			player.setMaxPD(IntUtil.add(this.getIncreaseMaxPD(),
					player.getBasePD()));
			player.setMinPD(IntUtil.add(this.getIncreaseMinPD(),
					player.getBasePD()));

			player.setMaxMD(IntUtil.add(this.getIncreaseMaxMD(),
					player.getBaseMD()));
			player.setMinMD(IntUtil.add(this.getIncreaseMinMD(),
					player.getBaseMD()));
		}
	}

	/**
	 * 合计装备一共可增加的属性值
	 * 
	 * @param equips
	 *            玩家穿在身上的装备
	 */
	private void buildEquips(List<Equip> equips) {
		if (CollectionUtil.isNotEmpty(equips)) {
			for (Equip current : equips) {
				addEquip(current);
			}
		}
	}

	private int mul(Object... objs) {
		double value = DoubleUtil.multiplication(objs);
		value = DoubleUtil.format(value, "#.0") + 0.5;
		return IntUtil.getInt(value);
	}

	public int getIncreaseHP() {
		return increaseHP;
	}

	public void setIncreaseHP(int increaseHP) {
		this.increaseHP = increaseHP;
	}

	public int getIncreaseMP() {
		return increaseMP;
	}

	public void setIncreaseMP(int increaseMP) {
		this.increaseMP = increaseMP;
	}

	public int getIncreaseRestoreHP() {
		return increaseRestoreHP;
	}

	public void setIncreaseRestoreHP(int increaseRestoreHP) {
		this.increaseRestoreHP = increaseRestoreHP;
	}

	public int getIncreaseRestoreMP() {
		return increaseRestoreMP;
	}

	public void setIncreaseRestoreMP(int increaseRestoreMP) {
		this.increaseRestoreMP = increaseRestoreMP;
	}

	public int getIncreaseMaxPA() {
		return increaseMaxPA;
	}

	public void setIncreaseMaxPA(int increaseMaxPA) {
		this.increaseMaxPA = increaseMaxPA;
	}

	public int getIncreaseMinPA() {
		return increaseMinPA;
	}

	public void setIncreaseMinPA(int increaseMinPA) {
		this.increaseMinPA = increaseMinPA;
	}

	public int getIncreaseMaxMA() {
		return increaseMaxMA;
	}

	public void setIncreaseMaxMA(int increaseMaxMA) {
		this.increaseMaxMA = increaseMaxMA;
	}

	public int getIncreaseMinMA() {
		return increaseMinMA;
	}

	public void setIncreaseMinMA(int increaseMinMA) {
		this.increaseMinMA = increaseMinMA;
	}

	public int getIncreaseMaxPD() {
		return increaseMaxPD;
	}

	public void setIncreaseMaxPD(int increaseMaxPD) {
		this.increaseMaxPD = increaseMaxPD;
	}

	public int getIncreaseMinPD() {
		return increaseMinPD;
	}

	public void setIncreaseMinPD(int increaseMinPD) {
		this.increaseMinPD = increaseMinPD;
	}

	public int getIncreaseMaxMD() {
		return increaseMaxMD;
	}

	public void setIncreaseMaxMD(int increaseMaxMD) {
		this.increaseMaxMD = increaseMaxMD;
	}

	public int getIncreaseMinMD() {
		return increaseMinMD;
	}

	public void setIncreaseMinMD(int increaseMinMD) {
		this.increaseMinMD = increaseMinMD;
	}
}
