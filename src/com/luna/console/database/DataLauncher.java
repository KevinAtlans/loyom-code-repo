/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.luna.console.database;

import com.loyom.utils.Print;
import java.util.List;

/**
 *
 * @author kai.xu
 */
public class DataLauncher {

    public static void main(String[] strs) {
        DBUtil util = new DBUtil();
        String sql = "select * from test_tab limit 10";
        List<Object[]> list = util.select(sql);
        for (Object[] objs : list) {
            for (Object obj : objs) {
                Print.print(obj);
                Print.print("\t\t");
            }
            Print.println("");
        }
        //        for(int i = 2;i<10000000;i++){
        //            String sql = String.format("insert into test_tab(name) values ('name_%s')", i);
        //            Print.print(util.update(sql));
        //        }
    }
}
