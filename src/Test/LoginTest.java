package Test;

//TODO убрать неиспользуемые import
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
		// TODO убрать driver из тестов на уровень pages (смотри мой пример) 
		driver= new FirefoxDriver();
		driver.get("http://192.168.93.211:8081/sd/");
	}
	
	@Test
	public void testValidLoginLogout ()
	{
		// TODO LoginPage уже объявлен как поле класса. Зачем он же снова объявлен в рамках теста?
		// TODO инициализацию LoginPage перенести в конструктор класса
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login("naumen", "n@usd40");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Assert.assertTrue(driver.getTitle().toLowerCase().startsWith("naumen"));
		//AbstractPage abstractPage = new AbstractPage(driver);
		// TODO HomePage в поле класса
		HomePage homePage = new HomePage(driver);
		// TODO нельзя тестировать вход и выход в одном тесте. Разделить на два теста
		homePage.logout();
		Assert.assertFalse(loginPage.getinputtext().equals("��� ������������"));
	}
	
	@Test
	public void testInvalidLgin()
	{
		// TODO LoginPage уже объявлен как поле класса. Зачем он же снова объявлен в рамках теста?
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login("naumen", "n@usd40hj");
		 Assert.assertTrue(loginPage.getErrorMessage().equals("���������� ����� � �������. ������������ ��� ������������ �/��� ������. ���������� ��������� ����."));
	}
	
	@After
	public void tearDown()
	{
		driver.quit();
	}
}



