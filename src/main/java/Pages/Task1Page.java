package Pages;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class Task1Page extends PageBase {

	public Task1Page(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(name="q")
	WebElement searchTxtBox;
	
	@FindBy(name="btnK")
	WebElement searchBtn;
	
	@FindBy(xpath="/html/body/div[1]/div[3]/form/div[1]/div[1]/div[2]/div[2]/div[2]/ul/li[3]")
	public WebElement thirdResult;
	
	@Test
	public void Search(String searchInput) {
		
		searchTxtBox.sendKeys(searchInput);
		//searchBtn.click();
		System.out.println(thirdResult.getText());
		
	}
	

}
