package com.BrowserOptions;

import com.Base.TestBase;
import com.OpenCart.Login;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class InsecureTest extends TestBase {

        public static void main(String args[]){
            acceptanceInsecure();

        }
        public static void acceptanceInsecure(){
            System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
            ChromeOptions chromeObject=new ChromeOptions();
            chromeObject.setAcceptInsecureCerts(true);
            driver=new ChromeDriver();
            driver.get("http://www.cacert.org/");
            String TitleAfterAccept=driver.getTitle();
            System.out.println(TitleAfterAccept);
        }
    }


