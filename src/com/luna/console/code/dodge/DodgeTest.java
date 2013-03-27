package com.luna.console.code.dodge;

public class DodgeTest {

    public static void main(String[] args) {

        Person p1 = new Person();
        p1.setNick("XXX");
        p1.setLevel(30);
        p1.setAgile(50);
        p1.setAddition(1);

        Person p2 = new Person();
        p2.setNick("YYY");
        p2.setLevel(20);
        p2.setAgile(100);
        p2.setAddition(1);
        int total = 0;
        for (int i = 0; i < 100; i++) {
            if (isDodge(p1, p2)) {
                System.out.println(String.format("%s 对 %s 发起了攻击，不过很遗憾，被 %s 躲开了..", p1.getNick(),
                        p2.getNick(), p2.getNick()));
                total++;
            } else {
                System.out.println(String.format("%s 对 %s 发起了攻击，%s 减去 1 点 HP.", p1.getNick(),
                        p2.getNick(), p2.getNick()));
            }
        }
        System.out.println("Total:" + total);
    }

    public static boolean isDodge(Person first, Person last) {

        double temp = dodge(first, last);
        int value = (int) (temp * 100);
        int random = (int) (Math.random() * 99);
        if (random < value) {
            return true;
        }
        return false;
    }

    public static double dodge(Person first, Person last) {

        int gradeGap = first.getLevel() - last.getLevel();
        double firstAgile = first.getAgile() + (first.getAgile() * first.getAddition());
        double lastAgile = last.getAgile() + (last.getAgile() * last.getAddition());
        double totalAgile = 0;
        if (firstAgile == 0) {
            totalAgile = lastAgile;
        }
        if (lastAgile == 0) {
            totalAgile = firstAgile;
        }
        if (lastAgile != 0 && firstAgile != 0) {
            totalAgile = firstAgile * lastAgile;
        }
        double dodgeChance = 0.0;

        if (last.getLevel() > first.getLevel()) {
            dodgeChance = (lastAgile + Math.abs(gradeGap)) / totalAgile;
        } else {
            dodgeChance = lastAgile / totalAgile;
        }

        return dodgeChance;
    }
}
