package com.ScreenShot;

import com.Base.TestBase;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class PageScreenShot extends TestBase {
    public static void main(String a[]) throws IOException {
        chromeLaunch();
        openTestURL("https://demo.opencart.com/");
        generateScreenShot();

    }
    public static void generateScreenShot() throws IOException {
        //Take ScreenShot
      File sourceFile= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
      //Save Image
        FileUtils.copyFile(sourceFile,new File("./src/test/screenshots/pageImage.png"),true);
    }

}
