package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Company extends AbstractPage
{
	public Company(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	@FindBy(className="gwt-TabLayoutPanelTabInner")
	private WebElement orgStructure;
	
	@FindBy(xpath="//div[@class='g-button-text']//*[@href='#fqn:team']")
	private WebElement addStructures;
	
	
	public void orgStructureS ()
	{
		orgStructure.click();
	
	}
	public AtouTitlePage addStructure()
	{
		addStructures.click();
		return new AtouTitlePage(driver);
	}
	

}
