package com.DataDrivenFramework;

import com.Utils_log.LogInstance;
import com.Utils_log.Xls_Reader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class  DD_LoginTest {
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


    @Test
    public void TC001_InValid() {
        driver.get(LogInURL);
        LogInstance.info("Login Page Open Successfully.");
        Xls_Reader reader=new Xls_Reader("./src/test/resources/DP_Login.xlsx");//Xls in Utils_log
        String sheetName="Sheet1";
        int rowCount=reader.getRowCount(sheetName);
        for(int rowNum=2;rowNum<=rowCount;rowNum++){
            String email=reader.getCellData(sheetName,"Email",rowNum);//DP_Login xlsx er Email column
            String password=reader.getCellData(sheetName,"Password",rowNum);//DP_Login xlsx er Password column
            WebElement Email = driver.findElement(By.id("input-email"));
            Email.clear();
            Email.sendKeys(email);
            LogInstance.info("Type Email");

            //Step 3
            WebElement Password = driver.findElement(By.id("input-password"));
            Password.clear();
            Password.sendKeys(password);
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
            //WebElement logout = driver.findElement(By.linkText("Logout"));
           // logout.click();
        }



    }
}
