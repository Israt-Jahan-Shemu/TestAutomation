package com.OpenCart;

import com.Base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Register extends TestBase {

    public static void main(String args[]){
        chromeLaunch();
        FirstNameInputField();
       // TC_001_Registration_Valid();
       // chromeClose();

    }

    public static void TC_001_Registration_Valid() {
        //step 1
        driver.get("https://demo.opencart.com/index.php?route=account/register");

        //step 2
        WebElement fName = driver.findElement(By.id("input-firstname"));
        fName.sendKeys("Israt Jahan");

        //step 3
        WebElement lName = driver.findElement(By.id("input-lastname"));
        lName.sendKeys("Shemu");

        //step 4
        WebElement Email = driver.findElement(By.id("input-email"));
        Email.sendKeys("isratshimu@gmail.com");

        //step 5
        WebElement Telephone = driver.findElement(By.id("input-telephone"));
        Telephone.sendKeys("01212120227");

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
       WebElement logout= driver.findElement(By.linkText("Logout"));
      logout.click();
    }
    public static void FirstNameInputField(){

        driver.get("https://demo.opencart.com/index.php?route=account/register");

       // Passing long input
        WebElement firstName1=driver.findElement(By.id("input-firstname"));
        firstName1.sendKeys("fhsdgfjdgfjjjjjjjjjjjjjjjjjjjjjjkdlsjfklj;kl;;klkl,lllllllllllllllll");
        WebElement ClickContinue = driver.findElement(By.cssSelector(".btn-primary"));
        ClickContinue.click();
        String Exp_Title="First Name must be between 1 and 32 characters!";
        String Actual_Title= driver.findElement(By.cssSelector("#account > div:nth-child(3) > div > div")).getText();

        if(Exp_Title.equals(Actual_Title)){
            System.out.println("Test passed for First Name");
        }
        else {
            System.out.println("Test failed for First Name");

        }

        //Passing valid input
        driver.get("https://demo.opencart.com/index.php?route=account/register");
        WebElement firstName2=driver.findElement(By.id("input-firstname"));
        firstName2.sendKeys("shemu");
        ClickContinue = driver.findElement(By.cssSelector(".btn-primary"));
        ClickContinue.click();

      try{
          Actual_Title= driver.findElement(By.cssSelector("#account > div:nth-child(3) > div > div")).getText();
          System.out.println("invalid input.Bug found");

        }
      catch (Exception a){

          System.out.println("valid input.Bug not found");

      }

      //Passing null input
        driver.get("https://demo.opencart.com/index.php?route=account/register");
        WebElement firstName3=driver.findElement(By.id("input-firstname"));
        firstName3.sendKeys(" ");
        ClickContinue = driver.findElement(By.cssSelector(".btn-primary"));
        ClickContinue.click();

        try{
            Actual_Title= driver.findElement(By.cssSelector("#account > div:nth-child(3) > div > div")).getText();
            System.out.println("invalid input.Bug found");

        }
        catch (Exception a){

            System.out.println("valid input.Bug not found");

        }

    }




}
