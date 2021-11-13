package Tests;

import static org.testng.Assert.assertTrue;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Pages.Task2Page;

public class Task2Test extends TestBase {

    Task2Page task2Page;

    @Test
    public void img_has_been_uploaded_successfully() throws IOException {

        task2Page = new Task2Page(driver);

        driver.get("https://the-internet.herokuapp.com/");
        String imageName =prop.getProperty("imageName") ;
        String imagePath = CurrentPath + ("\\Uploads\\") + imageName;
        task2Page.uploadImage(imagePath);
        assertTrue(task2Page.Success.isDisplayed());

    }
}

