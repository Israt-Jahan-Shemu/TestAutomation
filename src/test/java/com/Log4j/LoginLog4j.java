package com.Log4j;

import com.Base.TestBase;
import com.Utils_log.LogInstance;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/*
1)got to login page
2)type email
3)type password
4)click login button
*/

public class LoginLog4j extends TestBase {
//    private static final Logger log = LogManager.getLogger(LoginLog4j.class);
    public static void main(String a[])  {
        chromeLaunch();
        loginForValidData();


    }

    public static void loginForValidData() {
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
        if (ActualResult.equals(ExpectedResult)) {
            System.out.println("Test passed for valid data");
           LogInstance.info("Test Passed for Valid Data");

        } else {
            System.out.println("Test failed for valid data.Bug found");
           LogInstance.info("Test Failed");
        }
        WebElement logout = driver.findElement(By.linkText("Logout"));
        logout.click();
        LogInstance.info("logout");
    }
}
