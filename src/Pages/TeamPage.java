package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TeamPage extends AbstractPage {
	public TeamPage(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath=".//*[@id='gwt-debug-flex-add']")
	private WebElement addbuttonElement;	
	
	@FindBy(xpath=".//*[@id='gwt-debug-znachenie.title']")
	private WebElement TeamElement;	
	
	
	public CreateTeamPage getTeam ()
	{
		addbuttonElement.click();
		return new CreateTeamPage(driver);
	}
	public String getCreateTeamText() 
	{
	    return TeamElement.getText();
	}
	
	

}

