package com.mercury.pages;

import org.openqa.selenium.By;

import com.mercury.utilityLibrary.BasePage;

public class MercuryHomePage extends BasePage{
	
	private By userTextField = By.name("userName");
	private String mercuryHomePageTitle = "Welcome: Mercury Tours";
	private By registerLinkText = By.linkText("Register here");
	
	public MercuryHomePage VerifyMercuryHomePageTitle_clickRegister()
	{
		ul.fluentWait(userTextField);
		ul.verifyTitle(mercuryHomePageTitle);
		ul.clickElement(registerLinkText);
		return this;
	}
	
}
