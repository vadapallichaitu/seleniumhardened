package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class homepage {
	public WebDriver driver;

	public homepage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
//	By login =By.name();
//	By password =By.name("");
//	By submit =By.name("proceed");
	@FindBy(linkText="Log In")
	public WebElement Login;
	
	@FindBy(id="loginUsername")
	public WebElement Username;
	
	@FindBy(name="password")
	public WebElement Password;
	
	@FindBy(xpath="//button[contains(text(),'Log In')]")
	public WebElement Submit;
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
