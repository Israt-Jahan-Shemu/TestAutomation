package com.EndToEndTestNG;

import com.Utils_log.LogInstance;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import java.util.Random;

public class RegisterLoginTestNG {
    static String email;
    WebDriver driver;
    //String LogInURL = "https://demo.opencart.com/index.php?route=account/login";


    @BeforeClass
    @Parameters("Browser")
    public void initSetup(String browserName) {
        if (browserName.equalsIgnoreCase("Firefox")) {
            System.setProperty("webdriver.gecko.driver", "./src/main/resources/geckodriver.exe");
            driver = new FirefoxDriver();
            LogInstance.info("Firefox Launch Successfully.");
        } else if (browserName.equalsIgnoreCase("Chrome")) {
            System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
            driver = new ChromeDriver();
            LogInstance.info("Chrome Launch Successfully.");
        }

    }

    @AfterClass
    public void tearDown() {
        driver.close();
        LogInstance.info(" Chrome Close Browser");

    }

    @Test
    public void tc001_registrationDemo() {
        //step 1
        driver.get("https://demo.opencart.com/index.php?route=account/register");

        //step 2
        WebElement firstName = driver.findElement(By.id("input-firstname"));
        firstName.sendKeys("Israt Jahan");
        //step 3
        WebElement lastName = driver.findElement(By.id("input-lastname"));
        lastName.sendKeys("Shemu");

        //step 4
        WebElement Email = driver.findElement(By.id("input-email"));
        Random random = new Random();
        //email = ""+random.nextInt(1000);
        email = "" + random.nextInt(1000) + "@gmail.com";
        Email.sendKeys(email);

        //step 5
        WebElement Telephone = driver.findElement(By.id("input-telephone"));
        Telephone.sendKeys("12345022722");

        //step 6
        WebElement Password = driver.findElement(By.id("input-password"));
        Password.sendKeys("123456");

        //step 7
        WebElement Password2 = driver.findElement(By.id("input-confirm"));
        Password2.sendKeys("123456");

        //Checkbox
        WebElement CheckBox = driver.findElement(By.name("agree"));
        CheckBox.click();

        //final step
        WebElement ClickContinue = driver.findElement(By.cssSelector(".btn-primary"));
        ClickContinue.click();
        WebElement logout = driver.findElement(By.linkText("Logout"));
        logout.click();
    }

    @Test
    public void tc002_loginDemo() {

        // driver.navigate().to("https://demo.opencart.com/index.php?route=account/login");
//step 1
        driver.get("https://demo.opencart.com/index.php?route=account/login");
        //step 2;
        WebElement Email = driver.findElement(By.id("input-email"));
        Email.sendKeys(email);
        //step 3
        WebElement Password = driver.findElement(By.id("input-password"));
        Password.sendKeys("123456");
        //step 4
        WebElement LoginBtn = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input"));

        LoginBtn.click();
//login pass for valid data
    }

}
