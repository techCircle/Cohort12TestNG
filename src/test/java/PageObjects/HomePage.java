package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.BaseClass;


public class HomePage{
	
	

	public HomePage() {	
		PageFactory.initElements(BaseClass.getDriver(), this);
	}

	
}
