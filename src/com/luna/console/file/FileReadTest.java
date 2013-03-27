package com.luna.console.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileReadTest {

    /**
     * @param args
     */
    public static void main(String[] args) {

        String s = readFileByLines("src/bundle/fileReadTest.txt");
        System.out.print(s);
    }

    public static String readFileByLines(String fileName) {

        StringBuffer fileContent = new StringBuffer();

        File file = new File(fileName);
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            while ((tempString = reader.readLine()) != null) {
                fileContent.append(tempString).append(" ");
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
        return fileContent.toString().replaceAll("\\s+", " ");
    }

}
