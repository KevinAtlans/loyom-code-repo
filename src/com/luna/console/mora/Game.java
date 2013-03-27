package com.luna.console.mora;

import java.util.HashMap;
import java.util.Map;

public class Game {

    private final Map<Integer, String> moraType = new HashMap<Integer, String>();

    private final Map<Integer, String> type = new HashMap<Integer, String>();

    public int victoryCount = 0;

    public int totalCount = 0;

    private void init() {

        moraType.put(0, "石头");
        moraType.put(1, "剪刀");
        moraType.put(2, "布");
        type.put(0, "你输了！");
        type.put(1, "你赢了！");
        type.put(2, "平局！");
        type.put(3, "错误规则！");
    }

    private void showTitle() {

        System.out.println("※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※");
        System.out.println("※　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　※");
        System.out.println("※　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　※");
        System.out.println("※    　　　　　　　　　 猜　　拳　　游   戏　　　　　　　　　　　　　   ※");
        System.out.println("※　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　※");
        System.out.println("※　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　※");
        System.out.println("※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※");
        System.out.println("\n【注意】:为了保证游戏正常显示，请设置等宽字体的标准字号(如9号、12号的宋体字)");
    }

    private void showEnd() {

        System.out.println("※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※");
        System.out.println("※　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　※");
        System.out.println("※　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　※");
        System.out.println("※    　　　　　　　　　 猜　　拳　　游   戏　　　　　　　　　　　　　   ※");
        System.out.println("※　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　※");
        System.out.println("※　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　※");
        System.out.println("※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※");
        System.out.println("\n【注意】:为了保证游戏正常显示，请设置等宽字体的标准字号(如9号、12号的宋体字)");
    }

    public void start() {

        init();
        showTitle();
        Sprite s1 = new Sprite();
        Sprite s2 = new Sprite();

        int status = 0;
        while (status != 4) {
            s1.getMyType();
            s2.getMyType();
            victoryCount += 1;
            totalCount += 1;
        }
        showEnd();
    }
}
