package syklone.tundra;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	private static WebDriver driver;

	public static WebDriver getDriver() {
		return driver;
	}
	private static Logger log =LogManager.getLogger(Base.class.getName());
	public WebDriver initialize() throws IOException {
		FileInputStream fil = new FileInputStream("C:\\Users\\VRK CHAITANYA\\e2eproject\\tundra\\data.properties");
		Properties prop = new Properties();
		prop.load(fil);
		String browser = prop.getProperty("browser");
		log.info(browser);
		if (browser.equals("Chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			driver = new ChromeDriver(options);
		} else if (browser.equals("FIREFOX")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

		} else if (browser.equals("EDGE")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;
	}

	@AfterSuite
	public void teardown() {
		log.info("browser closed");
		driver.quit();
	}
	
	public void getScreenShot(String tsname,WebDriver driver) throws IOException {
		TakesScreenshot ts=(TakesScreenshot) driver; 
		File source =ts.getScreenshotAs(OutputType.FILE);
		String dFile =System.getProperty("user.dir")+"\\reports\\"+tsname+".png"; 
		FileUtils.copyFile(source,new File(dFile) );
	}

}
