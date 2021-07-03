package com.config;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserSize extends BrowserConfig {
    // public static WebDriver driver;
    public static void main(String[] args) {
        chromeLaunch();
        screenPC();
        getScreenSize();

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

    public static void getScreenSize() {
        int height = driver.manage().window().getSize().getHeight();
        int width = driver.manage().window().getSize().getWidth();
        System.out.println("Screen Height:" + height + "and Width:" + width);
    }

    public static void screenPC() {


        driver.manage().window().setSize(new Dimension(769, 400));

    }

    public static void screenTab() {

        driver.manage().window().setSize(new Dimension(768, 400));

    }
}
