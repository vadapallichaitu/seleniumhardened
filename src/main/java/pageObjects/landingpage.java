package pageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class landingpage {
	public static WebDriver driver;

	public landingpage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
//	By login =By.name();
//	By password =By.name("");
//	By submit =By.name("proceed");
	@FindBy(id="header-search-bar")
	public WebElement Search;
	
	@FindBy(xpath="//span[contains(text(),'Home')]")
	public WebElement Home;
//	public WebElement Login() {
//		return driver.findElement(login);
//	}
//	public WebElement () {
//		return driver.findElement(password);
//	}
//	public WebElement submit() {
//		return driver.findElement(submit);
//	}
}
