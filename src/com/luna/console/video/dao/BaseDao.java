package com.luna.console.video.dao;


public class BaseDao {
    //
    // private final Logger log = Logger.getLogger(BaseDao.class);
    //
    // private final String url, userName, password, className;
    //
    // private java.sql.Connection con = null;
    //
    // private static final String FILE_NAME = "/dbConnection.properties";
    //
    // public BaseDao() {
    //
    // Properties pro = new Properties();
    // try {
    // File file = new File(this.getClass().getResource("/").getPath());
    // pro.load(new FileInputStream(file.getParent() + FILE_NAME));
    // log.info("Properties load successfully!");
    // } catch (FileNotFoundException e) {
    // log.error(e.getMessage());
    // e.printStackTrace();
    // } catch (IOException e) {
    // log.error(e.getMessage());
    // e.printStackTrace();
    // }
    // url = pro.getProperty("url");
    // userName = pro.getProperty("username");
    // password = pro.getProperty("password");
    // className = "com.mysql.jdbc.Driver";
    // }
    //
    // private static BaseDao connection = null;
    //
    // /**
    // * 通过单例模式得到一个数据库连接类对象
    // *
    // * @return
    // * @throws EmlException
    // */
    // public synchronized static BaseDao getConnection() {
    //
    // if (connection == null) {
    // connection = new BaseDao();
    // }
    // return connection;
    // }
    //
    // /**
    // * 得到一个数据库链接
    // *
    // * @return
    // * @throws ClassNotFoundException
    // * @throws SQLException
    // */
    // public Connection getConnection() {
    //
    // try {
    // Class.forName(className);
    // this.con = DriverManager.getConnection(url, userName, password);
    // log.info("get one SQL Connection");
    // } catch (SQLException e) {
    // log.error(e.getMessage());
    // e.printStackTrace();
    // } catch (ClassNotFoundException e) {
    // log.error(e.getMessage());
    // e.printStackTrace();
    // }
    // return con;
    // }
    //
    // /**
    // * 关闭数据库链接
    // *
    // * @param rs
    // * @param pre
    // * @param con
    // * @throws SQLException
    // */
    // public void closeConnection(ResultSet rs, PreparedStatement pre,
    // Connection con) {
    //
    // try {
    // if (rs != null) {
    // rs.close();
    // }
    // if (pre != null) {
    // pre.close();
    // }
    // if (con != null) {
    // con.close();
    // }
    // } catch (SQLException e) {
    // e.printStackTrace();
    //
    // }
    // }
    //
    // public boolean update(String sql) {
    //
    // try {
    //
    // DBConnection db = DBConnection.getDBConnection();
    // Connection con = db.getConnection();
    // con.setAutoCommit(false);
    // PreparedStatement ps = con.prepareStatement(sql);
    // int result = ps.executeUpdate();
    // con.commit();
    // return result > 0 ? true : false;
    // } catch (SQLException e) {
    //
    // }
    // return false;
    // }
}
