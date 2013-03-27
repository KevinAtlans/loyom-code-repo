/**
 * 
 */
package com.luna.console.code;


/**
 * @author xukai
 * 
 */
public class RandomTest {

    /**
     * @param args
     */
    /**
     * @param args
     */
    public static void main(String[] args) {

        int random = (int) (Math.random() * 1000D);
        System.out.println(random);

        String realFileName = "adasdasd.asdas.das.da.sd.as.mp3";
        System.out.println(realFileName.substring(realFileName.lastIndexOf(".")));
    }
}
