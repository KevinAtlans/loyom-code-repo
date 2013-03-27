package com.luna.console.code;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class ConsoleTest {

    /**
     * @param args
     */
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Enter number of students in class : ");
        int numberInClass = input.nextInt();
        System.out.print("Enter MODULE CODE of the subject module : ");
        int codeForSubject = input.nextInt();
        System.out
                .println("Enter the student's name and his/her score (0 - 100) separated by a comma(,) on one by one basics");

        Map<String, Integer> nameToSc = new HashMap<String, Integer>();

        for (int i = 1; i <= numberInClass; i++) {
            System.out.print(String.format("Record %s : ", i));
            String nameToScore = input.next();
            String[] nTs = nameToScore.split(",");
            if (nTs.length == 2) {
                nameToSc.put(nTs[0], Integer.parseInt(nTs[1]));
            }
        }

        System.out.println("Module Code\tName Of Student\t\tScore\t\tGrade");
        for (Entry<String, Integer> entry : nameToSc.entrySet()) {
            System.out.println(String.format("%s\t\t%s\t\t\t%s\t\t%s", codeForSubject,
                    entry.getKey(), entry.getValue(), "C"));
        }
    }

}
