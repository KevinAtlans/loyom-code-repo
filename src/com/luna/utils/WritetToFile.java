package com.luna.utils;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class WritetToFile {

    public static final String BASE_PATH = "out_file/";

    public static final String ENCODING = "utf-8";

    public boolean WriteOne(String fileContent, String fileName) {

        boolean isSuccess = false;
        try {
            FileWriter fw = new FileWriter(BASE_PATH + fileName);
            fw.write(fileContent, 0, fileContent.length());
            fw.flush();
            isSuccess = true;
        } catch (IOException e) {
            isSuccess = false;
            e.printStackTrace();
        }
        return isSuccess;
    }

    public void write(String fileContent, String fileName) throws IOException {

        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(BASE_PATH + fileName),
                ENCODING);
        osw.write(fileContent);
        osw.close();
    }

    public String read(String fileName) throws IOException {

        InputStreamReader isr = new InputStreamReader(new FileInputStream(BASE_PATH + fileName),
                ENCODING);
        BufferedReader br = new BufferedReader(isr);
        String str = br.readLine();
        br.close();
        isr.close();
        return str;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {

        WritetToFile wtf = new WritetToFile();
        wtf.WriteOne("this is test text!", "test.txt");
    }

}
