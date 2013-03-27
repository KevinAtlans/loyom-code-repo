package com.luna.console.flyingchess;

import java.util.Scanner;

public class Game {

    Scanner in = new Scanner(System.in);

    Map mm = new Map();

    boolean computer[] = new boolean[2]; // 玩家1和2是否由电脑自动控制

    String name[] = new String[2]; // 玩家1和2的名字

    boolean pausing[] = new boolean[2]; // 玩家1和2的暂停状态，true表示下一步不能动

    private int getChoise(int min, int max) {

        int choise = min - 1;
        do {
            if (in.hasNextInt()) {
                choise = in.nextInt();
                if (choise >= choise && choise <= max) {
                    return choise;
                } else {
                    System.out.print("输入错误，请重新输入(" + min + "-" + max + ")：");
                }
            } else {
                in.next();
                System.out.print("输入错误，请重新输入(" + min + "-" + max + ")：");
            }

        } while (true);
    }

    private void initial() {

        System.out.println("※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※");
        System.out.println("※　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　※");
        System.out.println("※　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　※");
        System.out.println("※　　　　　　　　　　　　骑　　士　　飞　　行　　棋　　　　　　　　　　　　　　※");
        System.out.println("※　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　※");
        System.out.println("※　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　※");
        System.out.println("※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※");
        System.out.println("\n\n");
        System.out.println("【注意】　由于游戏采用的是字符界面，所以需要设置等宽字体的标准字号(如9号、12号的");
        System.out.println("\n　　　　　宋体字)运行以保证地图的正常显示！");
        System.out.println("\n\n");
        System.out.print("请选择作战模式 ( 1.两人对战　2.人机对战 )：");
        computer[0] = false;
        if (getChoise(1, 2) == 1) {
            computer[1] = false;
            System.out.println("\n\n～～～～～～～～～～～～～～～　两　人　对　战　～～～～～～～～～～～～～～～");
        } else {
            computer[1] = true;
            System.out.println("\n\n～～～～～～～～～～～～～～～　人　机　对　战　～～～～～～～～～～～～～～～");
        }
        System.out.println();

        String namestr[] = { "戴高乐", "艾森豪威尔", "麦克阿瑟", "巴顿" };
        System.out.println("请选择角色：1.戴高乐　2.艾森豪威尔　3.麦克阿瑟　4.巴顿");
        System.out.println();
        System.out.print("请玩家１选择角色：");
        int p0 = getChoise(1, 4) - 1;
        int p1;

        System.out.print("请玩家２选择角色：");
        if (computer[1]) {
            p1 = (int) (Math.random() * 10000) % 4;
            System.out.println(p1 + 1);
        } else {
            p1 = getChoise(1, 4) - 1;
        }
        name[0] = namestr[p0];
        name[1] = namestr[p1];

        if (p0 == p1) {
            name[0] = name[0].concat("１");
            name[1] = name[1].concat("２");
        }

        pausing[0] = false;
        pausing[1] = false;

        System.out.println("\n\n");
        System.out.println("～～～～～～～～　" + name[0] + "　VS　" + name[1] + "　对战开始　～～～～～～～～");
        System.out.println("\n\n");

        mm.initial((int) (Math.random() * 10000) % MapData.mapCount);
        // mm.initial();
    }

    private void isGeneral(int p) { // 到达普通格

        if (mm.playerPos(p) == mm.playerPos(1 - p)) { // 追上了对手，将对手打回开始位置
            mm.movePlayer(1 - p, 0);
            mm.printMap();
            System.out.println(name[p] + "追上了" + name[1 - p] + "，将他打回开始位置！");
        }
    }

    private void isLucky(int p) { // 到达幸运轮盘

        System.out.println(name[p] + "到达幸运轮盘格，请选择奖励方式：");
        System.out.println("1.和" + name[1 - p] + "交换位置");
        System.out.println("2.轰炸" + name[1 - p] + "，让他倒退了6步！");
        int choise;
        if (computer[p]) {
            choise = ((mm.playerPos(p) + 3 < mm.playerPos(1 - p)) ? 1 : 2);
            System.out.println(name[p] + "选择" + choise); // 输出电脑的选择
        } else {
            choise = getChoise(1, 2);
        }
        if (choise == 1) {
            mm.swapPlayer();
            mm.printMap();
            System.out.println(name[p] + "和" + name[1 - p] + "交换了位置");
        } else {
            int oldpos = mm.playerPos(1 - p);
            if (oldpos == 0) {
                System.out.println(name[1 - p] + "在开始位置，不能再倒退了，轰炸无效！");
            } else {
                int newpos = oldpos - 6;
                if (newpos < 0)
                    newpos = 0;
                mm.movePlayer(1 - p, newpos);
                mm.printMap();
                System.out.println(name[1 - p] + "被轰炸后倒退了" + (oldpos - newpos) + "步！");
            }
        }
    }

    private void isMine(int p) { // 到达地雷格

        System.out.println(name[p] + "碰到了地雷！");
        int oldpos = mm.playerPos(p);
        int newpos = oldpos - 6;
        if (newpos < 0)
            newpos = 0;
        mm.movePlayer(p, newpos);
        mm.printMap();
        System.out.println(name[p] + "被轰炸后倒退了" + (oldpos - newpos) + "步！");
    }

    private void isPause(int p) { // 到达暂停格

        System.out.println(name[p] + "停在暂停格，下回合将不能自由移动！");
        pausing[p] = true;
    }

    private void isTunnel(int p) { // 到达时空隧道格

        System.out.println(name[p] + "找到了时空隧道，可以快速向前再前进十格");
        int oldpos = mm.playerPos(p);
        int newpos = oldpos + 10;
        if (newpos >= mm.posCount())
            newpos = mm.posCount() - 1;
        mm.movePlayer(p, newpos);
        mm.printMap();
        System.out.println(name[p] + "利用时空隧道又前进了" + (newpos - oldpos) + "格");
    }

    public void startGame() {

        do {
            initial();
            mm.printMap();

            int p = 1;
            do {
                p = 1 - p; // 换另外一个玩家
                System.out.println("～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～");
                System.out.println("【Ａ." + name[0] + "】　ＶＳ　【Ｂ." + name[1] + "】 对战");
                System.out.print("\n轮到【" + name[p] + "】");
                if (pausing[p]) {
                    pausing[p] = false;
                    System.out.println(name[p] + "本回合无法移动！");
                    continue;
                }
                System.out.println("，请掷骰子：");

                int rnd = 0;
                if (computer[p]) { // 电脑自动掷骰子
                    rnd = (int) (Math.random() * 10000) % 6 + 1;
                } else {
                    if (in.hasNextInt()) {
                        rnd = in.nextInt();
                    } else {
                        in.nextLine();
                        rnd = (int) (Math.random() * 100);
                    }
                    rnd = (int) (Math.random() * rnd * 100) % 6 + 1;
                }
                System.out.println(name[p] + "掷的骰子点数是： " + rnd);

                int oldpos = mm.playerPos(p);

                if (oldpos + rnd >= mm.posCount() - 1) {
                    mm.movePlayer(p, mm.posCount() - 1);
                    mm.printMap();

                    break;
                }

                int newpos = oldpos + rnd;
                mm.movePlayer(p, newpos);
                mm.printMap();

                switch (mm.mapValue(newpos)) {
                case 0: // 到达普通格
                    isGeneral(p);
                    break;
                case 1: // 到达幸运轮盘
                    isLucky(p);
                    break;
                case 2: // 到达地雷格
                    isMine(p);
                    break;
                case 3: // 到达暂停格
                    isPause(p);
                    break;
                case 4: // 到达时空隧道格
                    isTunnel(p);
                    break;
                }
            } while (mm.playerPos(p) < mm.posCount() - 1);

            System.out.println(name[p] + "先到达了终点，获得胜利！");
            System.out.println("要重新开始游戏吗？(按Y继续，其它键退出)");
        } while (in.next().equalsIgnoreCase("Y"));
    }
}
