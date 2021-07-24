package com.DropDown;

import com.Base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class DropDownDemo extends TestBase {
    public static void main(String a[]){
        chromeLaunch();
        openTestURL("https://the-internet.herokuapp.com/dropdown");
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        selectOptionsByIndex();
        selectOptionsByValue();
        selectOptionsByVisibleText();
    }
    public static void selectOptionsByIndex(){
        WebElement firstOption=driver.findElement(By.id("dropdown"));
        Select option1=new Select(firstOption);
      option1.selectByIndex(1);
    }
    public static void selectOptionsByValue(){
        WebElement secondOption=driver.findElement(By.id("dropdown"));
        Select option2=new Select(secondOption);
        option2.selectByValue("2");
    }
    public static void selectOptionsByVisibleText(){
        WebElement secondOption=driver.findElement(By.id("dropdown"));
        Select option2=new Select(secondOption);
        option2.selectByVisibleText("Option 1");
    }
}
