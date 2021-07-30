package com.maven.text;


import org.testng.annotations.*;

public class maven01 {



//    @Test
//    public void testTest2(){
//        System.out.println("This is a testng comment2");
//    }
//    @Test
//    public void testTest1(){
//        System.out.println("This is a testng comment1");
//    }


    @BeforeTest
    public void beforetest(){
        System.out.println("This is a beforetest");
    }
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("This is a beforeMethod");
    }
    @AfterMethod
    public void afteremethod1(){
        System.out.println("This is a afteremethod1");
    }
    @Test
    public void testTest1(){
        System.out.println("This is a testng comment1");
    }
    @Test
    public void testTest2(){
        System.out.println("This is a testng comment2");
    }
    @AfterTest
    public void aftertest(){
        System.out.println("This is a aftertest");
    }
    @Test
    public void testTest3(){
        System.out.println("This is a testng comment3");
    }
}
