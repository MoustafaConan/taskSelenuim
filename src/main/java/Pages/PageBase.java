package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageBase {
	
	WebDriver driver;

	public PageBase(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void scroll_down(){
		JavascriptExecutor java = (JavascriptExecutor)driver;
		java.executeScript("scroll(0,250)");
	}
	
}
