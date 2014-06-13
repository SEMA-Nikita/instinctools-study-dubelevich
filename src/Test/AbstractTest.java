package Test;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AbstractTest
{
	protected static WebDriver driver;
	
	@BeforeClass
	public static void Init() {
		driver= new FirefoxDriver();
		driver.get("http://192.168.93.211:8081/sd/");
		
	}
	
	@AfterClass
	public static void clouse() {
		driver.quit();		
	}
	
}
