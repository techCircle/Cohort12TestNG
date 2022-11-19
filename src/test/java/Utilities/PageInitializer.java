package Utilities;

import PageObjects.CommonPage;
import PageObjects.HomePage;

public class PageInitializer extends BaseClass {

	public static HomePage hp;
	public static CommonPage cp;

	public static void initialize() {
		hp = new HomePage();
		cp = new CommonPage();
	}

}
