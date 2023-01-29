package jp.seleniumDemo.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import jp.seleniumDemo.utils.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;



import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected WebDriver driver;
    protected static ExtentHtmlReporter htmlReporter;
    protected static ExtentReports extentReports;

    @BeforeSuite
    public void beforeSuite(){
        htmlReporter= new ExtentHtmlReporter("index.html");
        extentReports = new ExtentReports();
        extentReports.attachReporter(htmlReporter);
    }

    @AfterSuite
    public void afterSuite(){
        htmlReporter.flush();
        extentReports.flush();
    }



    @BeforeMethod
    public void setup() throws IOException {;
        WebDriverManager.chromedriver().setup();
        driver = DriverFactory.getDriver();
        String URL = "http://seleniumdemo.com";
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(URL);
    }
//    @AfterMethod
//    public void tearDown(){
//        driver.quit();
//    }
}
