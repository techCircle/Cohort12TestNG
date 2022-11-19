package Utilities;

import static org.testng.Assert.*;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.github.javafaker.Faker;

public class commonmethods extends PageInitializer{	
	public static boolean isDemoMode = true;
	public static Faker faker = new Faker();
		
	public String randomFirstName() {
		
		
		return faker.name().firstName();
	}
	
	public String randomFlag() {
		faker = new Faker();
		
		return faker.country().flag();
	}
	
	public String randomState() {
		return faker.address().state();
	}
	
	
	
	
	
	/*
		 * 
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
			
			
			/*
			 * This is just wait from mili sec. to  sec
			 */
		}
		 public static void wait(double second) {
		        try {
		            Thread.sleep((int) (second * 1000));
		        } catch (Exception e) {
		          
		        }

		    }
		 
		
		 
		 /*
		  * this is indicator for element blinks
		  */
		public static void highLightElementMethod(WebElement element) {

	        try {
	            if (isDemoMode) {
	                for (int i = 0; i <= 2; i++) {

	                    //Create object of a JavascriptExecutor interface
	                    JavascriptExecutor js = (JavascriptExecutor) driver;
	                    //use executeScript() method and pass the arguments
	                    //Here i pass values based on css style. Yellow background color with solid red color border.
	                    js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);

	                    wait(0.2);


	                    //Create object of a JavascriptExecutor interface
	                    js = (JavascriptExecutor) driver;
	                    //use executeScript() method and pass the arguments
	                    //Here i pass values based on css style. Yellow background color with solid red color border.
	                    js.executeScript("arguments[0].setAttribute('style', 'background: red; border: 2px solid yellow;');", element);


	                    wait(0.2);


	                    //Create object of a JavascriptExecutor interface
	                    js = (JavascriptExecutor) driver;
	                    //use executeScript() method and pass the arguments
						// Here i pass values based on css style. Yellow background color with solid red
						// color border.
				           js.executeScript("arguments[0].setAttribute('style', 'background: white; border: 2px solid red;');", element);
	                }
	            }
	        } catch (Exception e) {
	           
	        }

	    }
		
		/*
		 * this is getting the title 
		 */
		public static void getTittle() {
			driver.getTitle();
		}
		
		public static void getUrl(String url) {
			driver.get(url);
		}

		

		
}
