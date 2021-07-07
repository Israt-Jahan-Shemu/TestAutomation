package com.BrowserOptions;

import com.Base.TestBase;
import com.OpenCart.Login;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HeadlessTest extends TestBase {


    public static void main(String args[]){
        chromeBrowserHeadless();

    }
    public static void chromeBrowserHeadless(){
        System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
        ChromeOptions chromeObject=new ChromeOptions();
     chromeObject.setHeadless(true);
     driver=new ChromeDriver(chromeObject);
        Login.loginForValidData();
        System.out.println("Headless Chrome test done");
    }
}
