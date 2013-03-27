package com.luna.console.flyingchess;

public class RandomObject { // 本类用于随机生成游戏格特殊对象的索引号

    private final int[] rd;

    private int count;

    public RandomObject(int nCount) {

        rd = new int[nCount];
        for (int i = 0; i < nCount; i++) {
            rd[i] = i;
        }
        count = nCount;
    }

    public int count() {

        return count;
    }

    public int outRandom() {

        int n = (int) (Math.random() * 10000) % count;
        int rand = rd[n];
        count--;
        for (int i = n; i < count; i++) {
            rd[i] = rd[i + 1];
        }
        return rand;
    }
}
