package Test;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Pages.HomePage;
import Pages.LoginPage;

public class LogoutTest
{
	 private static WebDriver driver;
	 private LoginPage loginPage;
	 private HomePage homePage;
		
	 @Before
	 public void setup()
		{
		 // TODO убрать driver из тестов на уровень pages (смотри мой пример) 
		 driver= new FirefoxDriver();
			driver.get("http://192.168.93.211:8081/sd/");
			
			loginPage = new LoginPage(driver);
			loginPage.login("naumen", "n@usd40");
			
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
	 
	 @Test
	 public void test()
	 {
		 homePage= new HomePage(driver);
	     homePage.logout();
		Assert.assertFalse(loginPage.getinputtext().equals("��� ������������"));
	 }
	 
	 
	 @After
	 public void tearDown() 
	 {
	driver.quit();
	 }
}
