package com.OpenCart;

import com.Base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/*
1)got to login page
2)type email
3)type password
4)click login button
*/

public class Login extends TestBase {
    public  static void main(String args []){
        chromeLaunch();
        loginForValidData();
        loginForInvalidData();

    }
public static void loginForValidData(){
        //step 1
        driver.get("https://demo.opencart.com/index.php?route=account/login");
        //step 2;
    WebElement Email= driver.findElement(By.id("input-email"));
    Email.sendKeys("isratshimu@gmail.com");
    //step 3
    WebElement Password= driver.findElement(By.id("input-password"));
    Password.sendKeys("123456");
    //step 4
    WebElement LoginBtn= driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input"));

LoginBtn.click();
//login pass for valid data


    String ExpectedResult="My Account";
    String ActualResult=driver.getTitle();
    if(ActualResult.equals(ExpectedResult)){
        System.out.println("Test passed for valid data");

    }
    else {
        System.out.println("Test failed for valid data.Bug found");

    }
    WebElement logout=driver.findElement(By.linkText("Logout"));
    logout.click();

}
    public static void loginForInvalidData(){
        //step 1
        driver.get("https://demo.opencart.com/index.php?route=account/login");
        //step 2;
        WebElement Email= driver.findElement(By.id("input-email"));
        Email.sendKeys(" isratshimu@gmail");
        //step 3
        WebElement Password= driver.findElement(By.id("input-password"));
        Password.sendKeys("123456");
        //step 4
        WebElement LoginBtn= driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input"));

        LoginBtn.click();
        String ExpectedResult="My Account";
        String ActualResult=driver.getTitle();
        if(!ActualResult.equals(ExpectedResult)){
            System.out.println("Test passed for invalid data");

        }
        else {
            System.out.println("Test failed for invalid data");
            WebElement logout=driver.findElement(By.linkText("Logout"));
            logout.click();
        }


    }
}
