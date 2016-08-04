package com.mercury.pages;

import org.openqa.selenium.By;
import com.mercury.utilityLibrary.BasePage;

public class GoogleSearchPage extends BasePage {
	
	private By logoVerify = By.id("logo");
	private By searchBox = By.id("lst-ib");
	private By searchIcon = By.name("btnG");
	private By mercuryLink = By.linkText("Mercury Tours - 974636 www.demoaut.com");
	private String MercuryName = "mercury tours";
	
	public GoogleSearchPage search_MecuryTours()
	{
		ul.fluentWait(logoVerify);
		ul.enterTextField(searchBox, MercuryName);
		ul.clickElement(searchIcon);
		ul.clickElement(mercuryLink);
		
		return this;
	}
}
