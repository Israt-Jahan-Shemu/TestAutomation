package com.ScreenShot;

import com.Base.TestBase;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class SpecificScreenShot extends TestBase {
    public static void main(String a[]) throws IOException {
        chromeLaunch();
       // openTestURL("https://demo.opencart.com/index.php?route=account/login");
       // screenShotWebElement();
        openTestURL("https://www.bbc.com/");
        takeFullScreen();
    }
    public static void screenShotWebElement() throws IOException {
        WebElement captureWebElement=driver.findElement(By.cssSelector("#content > div > div:nth-child(2) > div"));
        //Take ScreenShot
        File sourceFile= ((TakesScreenshot)captureWebElement).getScreenshotAs(OutputType.FILE);
        //Save Image
        FileUtils.copyFile(sourceFile,new File("./src/test/screenshots/SelectedImage.jpg"));
    }
    public static void takeFullScreen() throws IOException {
        Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
        ImageIO.write(screenshot.getImage(), "jpg", new File("./src/test/screenshots/fullimage.jpg"));
    }
}
