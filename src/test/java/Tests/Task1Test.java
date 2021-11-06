package Tests;

import Pages.Task1Page;	
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.ITestResult;
import org.testng.annotations.*;

import com.relevantcodes.extentreports.LogStatus;

public class Task1Test extends TestBase {

	Task1Page task1Page;

	@BeforeMethod
	public void setUp(Method method) {
		logger = extent.startTest(method.getName());	
	}
	
	@AfterMethod
	public void results(Method method,ITestResult result) throws Exception {
		// test new commit
		if(result.getStatus()==ITestResult.SUCCESS) {
			logger.log(LogStatus.PASS,"Test Passed");
		     String screenshotPath = Utils.getScreenShot(driver, result.getName());
			logger.log(LogStatus.PASS, logger.addScreenCapture(screenshotPath));	
		}
		
		else if (result.getStatus()==ITestResult.FAILURE) {
			logger.log(LogStatus.FAIL, "Test Case Failed is "+result.getThrowable());
              String screenshotPath = Utils.getScreenShot(driver, result.getName());
			logger.log(LogStatus.FAIL, logger.addScreenCapture(screenshotPath));
		}
		else {
			logger.log(LogStatus.SKIP, "Test Case Skipped is "+result.getName());
		}
	}
	@Test
	public void test_1() {

		//ExtentTest test = extent.createTest("Verify the third result in google");
		driver.get("https://www.google.com/");
		task1Page = new Task1Page(driver);

		String searchInput = "Selenuim webdriver";
		task1Page.Search(searchInput);
		//assertTrue(thirdResult.contains("What is Selenium WebDriver?"));
	}

}

