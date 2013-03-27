package com.luna.console.code.dodge;

public class Person {

    private long id;

    private String nick;

    // 人物等级
    private int level;

    // 人物敏捷
    private double agile;

    // 人物的敏捷加成
    private double addition;

    public long getId() {

        return id;
    }

    public void setId(long id) {

        this.id = id;
    }

    public String getNick() {

        return nick;
    }

    public void setNick(String nick) {

        this.nick = nick;
    }

    public int getLevel() {

        return level;
    }

    public void setLevel(int level) {

        this.level = level;
    }

    public double getAgile() {

        return agile;
    }

    public void setAgile(double agile) {

        this.agile = agile;
    }

    public double getAddition() {

        return addition;
    }

    public void setAddition(double addition) {

        this.addition = addition;
    }

}
