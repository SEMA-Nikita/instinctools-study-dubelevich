package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AbstractPage {
	private static WebDriver driver;
	
	public AbstractPage(WebDriver driver)
	{
		this.driver=driver;
	}

	@FindBy (id="gwt-debug-logout")
	private static WebElement logoutElement;
	
	public LoginPage logout ()
	{
		logoutElement.click();
		return new LoginPage(driver);
	}

}
