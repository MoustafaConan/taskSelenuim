package Tests;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class TestBase {

	protected static WebDriver driver ;
	protected static ExtentReports extent;
	protected static ExtentTest logger;

	@BeforeSuite
	public void start() {
		
		extent = new ExtentReports("extentReport.html", true);
		
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		driver.manage().window().maximize();
	}
	
	@AfterSuite
	public void tearDown() {
		
		extent.flush();
		driver.get(System.getProperty("user.dir")+"\\extentReport.html");

//		driver.close();

	}


}
