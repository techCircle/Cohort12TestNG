package Utilities;

import static org.testng.Assert.*;

import org.openqa.selenium.WebElement;

public class commonmethods extends PageInitializer{	
		
		/*
		 * This method for sending String(text) to the element we have given.
		 * 
		 * @params: 
		 * 	Webelement element = it is accepting the webelement where we are sending the text
		 *  String text = it is the parameter tha we are sending the String
		 */
		public static void sendKey(WebElement element, String text) {
			element.clear();
			element.sendKeys(text);
		}
		
		
		/*
		 * This method for clicking the given element
		 * 
		 */
		public static void click(WebElement element) {
			element.click();
		}

		/*
		 * This method for assertion check the title 
		 */
		public static void assertTitle(String text) {	
			assertTrue(driver.getTitle().contains(text));
			
		}
		

		
}
