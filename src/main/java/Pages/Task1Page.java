package Pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Task1Page extends PageBase {

	public Task1Page(WebDriver driver) {
		super(driver);
	}

	@FindBy(name="q")
	WebElement searchTxtBox;

	@FindBy(name="btnK")
	WebElement searchBtn;

	@FindBy(xpath="//*['tF2Cxc']/a/h3")
	List<WebElement> resultObject;

	public String  Search(String searchInput) {
		searchTxtBox.sendKeys(searchInput);
		searchTxtBox.submit();

		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(resultObject.get(0)));
		String thirdResult = resultObject.get(2).getText();
		System.out.println(thirdResult);
		return thirdResult;
	}


}
