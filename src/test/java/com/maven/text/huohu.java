package com.maven.text;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class huohu {
    @Test
    public void hh() throws InterruptedException {
        //1.C:\Program Files\Mozilla Firefox\firefox.exe火狐浏览器安装路径下的可执行程序
        //2.在pom.xml文件中引用的是2.5.3版本，操作最新谷歌浏览器没问题，但是操作最新的火狐浏览器9.0有问题，
        // 将selenium版本调整为3.9.0就正常了
        System.setProperty("webdriver.firefox.bin", "C:\\Program Files\\Mozilla Firefox\\firefox.exe");//导入驱动
        //System.setProperty("webdriver.firefox.marionette","C:\\Python27\\geckodriver.exe");
        WebDriver webdriver = new FirefoxDriver();
        webdriver.get("http://localhost:8080/DagShop06/");
        Thread.sleep(3000);
        webdriver.close();
    }

}
