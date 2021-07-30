package com.maven.text;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class zhuce {
    public void zc01(String username, String password, String passwordagin, String email, String name, String six, String date1) throws InterruptedException {
        WebDriver webdriver = null;
        try {
            System.setProperty("webdriver.chrome.driver", "C:\\Python27\\chromedriver.exe");//导入驱动
            webdriver = new ChromeDriver();//启用谷歌浏览器
            webdriver.get("http://localhost:8080/DagShop06/");//打开网址
            Thread.sleep(3000);//休眠
            WebElement zcan = webdriver.findElement(By.xpath("/html/body/div/div[1]/div[3]/ol/li[2]/a"));//注册的Xpath值
            zcan.click();//点击注册
            WebElement zhuce01 = webdriver.findElement(By.xpath("/html/body/div[3]/div/div[2]/font"));//
            boolean huiyuan = zhuce01.isDisplayed();//检测
            Assert.assertTrue(huiyuan);//校验huiyuan标签是否出现在网页中
            WebElement yhm = webdriver.findElement(By.id("username"));
            yhm.sendKeys(username);//用户名
            WebElement mm = webdriver.findElement(By.id("inputPassword3"));
            mm.sendKeys(password);//密码
            WebElement mmagin = webdriver.findElement(By.id("confirmpwd"));
            mmagin.sendKeys(passwordagin);//确认密码
            WebElement yx = webdriver.findElement(By.id("inputEmail3"));
            yx.sendKeys(email);//邮箱
            WebElement mz = webdriver.findElement(By.id("usercaption"));
            mz.sendKeys(name);//姓名
            //String six = null;
            //equals:比较是否相等，==用于数字是否相等，也能用于比较字符串等其他类对象是否相等，但是此时必须要求他们内存地址一样
            //（six==six）
            if (six.equals("1") ) {//不判断是否相等，只判断内容
//                WebElement xb = webdriver.findElement(By.id("inlineRadio1"));
                WebElement xb = webdriver.findElement(By.cssSelector("[value=\"1\"]"));
                xb.click();//性别
            }  else {
                WebElement xb1 = webdriver.findElement(By.cssSelector("[value=\"0\"]"));
                xb1.click();//性别
            }
            System.out.println(six);
            WebElement date = webdriver.findElement(By.xpath("/html/body/div[3]/div/div[2]/form/div[7]/div/input"));
            JavascriptExecutor js = (JavascriptExecutor) webdriver;//将webdriver数据类型强转为Javascript
            String jss="arguments[0].value=" + "'" +date1+ "';";
            js.executeScript(jss, date);//date:被赋值的标签对象
            System.out.println(jss);
            Thread.sleep(3000);
            WebElement zc = webdriver.findElement(By.xpath("/html/body/div[3]/div/div[2]/form/div[9]/div/input"));
            zc.click();//注册按钮
            WebElement zhuc = webdriver.findElement(By.xpath("/html/body/div[1]/div[3]/h3"));
            ///html/body/div[1]/div[3]/h3
            boolean cg = zhuc.isDisplayed();//检测
            Assert.assertTrue(cg);//校验huiyuan标签是否出现在网页中
            Thread.sleep(3000);
            webdriver.close();//关闭浏览器

        } catch (Exception e) {//固定写法
            webdriver.close();
            System.out.println("当前注册失败");
        }


    }

    public void chazc() throws Exception {//从数据库里面获取用户密码
        String driverClassName = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/store";
        String username = "root";
        String password = "123456";
        Class.forName(driverClassName);
        Connection con = DriverManager.getConnection(url, username, password);
        Statement stmt = con.createStatement();
        String sql = "select * from zc";
        ResultSet rs = stmt.executeQuery(sql);
        System.out.println(rs);
        while (rs.next()) {
            String username1 = rs.getString("username");
            String password1 = rs.getString("password");
            String passwordagin = rs.getString("passwordagin");
            String email = rs.getString("email");
            String name = rs.getString("name");
            String six = rs.getString("six");
            String date1 = rs.getString("date1");
            zhuce zz = new zhuce();
            zz.zc01(username1, password1, passwordagin, email, name, six, date1);

            System.out.println(username1 + " " + password1 + " " + passwordagin + " " + email + " " + six + " " + date1);
        }
    }
    @Test
    public void zc02()  {
        zhuce zc = new zhuce();
        try {//扑获异常，防止程序崩溃
            zc.chazc();
        } catch (Exception e) {
            System.out.println("当前登录错误");
        }
    }
}

