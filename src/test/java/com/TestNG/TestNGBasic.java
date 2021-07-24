package com.TestNG;

import org.testng.annotations.Test;

public class TestNGBasic {

    @Test(description = "Test Description")
    public void TestCase_001() {
        System.out.println("Hello World");
    }

    @Test(priority = -2)
    public void TestCase_002() {
        System.out.println("Hello Bangladesh");
    }

    @Test(priority = -1)
    public void TestCase_003() {
        System.out.println("Hello Shemu");
    }

    @Test(enabled = false)
    public void TestCase_004() {
        System.out.println("Hello Barishal");
    }

    @Test(groups = {"Log in test"})
    public void TestCase_005() {
        System.out.println("Hello Tariq");
    }
}
