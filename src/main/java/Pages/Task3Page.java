package Pages;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Task3Page extends PageBase {

    public Task3Page(WebDriver driver) {
        super(driver);
        // TODO Auto-generated constructor stub
    }

    @FindBy(linkText = "Dynamic Loading")
    WebElement dynamicLink;

    @FindBy(linkText = "Example 2: Element rendered after the fact")
    WebElement example2;

    @FindBy(xpath = "//*[@id='start']/button")
    WebElement startBtn;

    @FindBy(xpath = "//*[@id=\"finish\"]/h4")
    public WebElement helloWorld;


    @Test
    public void gotoexample2() {

        dynamicLink.click();
        example2.click();
        startBtn.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(helloWorld));

    }


}
