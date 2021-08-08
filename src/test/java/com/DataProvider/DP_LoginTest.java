package com.DataProvider;

import com.Utils_log.LogInstance;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class DP_LoginTest {
    WebDriver driver;
    String LogInURL = "https://demo.opencart.com/index.php?route=account/login";

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

    @DataProvider(name = "Invalid_LoginData")
    public Object[][] data() {
        Object data[][] = new Object[3][2];
        data[0][0]="user@mail.com";
        data[0][1]="33434343";

        data[1][0]="user@";
        data[1][1]="434jjkk";

        data[2][0]="user";
        data[2][1]="4534456455uiououiou";
        return data;
    }

    @Test(dataProvider = "Invalid_LoginData")
    public void TC001_InValid(String DP_Email, String DP_Password) {
        driver.get(LogInURL);
        LogInstance.info("Login Page Open Successfully.");

        WebElement Email = driver.findElement(By.id("input-email"));
        Email.clear();
        Email.sendKeys(DP_Email);
        LogInstance.info("Type Email");

        //Step 3
        WebElement Password = driver.findElement(By.id("input-password"));
        Password.clear();
        Password.sendKeys(DP_Password);
        LogInstance.info("Type Password");

        WebElement LoginBtn = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input"));
        LoginBtn.click();
        LogInstance.info("Click on Login Button");

        //Logic Develop
        //Login Pass
        String Exp_Title = "Account Login";
        String Act_Title = driver.getTitle();

        //Assertion
        Assert.assertEquals(Exp_Title, Act_Title);

        //Logout
        WebElement logout = driver.findElement(By.linkText("Logout"));
        logout.click();
    }

}
