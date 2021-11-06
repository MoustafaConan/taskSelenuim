package Tests;
import static org.testng.Assert.assertTrue;

import java.lang.reflect.Method;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Pages.Task2Page;

public class Task2Test  extends TestBase {

	Task2Page task2Page;
	
	@BeforeMethod
	public void setUp(Method method) {
		logger = extent.startTest(method.getName());
		
	}
	
	@AfterMethod
	public void results(Method method,ITestResult result) throws Exception {
		// Commit last time
		if(result.getStatus()==ITestResult.SUCCESS) {
			logger.log(LogStatus.PASS,"Test Passed");
		    String screenshotPath = Utils.getScreenShot(driver, result.getName());
					logger.log(LogStatus.PASS, logger.addScreenCapture(screenshotPath));
					
		}
		
		else if (result.getStatus()==ITestResult.FAILURE) {
			logger.log(LogStatus.FAIL,"Test Failed");
			
			logger.log(LogStatus.FAIL, "Test Case Failed is "+result.getName());
			logger.log(LogStatus.FAIL, "Test Case Failed is "+result.getThrowable());
             String screenshotPath = Utils.getScreenShot(driver, result.getName());
			//To add it in the extent report 
			logger.log(LogStatus.FAIL, logger.addScreenCapture(screenshotPath));
		}
		else {
			logger.log(LogStatus.SKIP, "Test Case Skipped is "+result.getName());
		}
	}


	@Test
	public void img_has_been_uploaded_successfully() {

		task2Page = new Task2Page(driver);

		driver.get("https://the-internet.herokuapp.com/");
		String imageName="avatar-blank.png";
		String imagePath=System.getProperty("user.dir")+("\\Uploads\\")+ imageName;

		task2Page.uploadImage(imagePath);

		assertTrue(task2Page.Success.isDisplayed());	

	}
}

