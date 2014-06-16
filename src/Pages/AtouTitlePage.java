package Pages;

import java.util.Random;

import junit.framework.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AtouTitlePage extends AbstractPage
{
	public AtouTitlePage(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="gwt-debug-title-value")
	private WebElement nameCompany ;
	
	@FindBy(id="gwt-debug-apply")
	private  WebElement saveButton;
	
	@FindBy(id="gwt-debug-title-value")
	private  WebElement newCompany;
	
	int lenght = 10;

	
public String getRandomString(int lenght)
{  
 StringBuilder builder = new StringBuilder();
 String baseString = "zxcvbnmlkjhgfdsaqwertyuiop";
 int baseStringLenght = baseString.length();
 
 Random random = new Random();
 
 for (int i = 0; i < lenght; i++ ) {
  int k = random.nextInt(baseStringLenght-1);
  
  char a_char = baseString.charAt(k);
  builder.append(a_char);
 }
String namecompany = builder.toString();

 return namecompany;
}
public void  createCompany (String namecompany){
	nameCompany.sendKeys(namecompany);
	saveButton.click();
}

public void assertCompany(String expectedNewCompany) 
{
    Assert.assertEquals(expectedNewCompany, newCompany.getText());
}

}