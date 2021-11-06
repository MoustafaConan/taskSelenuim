package Tests;


import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import static org.testng.Assert.assertEquals;

import java.lang.reflect.Method;

import Pages.Task3Page;


public class Task3Test  extends TestBase {
	Task3Page task3Page;

	@BeforeMethod
	public void setUp(Method method) {
		logger = extent.startTest(method.getName());
	}

	@AfterMethod
	public void results(ITestResult result) throws Exception {
		if(result.getStatus()==ITestResult.SUCCESS) {
			logger.log(LogStatus.PASS,"Test Passed");
		    String screenshotPath = Utils.getScreenShot(driver, result.getName());
					logger.log(LogStatus.PASS, logger.addScreenCapture(screenshotPath));
					
		}
		
		else if (result.getStatus()==ITestResult.FAILURE) {
			logger.log(LogStatus.FAIL,"Test Failed");
			
			logger.log(LogStatus.FAIL, "Test Case Failed is "+result.getName());
			logger.log(LogStatus.FAIL, "Test Case Failed is "+result.getThrowable());
			//To capture screenshot path and store the path of the screenshot in the string "screenshotPath"
                        String screenshotPath = Utils.getScreenShot(driver, result.getName());
			//To add it in the extent report 
			logger.log(LogStatus.FAIL, logger.addScreenCapture(screenshotPath));
		}
		else {
			logger.log(LogStatus.SKIP, "Test Case Skipped is "+result.getName());
		}
	}

	@Test	
	public void element_is_loaded() {
		//ExtentTest test= extent.createTest("element is loaded");
		task3Page = new Task3Page(driver);
		driver.get("https://the-internet.herokuapp.com/");
		task3Page.gotoexample2();
		assertEquals("Hello World!", task3Page.helloWorld.getText());
	}
}

