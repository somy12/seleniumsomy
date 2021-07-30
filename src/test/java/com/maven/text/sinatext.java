package com.maven.text;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.*;


public class sinatext {

    //测试是否能打开新浪首页
//    @Test
//    public void open_sina(){
//        System.setProperty("webdriver.chrome.driver","C:\\Python27\\chromedriver.exe");//导入驱动
//        WebDriver webdriver= new ChromeDriver();//启用谷歌浏览器
//        webdriver.get("https://www.baidu.com/");//打开网址
//        String title=webdriver.getTitle();//检测
//        Assert.assertEquals(title,"百度一下，你就知道");//校验
//        webdriver.close();//关闭浏览器
//
//    }

    public void tt03() throws ClassNotFoundException, SQLException, InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Python27\\chromedriver.exe");//导入驱动

        String driverClassName = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/store";
        String username = "root";
        String password = "123456";
        Class.forName(driverClassName);//加载驱动
        Connection con = DriverManager.getConnection(url, username, password);//连接数据库
        Statement stmt = con.createStatement();//调用
        String sql = "select * from denglu ";//查找数据
        ResultSet rs = stmt.executeQuery(sql);//输出
        System.out.println(rs);//打印
        while (rs.next()){
            try {
            String cname = rs.getString("cname");
            String password1 = rs.getString("password1");
            WebDriver webdriver = new ChromeDriver();//启用谷歌浏览器
            webdriver.get("http://localhost:8080/DagShop06/");//打开网址
            String title = webdriver.getTitle();//检测
            Assert.assertEquals(title, "WEB01");//校验
            Thread.sleep(3000);//休眠
            WebElement abc = webdriver.findElement(By.xpath("/html/body/div/div[1]/div[3]/ol/li[1]/a"));//登录的Xpath值
            abc.click();//点击登录
            Thread.sleep(5000);//休眠
            WebElement account = webdriver.findElement(By.id("username"));//通过定位拿到当前标签对象
            account.sendKeys(cname);//输入账号
            WebElement pwd = webdriver.findElement(By.id("inputPassword3"));//通过定位拿到当前标签对象
            pwd.sendKeys(password1);//输入密码
            //通过定位拿到当前标签对象
            WebElement denglu = webdriver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div/form[1]/div[5]/div/input"));
            denglu.click();//登录
            Thread.sleep(3000);
            WebElement tuichu = webdriver.findElement(By.xpath("/html/body/div/div[1]/div[3]/ol/li[2]/a"));//
            boolean ccc = tuichu.isDisplayed();//检测
            Assert.assertTrue(ccc);//校验tuichu标签是否出现在网页中
            Thread.sleep(3000);
            WebElement tuichudl = webdriver.findElement(By.xpath("/html/body/div/div[1]/div[3]/ol/li[2]/a"));
            tuichudl.click();
            webdriver.close();//关闭浏览器
            System.out.println(cname+" "+password1);
            }catch (Exception e){
                System.out.println("当前用户名密码登录失败");
                continue;
            }
        }
        rs.close();
        stmt.close();
        con.close();
    }
    @Test
    public void cha () throws SQLException, ClassNotFoundException, InterruptedException {
        sinatext jt = new sinatext();
        jt.tt03();
    }
}
