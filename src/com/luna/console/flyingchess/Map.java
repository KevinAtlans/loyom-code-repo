package com.luna.console.flyingchess;

public class Map {

    static private char ch[] = { '※', '¤', '★', '■', '〓', 'Ａ', 'Ｂ', '◎', '　' };

    static private char ar[] = { '→', '↓', '←', '↑' };

    private final int player[] = new int[2]; // 玩家1和2的当前位置

    private MapData md; // 地图数据对象

    private char mapChar[]; // 数组 mapChar[] 用于地图的绘制，各元素取值的含义如下：
                            // (※) --> (0)普通位置，绘制地图时输出两个英文冒号::
                            // (¤) --> (1)幸运轮盘
                            // (★) --> (2)地雷位置
                            // (■) --> (3)暂停位置
                            // (〓) --> (4)时空隧道位置
                            // (Ａ) --> (5)玩家1的位置
                            // (Ｂ) --> (6)玩家2的位置
                            // (◎) --> (7)玩家1和2在同一个位置，绘制地图时输出AB
                            // (　) --> (8)不在地图上的空白填充点(全角空格)

    private int mapIndex[]; // 地图各位置在mapChar[]数组中对应的索引号

    private int mapValue[]; // 地图各位置的值

    private void loadMap() { // 载入地图数据

        mapChar = new char[md.heriCount() * md.vertCount()];

        mapValue = new int[md.posCount()];
        mapIndex = new int[md.posCount()];

        mapIndex[0] = md.heriCount() * md.startY() + md.startX();
        int i = 1, j, offset, iNext = 1;

        for (j = 0; j < md.lineCount(); j++) {
            iNext += md.lineLength(j);
            offset = 0;
            switch (md.lineDirection(j)) {
            case 0:
                offset = 1;
                break;
            case 1:
                offset = md.heriCount();
                break;
            case 2:
                offset = -1;
                break;
            case 3:
                offset = -md.heriCount();
                break;
            }
            while (i < iNext) {
                mapIndex[i] = mapIndex[i - 1] + offset;
                i++;
            }
        }

        for (i = 0; i < mapValue.length; i++) {
            mapValue[i] = 0;
        }
        for (i = 0; i < md.luckyCount(); i++) {
            mapValue[md.lucky(i)] = 1;
        } // 设置幸运轮盘位置
        for (i = 0; i < md.mineCount(); i++) {
            mapValue[md.mine(i)] = 2;
        } // 设置地雷位置
        for (i = 0; i < md.pauseCount(); i++) {
            mapValue[md.pause(i)] = 3;
        } // 设置暂停位置
        for (i = 0; i < md.tunnelCount(); i++) {
            mapValue[md.tunnel(i)] = 4;
        } // 设置时空隧道位置

        for (i = 0; i < mapChar.length; i++) {
            mapChar[i] = ch[8];
        }

        mapChar[mapIndex[0]] = ch[7];
        for (i = 1; i < mapValue.length - 1; i++) {
            mapChar[mapIndex[i]] = ch[mapValue[i]];
        }
        mapChar[mapIndex[mapIndex.length - 1]] = ar[md.endDirection()];

        player[1] = player[0] = 0;
    }

    public void initial() {

        md = new MapData();
        loadMap();
    }

    public void initial(int index) {

        md = new MapData(index);
        loadMap();
    }

    public int playerPos(int p) { // 取得玩家的当前位置

        if (p < 0 || p > 1)
            return -1; // 非法参数
        return player[p];
    }

    public int mapValue(int i) { // 取得i位置的地图值

        if (i < 0 || i >= md.posCount())
            return -1; // 非法参数
        return mapValue[i];
    }

    public int posCount() { // 返回当前地图的格子数目

        return md.posCount();
    }

    public void printMap() { // 输出当前的地图状态

        System.out.println("");
        int i, j, k = 0;
        for (i = 0; i < md.vertCount(); i++) {
            // System.out.print((i > 0) ? "　　　　　　" : "　起点　→　");
            for (j = 0; j < md.heriCount(); j++) {
                char c = mapChar[k++];
                switch (c) {
                case '※':
                    System.out.print("::");
                    break;
                case '◎':
                    System.out.print("AB");
                    break;
                default:
                    System.out.print(c);
                }
            }
            // System.out.print((i < 9) ? "":"　→　终点");
            System.out.print("\n");
        }
        System.out.println("");
        System.out.println("【¤】幸运轮盘　【★】地雷　【Ａ】玩家A");
        System.out.println("【〓】时空隧道　【■】暂停　【Ｂ】玩家B");
        System.out.println("【AB】玩家A和B在同一个位置　【::】普通");
        System.out.println("");
    }

    public void movePlayer(int p, int newpos) { // 移动某个玩家的位置

        if (p < 0 | p > 1 || newpos < 0 || newpos >= mapValue.length)
            return; // 非法移动
        if (newpos == player[p])
            return; // 不用移动

        int oldpos = player[p];
        player[p] = newpos;

        if (oldpos == player[1 - p]) {
            mapChar[mapIndex[oldpos]] = ch[6 - p];
        } else if (oldpos == 0) {
            mapChar[mapIndex[oldpos]] = ar[md.startDirection()];
        } else if (oldpos == mapValue.length - 1) {
            mapChar[mapIndex[oldpos]] = ar[md.endDirection()];
        } else {
            mapChar[mapIndex[oldpos]] = ch[mapValue[oldpos]];
        }

        if (newpos == player[1 - p]) {
            mapChar[mapIndex[newpos]] = ch[7];
        } else {
            mapChar[mapIndex[newpos]] = ch[5 + p];
        }
    }

    public void swapPlayer() { // 交换两个玩家的位置

        if (player[0] == player[1])
            return; // 不用交换

        int temp = player[0];
        player[0] = player[1];
        player[1] = temp;

        mapChar[mapIndex[player[0]]] = ch[5];
        mapChar[mapIndex[player[1]]] = ch[6];
    }
}
