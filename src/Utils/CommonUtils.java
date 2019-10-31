package Utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class CommonUtils {

    static Date dNow = new Date();
    static SimpleDateFormat ft = new SimpleDateFormat ("yyyyMMdd-HHmmss");

    public static boolean takeScreenshot(WebDriver driver , String name ) {

        TakesScreenshot ts = (TakesScreenshot)driver;

        File source = ts.getScreenshotAs(OutputType.FILE);

        //Move image file to new destination
        File destination = new File ("/Users/apple/Desktop/Vineet Gulati/Desktop/Main Selenium/Selenium/Teamie/src/Screenshots1"+name+".png");
        try {
            //Copy file at destination

            FileUtils.copyFile(source, destination);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        } return true;
    }

    public static boolean launhBrowser(WebDriver driver , String url ) {
        try {
            driver.navigate().to(url);

            driver.manage().window().maximize();

        }catch(Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public static void waits(WebDriver driver , long time) {
        try {
            driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

