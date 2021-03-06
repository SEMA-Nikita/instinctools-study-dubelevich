package Test;

// TODO убрать неиспользуемые import
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import Pages.CreateTeamPage;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.TeamPage;

public class AttributeTest {
	 private static WebDriver driver;
	 private LoginPage loginPage;
	 private HomePage homePage;
	 private TeamPage teamPage;
	 private CreateTeamPage createTeamPage;
	 
	
	 @Before
	 public void setup()
		{
		 // TODO убрать driver из тестов на уровень pages (смотри мой пример) 
		 driver= new FirefoxDriver();
			driver.get("http://192.168.93.211:8081/sd/");
			
			loginPage= new LoginPage(driver);
			loginPage.login("naumen", "n@usd40");
			
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
	 
	 
	 @Test
	 public void test()
	 {
		 homePage= new HomePage(driver);
		 homePage.getTeam();
		 teamPage= new TeamPage(driver);
		 teamPage.getTeam ();
		 createTeamPage= new CreateTeamPage(driver);
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
