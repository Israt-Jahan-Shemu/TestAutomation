package com.iFrame;

import com.Base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class iFrameTest extends TestBase {
    public static void main(String a[]) {
        chromeLaunch();
        //openTestURL("https://the-internet.herokuapp.com/iframe");
         //singleFrame();
        openTestURL("https://www.w3schools.com/html/html_iframe.asp");

        iFrameDemo();

    }

    public static void singleFrame() {
        //locate iFrame
        driver.switchTo().frame("mce_0_ifr ");
        WebElement iFrameBody = driver.findElement(By.id("tinymce"));
        iFrameBody.clear(); //this clear()function will clear the text which is already in the iframe
        iFrameBody.sendKeys("Test Automation yeee");

    }

     public static void iFrameDemo() {


         driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"main\"]/div[3]/iframe")));
         WebElement MenuCSS = driver.findElement(By.xpath("//*[@id=\"topnav\"]/div/div/a[4]"));
         MenuCSS.click();
    }


}
