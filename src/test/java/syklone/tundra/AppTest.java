package syklone.tundra;

import static org.junit.Assert.assertTrue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;



/**
 * Unit test for simple App.
 */
public class AppTest extends Base
{
    /**
     * 
     * Rigorous Test :-)
     */
	private static Logger log =LogManager.getLogger(Base.class.getName());
	WebDriver driver;
    @Test
    
    public void shouldAnswerWithTrue()
    {
        driver = Base.getDriver();
       log.info("getting title");
       System.out.println(driver.getTitle());
       assertEquals("reddit: the front page of the interne", driver.getTitle().toString());
    }
}
