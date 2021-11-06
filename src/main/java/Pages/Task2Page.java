package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Task2Page extends PageBase {

	public Task2Page(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(linkText = "File Upload")
	WebElement fileUploadLink;
	
	@FindBy(id="file-upload")
	WebElement chooseFileBtn;
	
	@FindBy(id="file-submit")
	WebElement uploadBtn;
	
	@FindBy (xpath="//*[@id='content']/div")
	public WebElement Success;
	
	public void uploadImage(String path) {
		
		fileUploadLink.click();
		chooseFileBtn.sendKeys(path);
		uploadBtn.click();	
		
	}
	

}
