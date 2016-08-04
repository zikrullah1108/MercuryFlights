package com.mercury.utilityLibrary;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

public class BasePage {
	public static WebDriver driver;
	public static UIFunction ul;
	public String browser;

	@Before
	public void beforeEachTest() {
		ul = new UIFunction(driver);
		driver = ul.startLocalBrowser("Firefox");
		System.out.println("******** Test Started ********");
	}

	@After
	public void afterEachTest() {
		ul.customWait(5);
		System.out.println("******** Test Ended ********");
	}

	@AfterClass
	public static void afterAllTest() {
		if (driver != null) {
			driver.close();
			driver.quit();
		}
	}
}
