package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
	private static WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		LoginPage.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
@FindBy(id="username")
private static WebElement loginElement;

@FindBy(id="password")
private static WebElement passwordElement;

@FindBy(css=".submit-button")
private static WebElement submitElement;

@FindBy(id="errorMessage")
private static WebElement errorElement;

@FindBy(id="usernameLabel")
private  WebElement inputElement;

public static  HomePage  login(String login, String password)
{
	loginElement.sendKeys(login);
	passwordElement.sendKeys(password);
	submitElement.click();
	return new HomePage(driver);
 }
public String getErrorMessage() 
{
    return errorElement.getText();
}

public String getinputtext() 
{
    return inputElement.getText();
}
}
