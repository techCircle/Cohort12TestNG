package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.BaseClass;

public class CommonPage {

	public CommonPage() {
		PageFactory.initElements(BaseClass.getDriver(), this);
	}

	@FindBy(xpath = "//*[@id='twotabsearchtextbox']")
	public WebElement searchBox;

	@FindBy(xpath = "//*[@id='nav-search-submit-button']")
	public WebElement searchBoxButton;
	
	
	
	
	
	
	
	
	

}
