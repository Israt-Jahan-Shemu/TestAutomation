package com.BrowserOptions;

import com.Base.TestBase;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;

public class BrowserBinary extends TestBase {

    public static void main(String args[]){
        setBinary();

    }
    public static void setBinary(){
        System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
        ChromeOptions chromeObject=new ChromeOptions();
        chromeObject.setBinary(new File("C:\\Program Files\\Google\\Chrome\\Application"));
        driver=new ChromeDriver();
        driver.get("https://google.com");
    }
}
