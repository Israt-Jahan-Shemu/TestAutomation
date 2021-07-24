package com.TestNG;

import com.Utils_log.LogInstance;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class LoginTestAdvance2 {
    WebDriver driver;
    String LogInURL = "https://demo.opencart.com/index.php?route=account/login";

   //@BeforeClass
    @BeforeMethod
   // @BeforeTest
   // @BeforeSuite
    public void initSetUp() {
        System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
        //System.setProperty("webdriver.chrome.driver","C:\\TestAutomation");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //System.out.println("Launch Chrome Browser");
        LogInstance.info("Chrome Launch  Browser");
        driver.get(LogInURL);
        LogInstance.info("Login Page Open Successfully");
    }

   // @AfterClass
    @AfterMethod
   // @AfterTest
   // @AfterSuite
    public void tearDown() {
        driver.close();
        LogInstance.info(" Chrome Close Browser");

    }

    @Test
    public void TC001_Valid() {

        //step 1
        driver.get("https://demo.opencart.com/index.php?route=account/login");
//        log.info("Open Login URL");
        LogInstance.info("Open Login URL");
        //step 2;
        WebElement Email = driver.findElement(By.id("input-email"));
        Email.sendKeys("isratshimu@gmail.com");
        LogInstance.info("Type Email");
        //step 3
        WebElement Password = driver.findElement(By.id("input-password"));
        Password.sendKeys("123456");
        LogInstance.info("Type Password");
        //step 4
        WebElement LoginBtn = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input"));
        LoginBtn.click();
        LogInstance.info("Click on Login Button");


        String ExpectedResult = "My Account";
        String ActualResult = driver.getTitle();
//        if (ActualResult.equals(ExpectedResult)) {
//            System.out.println("Test passed for valid data");
//            LogInstance.info("Test Passed for Valid Data");
//
//        } else {
//            System.out.println("Test failed for valid data.Bug found");
//            LogInstance.info("Test Failed");
//        }

        //Assertion
        Assert.assertEquals(ExpectedResult,ActualResult);
        WebElement logout = driver.findElement(By.linkText("Logout"));
        logout.click();
        LogInstance.info("logout");
       // driver.findElement(By.linkText("Login")).click();

    }

    @Test
    public void TC002_IValid() {



        LogInstance.info("Open Login URL");
        //step 2;
        WebElement Email = driver.findElement(By.id("input-email"));
        Email.sendKeys("isratshimu");
        LogInstance.info("Type Email");
        //step 3
        WebElement Password = driver.findElement(By.id("input-password"));
        Password.sendKeys("123456");
        LogInstance.info("Type Password");
        //step 4
        WebElement LoginBtn = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input"));
        LoginBtn.click();
        LogInstance.info("Click on Login Button");


        String ExpectedResult = "Account Login";
        String ActualResult = driver.getTitle();

        Assert.assertEquals(ExpectedResult,ActualResult);
    }
}
