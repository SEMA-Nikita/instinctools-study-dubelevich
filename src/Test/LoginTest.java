package Test;


import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import Pages.LoginPage;


public class LoginTest 
{
  private static WebDriver driver;
 private LoginPage loginPage;
 
  
	@Before
	public void setup()
	{
		// TODO убрать driver из тестов на уровень pages (смотри мой пример) 
		driver= new FirefoxDriver();
		driver.get("http://192.168.93.211:8081/sd/");
	}
	
	@Test
	public void testValidLoginLogout ()
	{
		loginPage= new LoginPage(driver);
		loginPage.login("naumen", "n@usd40");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Assert.assertTrue(driver.getTitle().toLowerCase().startsWith("naumen"));
		
	}
	
	@Test
	public void testInvalidLgin()
	{
		
		loginPage= new LoginPage(driver);
		loginPage.login("naumen", "n@usd40hj");
		 Assert.assertTrue(loginPage.getErrorMessage().equals("���������� ����� � �������. ������������ ��� ������������ �/��� ������. ���������� ��������� ����."));
	}
	
	@After
	public void tearDown()
	{
		driver.quit();
	}
}



