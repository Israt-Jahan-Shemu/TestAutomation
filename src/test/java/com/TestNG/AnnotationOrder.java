package com.TestNG;

import com.Base.TestBase;
import org.testng.annotations.*;

public class AnnotationOrder extends TestBase {
    @BeforeSuite
    public void suiteSetUp() {
        System.out.println("Suite SetUp done");
    }

    @BeforeTest
    public void testSetUp() {
        System.out.println("Test SetUp done");
    }

    @BeforeClass
    public void classSetUp() {
        System.out.println("Class SetUp done");
    }

    @BeforeMethod
    public void methodSetUp() {
        System.out.println("Method SetUp done");
    }

    @Test
    public void TestCase_001() {
        System.out.println("Hello World");
    }

    @Test
    public void TestCase_002() {
        System.out.println("Hello Shemu");
    }

    @AfterMethod
    public void methodExecute() {
        System.out.println("After Method SetUp done");
    }

    @AfterClass
    public void classExecute() {
        System.out.println("After Class SetUp done");
    }

    @AfterTest
    public void testExecute() {
        System.out.println("After Test SetUp done");
    }

    @AfterSuite
    public void suiteExecute() {
        System.out.println("After Suite SetUp done");
    }
}
