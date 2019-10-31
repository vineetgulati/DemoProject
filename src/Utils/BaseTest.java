package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.mustache.Value;

public class BaseTest
  {
    protected WebDriver driver=null;
    protected String browser ;

    @Parameters({ "browser" })
    @BeforeTest
    public void setUp(String browser)

    {

        this.browser = browser;

        if (driver==null)
        {
        if (browser.equalsIgnoreCase("chrome"))
        {
            System.setProperty("webdriver.chrome.driver", "/Users/apple/Desktop/Vineet Gulati/Desktop/Main Selenium/Selenium/Teamie/chromedriver");
            driver = new ChromeDriver();

        }
        else if (browser.equalsIgnoreCase("firefox"))
        {

           // System.setProperty("webdriver.gecko.driver", "/Users/apple/Desktop/Vineet Gulati/Desktop/Main Selenium/Selenium/Teamie/geckodriver");
            driver = new FirefoxDriver();
        }
        }
    }
  }
