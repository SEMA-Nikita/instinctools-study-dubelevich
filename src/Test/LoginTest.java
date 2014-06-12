package Test;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Pages.AbstractPage;
import Pages.HomePage;
import Pages.LoginPage;


public class LoginTest 
{
  private static WebDriver driver;
 private LoginPage loginPage;
  
	@Before
	public void setup()
	{
		driver= new FirefoxDriver();
		driver.get("http://192.168.93.211:8081/sd/");
	}
	
	@Test
	public void testValidLoginLogout ()
	{
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login("naumen", "n@usd40");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Assert.assertTrue(driver.getTitle().toLowerCase().startsWith("naumen"));
		//AbstractPage abstractPage = new AbstractPage(driver);
		HomePage homePage = new HomePage(driver);
		homePage.logout();
		Assert.assertFalse(loginPage.getinputtext().equals("Имя пользователя"));
	}
	
	@Test
	public void testInvalidLgin()
	{
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login("naumen", "n@usd40hj");
		 Assert.assertTrue(loginPage.getErrorMessage().equals("Невозможно войти в систему. Неправильные имя пользователя и/или пароль. Попробуйте повторить ввод."));
	}
	
	@After
	public void tearDown()
	{
		driver.quit();
	}
}



