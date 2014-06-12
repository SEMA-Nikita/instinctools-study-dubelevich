package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TeamPage extends AbstractPage {
	private static WebDriver driver;
	public TeamPage(WebDriver driver)
	{
		super(driver);
		TeamPage.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath=".//*[@id='gwt-debug-flex-add']")
	private static WebElement addbuttonElement;	
	
	@FindBy(xpath=".//*[@id='gwt-debug-znachenie.title']")
	private static WebElement TeamElement;	
	
	
	public static CreateTeamPage getTeam ()
	{
		addbuttonElement.click();
		return new CreateTeamPage(driver);
	}
	public String getCreateTeamText() 
	{
	    return TeamElement.getText();
	}
	
	

}

