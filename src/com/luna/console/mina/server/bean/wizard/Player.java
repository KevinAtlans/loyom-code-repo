package com.luna.console.mina.server.bean.wizard;

import static com.google.common.collect.Lists.newArrayList;

import java.util.List;

import com.luna.console.mina.server.bean.Obj;
import com.luna.console.mina.server.bean.props.Equip;
import com.luna.console.mina.server.constant.PP;

/**
 * <p>
 * 玩家
 * </p>
 * 
 * @author kai
 * 
 */
public class Player extends Obj {
	private static final long serialVersionUID = 1L;

	private List<Equip> items = newArrayList();

	private int level = 0; // 等级
	private int career = PP.WIZARD; // 职业
	private int speed = 0; // 当前任人物速度,每小时多少米,如果骑上坐骑应使用坐骑的速度

	// 以下为机率属性,值不能大于100
	private int luckValue = 0; // 幸运值
	private int duck = 0; // 闪避值
	private int block = 0; // 格挡值
	private int hit = 100; // 命中

	// 以下为人物基础属性,由等级的提升逐步增长
	private int baseHP = 0; // 基础血量
	private int baseMP = 0; // 基础蓝量
	private int basePA = 0; // 基础物理攻击力
	private int baseMA = 0; // 基础魔法攻击力
	private int basePD = 0; // 基础物理防御力
	private int baseMD = 0; // 基础魔法防御力

	private int restoreHP = 0; // 每秒恢复的HP值
	private int restoreMP = 0; // 每秒恢复的MP值

	// 以下为人物的实际使用属性,由各种加成计算后的供实际战斗使用的值
	private int maxHP = 0; // 总血量
	private int currentHP = 0; // 当前血量

	private int maxMP = 0; // 总蓝量
	private int currentMP = 0; // 当前蓝量

	private int maxPA = 0; // Max Physical Attack : 最大物理攻击力
	private int minPA = 0; // Min Physical Attack : 最小物理攻击力

	private int maxMA = 0; // Max Magic Attack : 最大魔法攻击力
	private int minMA = 0; // Min Magic Attack : 最小魔法攻击力

	private int maxPD = 0; // Max Physical Defense : 最大物理防御力
	private int minPD = 0; // Min Physical Defense : 最小物理防御力

	private int maxMD = 0; // Max Magic Defense : 最大魔法防御力
	private int minMD = 0; // Min Magic Defense : 最小魔法防御力

	public Player() {

	}

	public List<Equip> getItems() {
		return items;
	}

	public void setItems(List<Equip> items) {
		this.items = items;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getCareer() {
		return career;
	}

	public void setCareer(int career) {
		this.career = career;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getLuckValue() {
		return luckValue;
	}

	public void setLuckValue(int luckValue) {
		this.luckValue = luckValue;
	}

	public int getDuck() {
		return duck;
	}

	public void setDuck(int duck) {
		this.duck = duck;
	}

	public int getBlock() {
		return block;
	}

	public void setBlock(int block) {
		this.block = block;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
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

	public int getMaxHP() {
		return maxHP;
	}

	public void setMaxHP(int maxHP) {
		this.maxHP = maxHP;
	}

	public int getCurrentHP() {
		return currentHP;
	}

	public void setCurrentHP(int currentHP) {
		this.currentHP = currentHP;
	}

	public int getMaxMP() {
		return maxMP;
	}

	public void setMaxMP(int maxMP) {
		this.maxMP = maxMP;
	}

	public int getCurrentMP() {
		return currentMP;
	}

	public void setCurrentMP(int currentMP) {
		this.currentMP = currentMP;
	}

	public int getMaxPA() {
		return maxPA;
	}

	public void setMaxPA(int maxPA) {
		this.maxPA = maxPA;
	}

	public int getMinPA() {
		return minPA;
	}

	public void setMinPA(int minPA) {
		this.minPA = minPA;
	}

	public int getMaxMA() {
		return maxMA;
	}

	public void setMaxMA(int maxMA) {
		this.maxMA = maxMA;
	}

	public int getMinMA() {
		return minMA;
	}

	public void setMinMA(int minMA) {
		this.minMA = minMA;
	}

	public int getMaxPD() {
		return maxPD;
	}

	public void setMaxPD(int maxPD) {
		this.maxPD = maxPD;
	}

	public int getMinPD() {
		return minPD;
	}

	public void setMinPD(int minPD) {
		this.minPD = minPD;
	}

	public int getMaxMD() {
		return maxMD;
	}

	public void setMaxMD(int maxMD) {
		this.maxMD = maxMD;
	}

	public int getMinMD() {
		return minMD;
	}

	public void setMinMD(int minMD) {
		this.minMD = minMD;
	}
}
