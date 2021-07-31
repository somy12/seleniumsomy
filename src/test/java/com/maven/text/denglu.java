package com.maven.text;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
//用ui自动化进行兼容测试
public class denglu {
    //static WebDriver webdriver = null;//当前类里面都能用到这个对象

    public void dl01 (String name,String pwd_)  {//定义形参，功能
        WebDriver webdriver = null;
        try {
            System.setProperty("webdriver.firefox.bin", "C:\\Program Files\\Mozilla Firefox\\firefox.exe");//导入驱动
            webdriver = new FirefoxDriver();//启用谷歌浏览器
            webdriver.get("http://localhost:8080/DagShop06/");//打开网址
            String title = webdriver.getTitle();//检测
            Assert.assertEquals(title, "WEB01");//校验
            Thread.sleep(3000);//休眠
            WebElement abc = webdriver.findElement(By.xpath("/html/body/div/div[1]/div[3]/ol/li[1]/a"));//登录的Xpath值
            abc.click();//点击登录
            Thread.sleep(5000);//休眠
            WebElement account = webdriver.findElement(By.id("username"));//通过定位拿到当前标签对象
            account.sendKeys(name);//输入账号
            WebElement pwd = webdriver.findElement(By.id("inputPassword3"));//通过定位拿到当前标签对象
            pwd.sendKeys(pwd_);//输入密码
            //通过定位拿到当前标签对象
            WebElement denglu = webdriver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div/form[1]/div[5]/div/input"));
            denglu.click();//登录
            Thread.sleep(3000);
            WebElement tuichu = webdriver.findElement(By.xpath("/html/body/div/div[1]/div[3]/ol/li[2]/a"));//
            boolean ccc = tuichu.isDisplayed();//检测
            Assert.assertTrue(ccc);//校验tuichu标签是否出现在网页中
            Thread.sleep(3000);
            WebElement tuichudl = webdriver.findElement(By.xpath("/html/body/div/div[1]/div[3]/ol/li[2]/a"));
            tuichudl.click();//点击退出
            webdriver.close();//关闭浏览器
        }catch (Exception e){//固定写法
            webdriver.close();
            System.out.println("当前登录失败");
        }
    }




    public void cha01(String abc) throws Exception {//从数据库里面获取用户密码
        String driverClassName = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/store";
        String username = "root";
        String password = "123456";
        Class.forName(driverClassName);
        Connection con = DriverManager.getConnection(url, username, password);
        Statement stmt = con.createStatement();
        String sql = "select * from denglu";
        ResultSet rs = stmt.executeQuery(sql);
        System.out.println(rs);
        while (rs.next()){
            String cname = rs.getString("cname");
            String password1 = rs.getString("password1");
            denglu dl = new denglu();
//            dl.dl01(cname,password1);
            jrx xx = new jrx();
            xx.dl01(cname,password1,abc);
            System.out.println(cname+" "+password1);
        }
        rs.close();
        stmt.close();
        con.close();

    }
    @Test
    public void dl02()  {
        List<String> list = new ArrayList<String>();
        list.add("chrome");
        list.add("firefox");

        denglu dl = new denglu();
        try {//扑获异常，防止程序崩溃
            for (int i=0;i< list.size();i++){
                String browser = list.get(i);
                dl.cha01(browser);
            }

        } catch (Exception e) {
            System.out.println("当前登录错误");
        }
    }

}