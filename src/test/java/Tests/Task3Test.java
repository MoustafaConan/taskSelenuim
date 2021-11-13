package Tests;


import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;

import Pages.Task3Page;


public class Task3Test extends TestBase {
    Task3Page task3Page;

    @Test
    public void element_is_loaded() throws IOException {
        //ExtentTest test= extent.createTest("element is loaded");
        task3Page = new Task3Page(driver);
        String URL = prop.getProperty("task3URL");
        driver.get(URL);

        task3Page.gotoexample2();

        assertEquals(prop.getProperty("ConfirmMessage"), task3Page.helloWorld.getText());
    }
}

