package Test;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Pages.AtouTitlePage;
import Pages.Company;
import Pages.CreateCompanyPage;
import Pages.HomePage;
import Pages.LoginPage;

public class CreatDepartmenTest extends AbstractTest 
{
	 private LoginPage loginPage;
	 private HomePage homePage;
	 private Company company;
	 private AtouTitlePage atouTitlePage;
	 private String login = "naumen";
	 private String password = "n@usd40";
	
	
	@Before
	public void setup ()
	 {
		super.Init();
		loginPage = new LoginPage(driver);
		homePage = loginPage.login(login, password);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 
	 }
	
	@Test
	public void test()
	{ 
		homePage = new HomePage(driver);
		company = homePage.swich();
		atouTitlePage = company.addStructure();
		atouTitlePage.createCompany();
		atouTitlePage.assertCompany(namecompany);
		
		
	}
	
	
	
	@After
	public void clousebrouser()
	{
		super.clouse();
	}
	
	

}
