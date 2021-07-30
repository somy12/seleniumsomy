//package com.jdbc.text;
//
//import java.io.IOException;
//import java.io.InputStream;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//public class JdbcUtils {
//    private static final String dbconfig = "dbconfig.properties";//配置文件路径
//    private static Properties prop = new Properties();//对应配置文件
//    //静态代码块 这个模块首先会被加载执行
//    // / 只在JdbcUtils类被加载时执行一次，只有第一次加载 后面就不会了。这样就优化了代码！
//    static {
//        try {
//            //通过IO流读取这个配置文件（加载配置文件）
//            // 加载src目录下的文件 路径dbconfig.properties
//            InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream(dbconfig );
//            //或者
//            // InputStream in = JdbcUtils.class.getClassLoader()
//            // .getResourceAsStream("dbconfig.properties");
//            //IO流中的数据就转化为Properties对象了
//            prop.load(in);
//            //加载驱动类
//            Class.forName(prop.getProperty("driverClassName"));
//        } catch(IOException e) {
//            throw new RuntimeException(e);
//            }
//    }//把配置文件内容加载到prop对象中。因为是放到static块中完成的加载操作，所以加载操作
//    // 只会在JdbcUtils类被加载时完成对配置文件的加载。
//
//    //获取Connection方法，参数都是从prop中获取。
//    public static Connection getConnection(){
//        try {
//            return DriverManager.getConnection(prop.getProperty("url"),
//                    prop.getProperty("username"),prop.getProperty("password"));
//        }catch (Exception e){
//            throw new RuntimeException(e);
//        }
//    }
////关闭数据库连接
//public static void close(ResultSet rs, Statement stmt, Connection con){
//        try {
//            if(rs != null) rs.close();
//            if(stmt != null) stmt.close();
//            if(con != null) con.close();
//        }catch(SQLException e) {}
//}
//
//}
