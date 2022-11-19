package Utilities;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;
	private static Properties configFile;

	@BeforeMethod
	public static WebDriver getDriver() {

		if (driver == null) {

			switch (BaseClass.getProperty("browser")) {

			case "chrome":
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				break;
			case "chrome-headless":
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver(new ChromeOptions().setHeadless(true));
			case "firefox":
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				break;
			case "firefox-headless":
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver(new FirefoxOptions().setHeadless(true));
			case "edge":

				if (!System.getProperty("os.name").toLowerCase().contains("windows")) {
					throw new WebDriverException("Your OS doesn't support Edge");
				}

				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
				break;
			case "safari":

				if (!System.getProperty("os.name").toLowerCase().contains("mac")) {
					throw new WebDriverException("Your OS doesn't support Safari");
				}
				WebDriverManager.safaridriver().setup();
				driver = new SafariDriver();
				break;

			}

			driver.get(BaseClass.getProperty("url"));
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Constants.explicit_wait_time, TimeUnit.SECONDS);
			PageInitializer.initialize();

		}

		return driver;

	}
	
	
	

	static {

		try {
			String filePath = Constants.propertiesFilePath;

			FileInputStream input = new FileInputStream(filePath);

			configFile = new Properties();
			configFile.load(input);

			input.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public static String getProperty(String keyName) {
		return configFile.getProperty(keyName);
	}
	
	
	
	/*
	 * add this tearDown
	 */
	@AfterMethod
	public static void tearDown() {

		if (driver != null) {
			driver.close();
			driver.quit();
			driver = null;
		}
	}

}
