package com.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserConfig {
    public static WebDriver driver;

    /**
     * This is the entry point
     * @param args String
     */
    public static void main(String args[]) {

        chromeLaunch();
        //chromeClose();
    }

    public static void chromeLaunch() {
        //Set Chrome Driver Path
        System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
        //System.setProperty("webdriver.chrome.driver","C:\\TestAutomation");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
       // driver.get("https://google.com");
        driver.get("file:///C:/Users/Wife/Documents/BITM SQA Training Materials/Your Store.html");

System.out.println("Launch Chrome Browser");

    }
    public static void chromeClose(){
        driver.close();
        System.out.println("Close Chrome Browser");
    }
}
