package com.luna.console.flyingchess;

public class MapData {

    private int[] n; // 存储各个直道的格数(拐点算在前一个直道，起点不算数)

    private int[] d; // 存储各个直道的延伸方向(0-右；1-下；2-左；3-上)

    private int count; // 有效格子的数目

    private int heriCount; // 地图的水平格数

    private int vertCount; // 地图的竖直格数

    private int startX; // 起点的水平坐标

    private int startY; // 起点的竖直坐标

    private int endX; // 终点的水平坐标

    private int endY; // 终点的竖直坐标

    private int[] lucky; // 幸运轮盘位置索引

    private int[] mine; // 地雷位置索引

    private int[] pause; // 暂停位置索引

    private int[] tunnel; // 时空隧道位置索引

    private static int[] nd0 = { // 默认的地图数据
    30, 0, 5, 1, 30, 2, 4, 1, 30, 0 };

    private static int[] nd1 = { 19, 0, 4, 3, 24, 2, 8, 1, 28, 0, 12, 3, 28, 2 };

    private static int[] nd2 = { 4, 0, 19, 1, 5, 0, 19, 3, 5, 0, 19, 1, 5, 0, 19, 3, 4, 0 };

    public static int mapCount = 3; // 现在包含的地图数目

    public int lineCount() {

        return n.length;
    }

    public int lineLength(int index) {

        return n[index];
    }

    public int lineDirection(int index) {

        return d[index];
    }

    public int startDirection() {

        return d[0];
    }

    public int endDirection() {

        return d[n.length - 1];
    }

    public int posCount() {

        return count;
    }

    public int heriCount() {

        return heriCount;
    }

    public int vertCount() {

        return vertCount;
    }

    public int startX() {

        return startX;
    }

    public int startY() {

        return startY;
    }

    public int endX() {

        return endX;
    }

    public int endY() {

        return endY;
    }

    public int luckyCount() {

        return lucky.length;
    }

    public int mineCount() {

        return mine.length;
    }

    public int pauseCount() {

        return pause.length;
    }

    public int tunnelCount() {

        return tunnel.length;
    }

    public int lucky(int index) {

        return lucky[index];
    }

    public int mine(int index) {

        return mine[index];
    }

    public int pause(int index) {

        return pause[index];
    }

    public int tunnel(int index) {

        return tunnel[index];
    }

    public MapData() {

        loadMap();
    }

    public MapData(int index) {

        loadMap(index);
    }

    public void loadMap() {

        loadData(0);
        defObject();
    }

    public void loadMap(int index) {

        if (index < 0 || index > mapCount)
            index = 0;
        loadData(index);
        randObject();
    }

    private void loadData(int index) {

        int[] nd = nd0;
        switch (index) {
        case 0:
            nd = nd0;
            break;
        case 1:
            nd = nd1;
            break;
        case 2:
            nd = nd2;
            break;
        }
        int left = 0, right = 1;
        int top = 0, bottom = 1;

        int nc = nd.length / 2;

        endX = 0;
        endY = 0;

        n = new int[nc];
        d = new int[nc];

        count = 1;
        for (int i = 0; i < nc; i++) {
            n[i] = nd[i * 2];
            d[i] = nd[i * 2 + 1];

            switch (d[i]) {
            case 0:
                endX += n[i];
                if (endX >= right)
                    right = endX + 1;
                break;
            case 1:
                endY += n[i];
                if (endY >= bottom)
                    bottom = endY + 1;
                break;
            case 2:
                endX -= n[i];
                if (endX < left)
                    left = endX;
                break;
            case 3:
                endY -= n[i];
                if (endY < top)
                    top = endY;
                break;
            }
            count += n[i];
        }

        startX = -left; // 设置起点水平坐标
        startY = -top; // 设置起点竖直坐标

        endX -= left; // 设置终点水平坐标
        endY -= top; // 设置终点竖直坐标

        heriCount = right - left;
        vertCount = bottom - top;
    }

    private void defObject() {

        lucky = new int[] { 6, 23, 40, 55, 69, 83 }; // 默认地图的幸运轮盘位置索引
        mine = new int[] { 5, 13, 17, 33, 38, 50, 64, 80, 94 }; // 默认地图的地雷位置索引
        pause = new int[] { 9, 27, 60, 93 }; // 默认地图的暂停位置索引
        tunnel = new int[] { 20, 25, 45, 63, 72, 88, 90 }; // 默认地图的时空隧道位置索引
    }

    private void randObject() {

        RandomObject ro = new RandomObject(count - 2);
        int n = count / 15; // count * 0.4 / 4 * 2/3

        lucky = new int[(int) (Math.random() * 10000) % n + n]; // 随机生成幸运轮盘的个数
        mine = new int[(int) (Math.random() * 10000) % n + n]; // 随机生成地雷的个数
        pause = new int[(int) (Math.random() * 10000) % n + n]; // 随机生成暂停的个数
        tunnel = new int[(int) (Math.random() * 10000) % n + n]; // 随机生成幸运轮盘的个数

        n = count - 2;
        for (int i = 0; i < lucky.length; i++) {
            lucky[i] = ro.outRandom() + 1;
        }
        for (int i = 0; i < mine.length; i++) {
            mine[i] = ro.outRandom() + 1;
        }
        for (int i = 0; i < pause.length; i++) {
            pause[i] = ro.outRandom() + 1;
        }
        for (int i = 0; i < tunnel.length; i++) {
            tunnel[i] = ro.outRandom() + 1;
        }
    }
}
