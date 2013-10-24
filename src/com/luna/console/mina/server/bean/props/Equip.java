package com.luna.console.mina.server.bean.props;

import com.luna.console.mina.server.bean.Obj;
import com.luna.console.mina.server.constant.EH;
import com.luna.console.mina.server.constant.EP;

/**
 * <p>
 * 装备
 * </p>
 * 
 * @author kai
 * 
 */
public class Equip extends Obj {

	private static final long serialVersionUID = 1L;

	// 以下是装备的自身属性,会限制装备的使用
	private int needLevel = 0; // 装备此装备的必须等级
	private int hierarchy = EH.GENERAL; // 装备品阶
	private int position = EP.HELMET; // 装备位置

	private int maxDurability = 0; // 此装备的最大耐久度
	private int currentDurability = 0; // 此装备的当前耐久度

	// 以下为装备可以给玩家增加的各种属性,当装备被装上的时候需要重新计算玩家的各个属性
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
	 * 将另外一件装备的属性附加到此装备上
	 * 
	 * @param e
	 */
	public void addEquip(Equip e) {

	}

	public int getNeedLevel() {
		return needLevel;
	}

	public void setNeedLevel(int needLevel) {
		this.needLevel = needLevel;
	}

	public int getHierarchy() {
		return hierarchy;
	}

	public void setHierarchy(int hierarchy) {
		this.hierarchy = hierarchy;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public int getMaxDurability() {
		return maxDurability;
	}

	public void setMaxDurability(int maxDurability) {
		this.maxDurability = maxDurability;
	}

	public int getCurrentDurability() {
		return currentDurability;
	}

	public void setCurrentDurability(int currentDurability) {
		this.currentDurability = currentDurability;
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
