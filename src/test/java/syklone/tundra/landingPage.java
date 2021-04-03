package syklone.tundra;



import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import pageObjects.landingpage;

public class landingPage extends Base {
	private static Logger log =LogManager.getLogger(Base.class.getName());
	@Test
	public void Search() throws IOException, InterruptedException {
		WebDriver driver= Base.getDriver();
		landingpage pg = new landingpage(driver);
		if(pg.Home.getText().equals("Hoe")) {
			log.info("matched");
			
		}
		else {
			log.error("mismatched");
		}
		pg.Search.sendKeys("nsfw"+Keys.ENTER);
		Thread.sleep(2000);
		
	
	}
}
