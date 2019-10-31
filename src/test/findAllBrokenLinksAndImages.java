package test;

import Utils.BaseTest;
import Utils.CommonUtils;
import Utils.SimpleReportFactory;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Driver;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class findAllBrokenLinksAndImages extends BaseTest {

    ExtentReports reporter = SimpleReportFactory.getReporter(browser);
    ExtentTest testReporter;
    @Test
    public void findBrokenImagesAndLinks() {
        try {
            testReporter = reporter.startTest("Login page urls test", "verifying broken links");
            testReporter.log(LogStatus.INFO, "Starting Login page test");
            String url1 = "";
            HttpURLConnection huc;
            int resCode;

            String homepage = "https://teamie-next.teamieapp.com";

            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            CommonUtils.launhBrowser(driver, homepage);

            WebElement element = driver.findElement(By.id("Test"));
            element.getAttribute("css");
            driver.manage().window().fullscreen();

            List<WebElement> linksList = driver.findElements(By.tagName("img"));
            System.out.println(linksList.size());
            Iterator<WebElement> itr = linksList.iterator();
            while (itr.hasNext()) {
                url1 = itr.next().getAttribute("src");

                if (url1 == null || url1.isEmpty()) {
                    System.out.println(url1 + " - This url is not configured properly");
                }
                try {
                    assert url1 != null;
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (url1.startsWith(homepage)) {
                    System.out.println(url1 + " - This url is Working fine and home url");
                }

                if (!url1.startsWith(homepage)) {
                    System.out.println(url1 + " - This url is Working fine and but not home url so skipping it");

                }
                try {
                    huc = (HttpURLConnection) (new URL(url1).openConnection());
                    huc.setRequestMethod("HEAD");
                    huc.connect();
                    resCode = huc.getResponseCode();
                    if (resCode >= 400) {
                        System.out.println(url1 + " - THis is broken url");
                    }
                    if (resCode <= 400) {
                        System.out.println(url1 + "  - THis is not broken url");
                    }


                } catch (MalformedURLException w) {
                    w.printStackTrace();
                } catch (IOException r) {
                    r.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                }


            }
            reporter.endTest(testReporter);
        }
        catch (Exception ee){ee.printStackTrace();}
    }



    @AfterClass
    public void afterClass()
    {

        SimpleReportFactory.closeReporter();
        driver.quit();

    }
    @AfterMethod
    public void takeScreen(){
        String links = "homePage";
        CommonUtils.takeScreenshot(driver,links);
    }
}



