package syklone.tundra;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.homepage;

public class Homepagerediff extends Base{

	//public WebDriver driver;
	@Test(dataProvider="data")
	public void logNavigation(String uname,String password) throws IOException {
		WebDriver driver = Base.getDriver();
		driver = initialize();
		FileInputStream fis =new FileInputStream("C:\\Users\\VRK CHAITANYA\\e2eproject\\tundra\\data.properties");

		Properties prop =new Properties();
		prop.load(fis);
		String URL=prop.getProperty("URL");
		driver.get(URL);
		homepage pg = new homepage(driver);
		pg.Login.click();
		WebDriverWait ww=new WebDriverWait(driver, 10);
		
//		System.out.println("hello");
//		System.out.println(driver.findElements(By.tagName("iframe")).size());
		driver.switchTo().frame(0);
		ww.until(ExpectedConditions.visibilityOf(pg.Username));
		pg.Username.sendKeys(uname);
		pg.Password.sendKeys(password);
		pg.Submit.click();
	}
			
	
	@DataProvider
	public Object[][] data(){
		Object[][] data=new Object[2][2];
		data[0][0]="Shillofnoone";
		data[0][1]="123@VRKc";
		
		data[1][0]="Shillofnoone";
		data[1][1]="123@VRKc";
		return data;
	}
}
