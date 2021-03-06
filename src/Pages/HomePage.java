package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends AbstractPage
{
	public HomePage(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@class='MainContentPanel']//*[@href='#fqn:team']")
	private static WebElement teamElement;
	
	public TeamPage getTeam ()
	{
		teamElement.click();
		return new TeamPage(driver);
	}
	
}
