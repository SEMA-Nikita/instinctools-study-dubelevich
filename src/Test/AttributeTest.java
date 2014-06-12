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
import Pages.CreateTeamPage;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.TeamPage;

public class AttributeTest {
	 private static WebDriver driver;
	
	 @Before
	 public void setup()
		{
			driver= new FirefoxDriver();
			driver.get("http://192.168.93.211:8081/sd/");
			
			LoginPage loginPage = new LoginPage(driver);
			loginPage.login("naumen", "n@usd40");
			
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
	 
	 
	 @Test
	 public void test()
	 {
		 HomePage homePage = new HomePage(driver);
		 homePage.getTeam();
		 TeamPage teamPage = new TeamPage(driver);
		 teamPage.getTeam ();
		 CreateTeamPage createTeamPage = new CreateTeamPage(driver);
		 createTeamPage.create( );
		 
		 Assert.assertTrue(teamPage.getCreateTeamText().equals("znachenie"));
		 
		 teamPage.logout();
		 
	 }
	 
	 @After
	 public void tearDown() 
	 {
	driver.quit();
	 }
}
