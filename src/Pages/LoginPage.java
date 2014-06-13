package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends AbstractPage
{
	public LoginPage(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
@FindBy(id="username")
private WebElement loginElement;

@FindBy(id="password")
private WebElement passwordElement;

@FindBy(css=".submit-button")
private WebElement submitElement;

@FindBy(id="errorMessage")
private WebElement errorElement;

@FindBy(id="usernameLabel")
private WebElement inputElement;

public   HomePage  login(String login, String password)
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
