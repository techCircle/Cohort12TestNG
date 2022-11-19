package Tests;

import org.testng.annotations.Test;

import Utilities.commonmethods;

public class searchBoxTest extends commonmethods {
	
	@Test
	public void searchBoxHappyPath() {
		
		String state = randomState();
		highLightElementMethod(cp.searchBox);
		sendKey(cp.searchBox,state);
		highLightElementMethod(cp.searchBoxButton);
		click(cp.searchBoxButton);
		assertTitle(state);
		System.out.println(state);
		
	}

}
