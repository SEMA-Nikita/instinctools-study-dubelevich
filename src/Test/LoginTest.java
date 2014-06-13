package Test;


import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import Pages.HomePage;
import Pages.LoginPage;


public class LoginTest extends AbstractTest
{
 private LoginPage loginPage;
 private HomePage homePage;
 private String login = "naumen";
 private String password = "n@usd40";
 
 @Before
 public void setup ()
 {
	 super.Init();
 }

	@Test
	public void testValidLoginLogout ()
	{
		loginPage = new LoginPage(driver);
		homePage = loginPage.login(login, password);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		homePage.assertSigIn(login);
		
	}
	
	@Test
	public void testInvalidLgin()
	{
		
		loginPage= new LoginPage(driver);
		loginPage.login("naumen", "n@usd40hj");
		 Assert.assertTrue(loginPage.getErrorMessage().equals("���������� ����� � �������. ������������ ��� ������������ �/��� ������. ���������� ��������� ����."));
	}
	
	@After
	public void clousebrouser()
	{
		super.clouse();
	}
}



