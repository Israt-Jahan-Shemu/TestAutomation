package com.JSAlerts;

import com.Base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class javascriptAlerts extends TestBase {
    public static void main(String args[]){
       chromeLaunch();
       openTestURL("https://the-internet.herokuapp.com/javascript_alerts");
       normalAlert();
       confirmAlert();
       promptAlert();
       chromeClose();
    }
public static void normalAlert(){
    //WebElement normalAlertButton=driver.findElement(By.cssSelector("#content > div > ul > li:nth-child(1) > button"));
    //WebElement normalAlertButton=webElementByCSS("#content > div > ul > li:nth-child(1) > button");
   // normalAlertButton.click();


    getElementByCSSClick("#content > div > ul > li:nth-child(1) > button");

    acceptAlert();
}
    public static void confirmAlert(){

getElementByCSSClick("#content > div > ul > li:nth-child(2) > button");
cancelAlert();

    }
    public static void promptAlert(){
getElementByCSSClick("#content > div > ul > li:nth-child(3) > button");
driver.switchTo().alert().sendKeys("Automation Test");
        acceptAlert();
    }
}
