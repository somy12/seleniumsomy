package com.jdbc.text;

import com.sun.webkit.graphics.WCImageDecoder;
import org.junit.Test;

import java.sql.*;

public class jdbctext {
    @Test
    public void tt() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection( "jdbc:mysql://localhost:3306/store", "root", "123456");
        System.out.println(con);
    }
    @Test
    public void shan() throws ClassNotFoundException, SQLException {
        String driverClassName = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/store";
        String username = "root";
        String password = "123456";
        Class.forName(driverClassName);
        Connection con = DriverManager.getConnection(url, username, password);
        Statement stmt = con.createStatement();
        String sql = "DELETE FROM category WHERE cname='aaaa'";
        int r = stmt.executeUpdate(sql);
        System.out.println(r);
    }

    public void zeng(String cid,String cname) throws ClassNotFoundException, SQLException {
            String driverClassName = "com.mysql.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3306/store";
            String username = "root";
            String password = "123456";
            Class.forName(driverClassName);
            Connection con = DriverManager.getConnection(url, username, password);
            Statement stmt = con.createStatement();
//            insert into category values (‘18’,‘手推车’)
            String sql1 = "INSERT INTO category values('" + cid + "','" + cname + "')";
            System.out.println(sql1);
            int b = stmt.executeUpdate(sql1);
            System.out.println(b);
    }
    @Test
    public void zeng01() throws SQLException, ClassNotFoundException {
        jdbctext kk = new jdbctext();
        kk.zeng("8","手机");
    }



        public void gai(String cname,String cid) throws ClassNotFoundException, SQLException {
            String driverClassName = "com.mysql.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3306/store";
            String username = "root";
            String password = "123456";
            Class.forName(driverClassName);
            Connection con = DriverManager.getConnection(url, username, password);
            Statement stmt = con.createStatement();
            //UPDATE category SET cname='xxx' where cid='xxx'
        //String sql2 = "UPDATE category SET('" + cname + "')where ('"+ cid +"')";
            String sql2="UPDATE category SET cname='" + cname + "' where cid='" + cid + "'";
        System.out.println(sql2);
        int c = stmt.executeUpdate(sql2);
        System.out.println(c);


        stmt.close();
        con.close();

    }
    @Test
    public void gai01() throws SQLException, ClassNotFoundException {
        jdbctext ll = new jdbctext();
        ll.gai("数码手机","1");
    }

    @Test
    public void tt02() throws ClassNotFoundException, SQLException {
        String driverClassName = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/store";
        String username = "root";
        String password = "123456";
        Class.forName(driverClassName);
        Connection con = DriverManager.getConnection(url, username, password);
        Statement stmt = con.createStatement();
        String sql = "select * from category where cid='1'";
        ResultSet rs = stmt.executeQuery(sql);
        System.out.println(rs);
        while (rs.next()){
            String cid = rs.getString("cid");
            String cname = rs.getString("cname");
            System.out.println(cid+" "+cname);
        }



        rs.close();
        stmt.close();
        con.close();
    }


    public void tt03(String cid_) throws ClassNotFoundException, SQLException {
        String driverClassName = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/store";
        String username = "root";
        String password = "123456";
        Class.forName(driverClassName);
        Connection con = DriverManager.getConnection(url, username, password);
        Statement stmt = con.createStatement();
        String sql = "select * from category where cid="+ cid_;
        ResultSet rs = stmt.executeQuery(sql);
        System.out.println(rs);
        while (rs.next()){
            String cid = rs.getString("cid");
            String cname = rs.getString("cname");

            System.out.println(cid+" "+cname);
        }
        rs.close();
        stmt.close();
        con.close();
    }
    @Test
    public void cha () throws SQLException, ClassNotFoundException {
        jdbctext jt = new jdbctext();
        jt.tt03("2");
    }
}
