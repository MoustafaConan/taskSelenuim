package Pages;

import java.util.List;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Task1Page extends PageBase {

	public Task1Page(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(name="q")
	WebElement searchTxtBox;
	
	@FindBy(name="btnK")
	WebElement searchBtn;
	
	@FindBy(id="search")
	public WebElement Results;
	
	@Test
	public void Search(String searchInput) {
		
		searchTxtBox.sendKeys(searchInput);
		searchBtn.click();
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until((ExpectedConditions.visibilityOf(Results)));
		List<WebElement> list = Results.findElements(By.tagName("h3.span"));
		
		System.out.println(list.get(2));
		
		//return list.get(2).getText();
		
	}
	

}
