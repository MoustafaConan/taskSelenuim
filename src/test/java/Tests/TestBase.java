package Tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import java.time.Duration;

import com.relevantcodes.extentreports.LogStatus;
import io.cucumber.java.Before;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class TestBase {

    protected static WebDriver driver;
    protected static ExtentReports extent;
    protected static ExtentTest logger;

    Properties prop;
    String CurrentPath = System.getProperty("user.dir");
    FileInputStream fis;

    @BeforeSuite
    public void start() {

        extent = new ExtentReports("extentReport.html", true);
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void results(Method method, ITestResult result) throws Exception {
        // test new commit
        if (result.getStatus() == ITestResult.SUCCESS) {
            logger.log(LogStatus.PASS, "Test Passed");
            String screenshotPath = Utils.getScreenShot(driver, result.getName());
            logger.log(LogStatus.PASS, logger.addScreenCapture(screenshotPath));
        } else if (result.getStatus() == ITestResult.FAILURE) {
            logger.log(LogStatus.FAIL, "Test Case Failed is " + result.getThrowable());
            String screenshotPath = Utils.getScreenShot(driver, result.getName());
            logger.log(LogStatus.FAIL, logger.addScreenCapture(screenshotPath));
        } else {
            logger.log(LogStatus.SKIP, "Test Case Skipped is " + result.getName());
        }
    }

    @BeforeMethod
    void SetUp(Method method) throws IOException{
        logger = extent.startTest(method.getName());
        readData();
    }

    private void readData() throws IOException {
        prop= new Properties();
        String CurrentPath = System.getProperty("user.dir");
        fis=new FileInputStream(CurrentPath + "/src/Data/testData.properties");
        prop.load(fis);
    }

    @AfterSuite
    public void tearDown() {

        extent.flush();
        driver.get(System.getProperty("user.dir") + "\\extentReport.html");

//		driver.close();

    }

}