package com.luna.console.mora;

public class Sprite {

    private String name;

    private int myType;

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public int getMyType() {

        return myType;
    }

    public void setMyType(int myType) {

        this.myType = myType;
    }

    // 出拳
    public int getType() {

        int type = (int) (Math.random() * 3);
        this.setMyType(type);
        return getType();
    }

    // 判断
    public int judge(int myType, int otherType) {

        switch (myType) {
        case 0:
            switch (otherType) {
            case 0:
                return 2;
            case 1:
                return 1;
            case 2:
                return 0;
            default:
                return 3;
            }
        case 1:
            switch (otherType) {
            case 0:
                return 0;
            case 1:
                return 2;
            case 2:
                return 1;
            default:
                return 3;
            }
        case 2:
            switch (otherType) {
            case 0:
                return 1;
            case 1:
                return 0;
            case 2:
                return 2;
            default:
                return 3;
            }
        default:
            return 3;
        }
    }
}
