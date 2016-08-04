package com.mercury.pages;

import com.mercury.utilityLibrary.BasePage;
import static org.junit.Assert.assertEquals;

public class GoogleHomePage extends BasePage {
	
	private String googleHomePageURL = "https://www.google.com/";
	private String googleHomePageTitle = "Google";
	
	public GoogleHomePage goto_googleHomePage()
	{
		driver.get(googleHomePageURL);
		ul.verifyTitle(googleHomePageTitle);
		return this;
	}
	
	
}
