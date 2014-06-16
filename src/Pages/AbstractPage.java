package Pages;

import junit.framework.Assert;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AbstractPage {
	protected WebDriver driver;
	
	public AbstractPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy (id="gwt-debug-logout")
	private WebElement logoutElement;
	
	@FindBy (id="gwt-debug-editProfile")
	private WebElement signinUserName;
	
	@FindBy (id="gwt-debug-switchInterface")
	private WebElement swichInterface;
	
	
	public LoginPage logout ()
	{
		logoutElement.click();
		return new LoginPage(driver);
	}

	public void assertSignIn(String expectedUserName) 
	{
	    Assert.assertEquals(expectedUserName, signinUserName.getText());
	}
	
	public Company swich()
	{
		swichInterface.click();
		return new Company(driver);
	}

}
