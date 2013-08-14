/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.luna.console.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static com.google.common.collect.Lists.newArrayList;
import java.sql.ResultSetMetaData;

/**
 *
 * @author kai.xu
 */
public class DBUtil {

    Connection conn = null;
    String driver = "com.mysql.jdbc.Driver";
    String url = "jdbc:mysql://127.0.0.1:3307/loyom_db";
    String user = "root";
    String password = "4321";

    DBUtil() {
        init();
    }

    public boolean update(String sql) {
        if (conn == null) {
            init();
        }
        try {
            if (!conn.isClosed()) {
                Statement statement = conn.createStatement();
                int result = statement.executeUpdate(sql);
                return result > 0 ? true : false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBUtil.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (!conn.isClosed()) {
                    conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(DBUtil.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    public List<Object[]> select(String sql) {
        if (conn == null) {
            init();
        }
        try {
            if (!conn.isClosed()) {
                Statement statement = conn.createStatement();
                ResultSet rs = statement.executeQuery(sql);
                List<Object[]> result = newArrayList();
                while (rs != null && rs.next()) {
                    ResultSetMetaData metaData = rs.getMetaData();
                    int columnCount = metaData.getColumnCount();
                    Object[] objs = new Object[columnCount];
                    for (int i = 1; i < columnCount; i++) {
                        objs[i-1] = rs.getObject(i);
                    }
                    result.add(objs);
                }
                return result;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private void init() {
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBUtil.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DBUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
