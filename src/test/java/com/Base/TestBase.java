package com.Base;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.security.SecureRandom;

public class TestBase {
    public static WebDriver driver;

    /**
     * This is the entry point
     *
     * @param args String
     */
    public static void main(String args[]) throws IOException {

        chromeLaunch();
        //chromeClose();
    }

    public static void chromeLaunch() {
        //Set Chrome Driver Path
        System.setProperty("webdriver.chrome.driver","./src/main/resources/chromedriver.exe");
       // System.setProperty("webdriver.chrome.driver", "./src/main/resources/geckodriver.exe");

        //System.setProperty("webdriver.chrome.driver","C:\\TestAutomation");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        // driver.get("https://google.com");
        // driver.get("file:///C:/Users/Wife/Documents/BITM SQA Training Materials/Your Store.html");

        System.out.println("Launch Chrome Browser");

    }

    public static void chromeClose() {
        driver.close();
        System.out.println("Close Chrome Browser");
    }

    public static void openTestURL(String URL) {
        driver.get(URL);
    }

    public static WebElement webElementById(String locator) {

        return driver.findElement(By.id(locator));
    }

    public static WebElement webElementByName(String locator) {

        return driver.findElement(By.name(locator));
    }

    public static WebElement webElementByCSS(String locator) {
        return driver.findElement(By.cssSelector(locator));
    }

    public static WebElement webElementByXpath(String locator, String text) {

        return driver.findElement(By.xpath(locator));
    }

    public static void getElementByCSSClick(String locator) {

        driver.findElement(By.cssSelector(locator)).click();
    }

    public static void getElementByCSSFindKeysAndSendKeys(String locator, String text) {

        driver.findElement(By.cssSelector(locator)).sendKeys(text);
    }

    public static void acceptAlert() {
        driver.switchTo().alert().accept();
    }


    public static void cancelAlert() {
        driver.switchTo().alert().dismiss();
    }

    public static void typeText(String text) {

    }

    public static void captureScreenShot(String name, String format) throws IOException {
        // public static void captureScreenShot(String name,String format) throws IOException {
        File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(sourceFile, new File("./src/test/screenshots/" + name + ".png"), true);
        // FileUtils.copyFile(sourceFile,new File("./src/test/screenshots/"+name+format"),true);
    }

    public static void getElementByXpathAndType(String locator, String text) {
        driver.findElement(By.xpath(locator)).sendKeys(text);
    }

    public static void getElementByXpathAndClick(String locator) {
        driver.findElement(By.xpath(locator)).click();
    }

    public static void getElementIDAndClick(String locator, String text) {
        driver.findElement(By.xpath(locator)).sendKeys(text);
    }

}
