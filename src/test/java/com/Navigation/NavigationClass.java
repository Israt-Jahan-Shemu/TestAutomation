package com.Navigation;

import com.Base.TestBase;
import com.OpenCart.Login;
import com.OpenCart.Register;

public class NavigationClass extends TestBase {
    public  static void main(String a[]){
        chromeLaunch();
        driver.get("file:///C:/Users/Wife/Documents/BITM SQA Training Materials/Your Store.html");
        navigateTo();
        navigateBack();
        navigateForward();
        navigateRefresh();
    }
    public static void navigateTo(){
    driver.navigate().to("https://google.com");
    }
    public static void navigateBack(){
     driver.navigate().back();
        System.out.println("Navigate to Backward "+ driver.getTitle());
    }
   public static void navigateForward(){
    driver.navigate().forward();
       System.out.println("Navigate to Forward"+ driver.getTitle());
    }
    public static void navigateRefresh(){

       Register.TC_001_Registration_Valid();
        driver.navigate().refresh();
    }

}
