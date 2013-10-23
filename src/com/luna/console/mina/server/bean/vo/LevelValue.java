package com.luna.console.mina.server.bean.vo;


/**
 * 根据等级得到基础属性值
 * 
 * @author kai
 * 
 */
public class LevelValue {

	private LevelValue() {
	}

	private int level = 0; // 等级
	private int speed = 0; // 速度
	private int baseHP = 0; // 基础血量
	private int baseMP = 0; // 基础蓝量
	private int basePA = 0; // 基础物理攻击力
	private int baseMA = 0; // 基础魔法攻击力
	private int basePD = 0; // 基础物理防御力
	private int baseMD = 0; // 基础魔法防御力

	private int restoreHP = 0; // 每秒恢复的HP值
	private int restoreMP = 0; // 每秒恢复的MP值

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getBaseHP() {
		return baseHP;
	}

	public void setBaseHP(int baseHP) {
		this.baseHP = baseHP;
	}

	public int getBaseMP() {
		return baseMP;
	}

	public void setBaseMP(int baseMP) {
		this.baseMP = baseMP;
	}

	public int getBasePA() {
		return basePA;
	}

	public void setBasePA(int basePA) {
		this.basePA = basePA;
	}

	public int getBaseMA() {
		return baseMA;
	}

	public void setBaseMA(int baseMA) {
		this.baseMA = baseMA;
	}

	public int getBasePD() {
		return basePD;
	}

	public void setBasePD(int basePD) {
		this.basePD = basePD;
	}

	public int getBaseMD() {
		return baseMD;
	}

	public void setBaseMD(int baseMD) {
		this.baseMD = baseMD;
	}

	public int getRestoreHP() {
		return restoreHP;
	}

	public void setRestoreHP(int restoreHP) {
		this.restoreHP = restoreHP;
	}

	public int getRestoreMP() {
		return restoreMP;
	}

	public void setRestoreMP(int restoreMP) {
		this.restoreMP = restoreMP;
	}
}
