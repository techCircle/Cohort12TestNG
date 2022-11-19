package Tests;

import org.testng.annotations.Test;

import Utilities.commonmethods;

public class searchBoxTest extends commonmethods {
	
	@Test
	public void searchBoxHappyPath() {
		sendKey(cp.searchBox, "box");
		click(cp.searchBoxButton);
		assertTitle("box");
		
	}

}
