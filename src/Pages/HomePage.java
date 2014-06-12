package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends AbstractPage
{
	private static WebDriver driver;
	public HomePage(WebDriver driver)
	{
		super(driver);
		HomePage.driver = driver;
	PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@class='MainContentPanel']//*[@href='#fqn:team']")
	private static WebElement teamElement;
	

	public static TeamPage getTeam ()
	{
		teamElement.click();
		return new TeamPage(driver);
	}
	
}
