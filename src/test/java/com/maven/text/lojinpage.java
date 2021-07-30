package com.maven.text;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.DriverPropertyInfo;

public class lojinpage {

    @Test
    public void login() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Python27\\chromedriver.exe");//导入驱动
        WebDriver webdriver = new ChromeDriver();//启用谷歌浏览器
        webdriver.get("http://localhost:8080/DagShop06/");//打开网址
        String title = webdriver.getTitle();//检测
        Assert.assertEquals(title, "WEB01");//校验
        Thread.sleep(3000);//休眠
        WebElement abc = webdriver.findElement(By.xpath("/html/body/div/div[1]/div[3]/ol/li[1]/a"));//登录的Xpath值
        abc.click();//点击登录
        Thread.sleep(5000);//休眠
        WebElement account = webdriver.findElement(By.id("username"));//通过定位拿到当前标签对象
        account.sendKeys("aaa");//输入账号
        WebElement pwd = webdriver.findElement(By.id("inputPassword3"));//通过定位拿到当前标签对象
        pwd.sendKeys("aaa");//输入密码
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

    }

    @Test
    public void registered() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Python27\\chromedriver.exe");//导入驱动
        WebDriver webdriver = new ChromeDriver();//启用谷歌浏览器
        webdriver.get("http://localhost:8080/DagShop06/");//打开网址
        String title = webdriver.getTitle();//检测
        Assert.assertEquals(title, "WEB01");//校验
        Thread.sleep(3000);//休眠
        WebElement zhuce = webdriver.findElement(By.xpath("/html/body/div/div[1]/div[3]/ol/li[2]/a"));//定位注册标签
        zhuce.click();
        Thread.sleep(3000);
        WebElement zhuce01 = webdriver.findElement(By.xpath("/html/body/div[3]/div/div[2]/font"));//
        boolean huiyuan = zhuce01.isDisplayed();//检测
        Assert.assertTrue(huiyuan);//校验huiyuan标签是否出现在网页中
        WebElement yonghuming = webdriver.findElement(By.id("username"));
        yonghuming.sendKeys("西米");//用户名
        WebElement mima = webdriver.findElement(By.id("inputPassword3"));
        mima.sendKeys("123456");//密码
        WebElement mimaagain = webdriver.findElement(By.id("confirmpwd"));
        mimaagain.sendKeys("123456");//确认密码
        WebElement email = webdriver.findElement(By.id("inputEmail3"));
        email.sendKeys("1956@qq.com");//邮箱
        WebElement name = webdriver.findElement(By.id("usercaption"));
        name.sendKeys("刘西米");//姓名
        WebElement six = webdriver.findElement(By.id("inlineRadio2"));
        six.click();//性别
        WebElement date = webdriver.findElement(By.xpath("/html/body/div[3]/div/div[2]/form/div[7]/div/input"));
//        ((JavascriptExecutor)date).executeScript("arguments[0].value='2016-11-18';",date);
        JavascriptExecutor js = (JavascriptExecutor) webdriver;//将webdriver数据类型强转为Javascript
        js.executeScript("arguments[0].value='2016-11-18';", date);//date:被赋值的标签对象
        Thread.sleep(3000);
        WebElement zc = webdriver.findElement(By.xpath("/html/body/div[3]/div/div[2]/form/div[9]/div/input"));
        zc.click();//注册按钮
        WebElement zhuc = webdriver.findElement(By.xpath("/html/body/div[1]/div[3]/h3"));//
        boolean cg = zhuc.isDisplayed();//检测
        Assert.assertTrue(cg);//校验huiyuan标签是否出现在网页中
        Thread.sleep(3000);
        webdriver.close();//关闭浏览器
    }
    @Test
    public void baidu() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\Python27\\chromedriver.exe");//导入驱动
        WebDriver webdriver= new ChromeDriver();//启用谷歌浏览器
        webdriver.get("https://www.baidu.com/");//打开网址
        WebElement sskuang = webdriver.findElement(By.id("kw"));
        JavascriptExecutor js=(JavascriptExecutor)webdriver;//将webdriver数据类型强转为Javascript
        js.executeScript("arguments[0].value='百度';",sskuang);//date:被赋值的标签对象
        Thread.sleep(3000);


    }
}

