package com.properties;

import com.Base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


/*
1)got to login page
2)type email
3)type password
4)click login button
*/

public class LoginWithProperties extends TestBase {
    public static Properties propertyObj;

    public static void main(String args[]) throws IOException {
        chromeLaunch();
        openTestURL("https://demo.opencart.com/index.php?route=account/login");
        loginForValidData();
        loginForInvalidData();

    }

    public static void loginForValidData() throws IOException {
        // driver.get("https://demo.opencart.com/index.php?route=account/login");
        //Read Properties File

//        FileInputStream files = new FileInputStream("./src/test/resources/OR.properties");
//        propertyObj = new Properties();
//        propertyObj.load(files);
        setProperties();
        //step 1
        // driver.get("https://demo.opencart.com/index.php?route=account/login");
        //step 2;
        WebElement Email = driver.findElement(By.id("input-email"));
        //Email.sendKeys("isratshimu@gmail.com");
        Email.sendKeys(propertyObj.getProperty("EmailID"));
        //step 3
        WebElement Password = driver.findElement(By.id("input-password"));
        //Password.sendKeys("123456");
        Password.sendKeys(propertyObj.getProperty("Pass"));
        //step 4
        WebElement LoginBtn = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input"));

        LoginBtn.click();
//login pass for valid data


        String ExpectedResult = "My Account";
        String ActualResult = driver.getTitle();
        if (ActualResult.equals(ExpectedResult)) {
            System.out.println("Test passed for valid data");

        } else {
            System.out.println("Test failed for valid data.Bug found");

        }
        WebElement logout = driver.findElement(By.linkText("Logout"));
        logout.click();

    }

    public static void loginForInvalidData() throws IOException {
        //step 1
        driver.get("https://demo.opencart.com/index.php?route=account/login");
//        FileInputStream files = new FileInputStream("./src/test/resources/OR.properties");
//        propertyObj = new Properties();
//        propertyObj.load(files);
        setProperties();
        //step 2;
        WebElement Email = driver.findElement(By.id("input-email"));
        //  Email.sendKeys(" isratshimu@gmail");
        Email.sendKeys(propertyObj.getProperty("EmailID_Invalid"));
        //step 3
        WebElement Password = driver.findElement(By.id("input-password"));
        // Password.sendKeys("123456");
        Password.sendKeys(propertyObj.getProperty("Pass1"));

        //step 4
        WebElement LoginBtn = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input"));

        LoginBtn.click();
        String ExpectedResult = "My Account";
        String ActualResult = driver.getTitle();
        if (!ActualResult.equals(ExpectedResult)) {
            System.out.println("Test passed for invalid data");
            captureScreenShot("loginforinvalid", ".phg");
        } else {
            System.out.println("Test failed for invalid data");
            WebElement logout = driver.findElement(By.linkText("Logout"));
            logout.click();
        }
    }
    private static void setProperties() throws IOException {
        FileInputStream files = new FileInputStream("./src/test/resources/OR.properties");
        propertyObj = new Properties();
        propertyObj.load(files);
    }
}
