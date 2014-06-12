package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateTeamPage extends AbstractPage {
	private static WebDriver driver;
	public CreateTeamPage(WebDriver driver)
	{
		super(driver);
		CreateTeamPage.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath=".//*[@id='gwt-debug-code-value']")
	private static  WebElement kodElement;
	@FindBy(xpath=".//*[@id='gwt-debug-title-value']")
	private static WebElement nameElement;
	@FindBy(xpath=".//*[@id='ou']")
	private static  WebElement cheboxElement;
	@FindBy(xpath=".//*[@id='gwt-debug-apply']")
	private static WebElement cretebutElement;
	
	public static TeamPage create( ) 
	{
		kodElement.sendKeys("znachenie");
		nameElement.sendKeys("znachenie");
		cheboxElement.click();
		cretebutElement.click();
		return new TeamPage (driver);
	}
	

}
