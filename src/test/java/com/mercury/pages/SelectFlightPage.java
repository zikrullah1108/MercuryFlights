package com.mercury.pages;

import org.openqa.selenium.By;

import com.mercury.utilityLibrary.BasePage;

public class SelectFlightPage extends BasePage {	
	
	private By pageWait = By.name("results");
	private String pageTitle = "Select a Flight: Mercury Tours";
	
	private By selectAirline = By.className("frame_action_xrows");
	
	private By continueButton = By.name("reserveFlights");
	
	public SelectFlightPage ticket_Depart_And_Return()
	{
		ul.fluentWait(pageWait);
		ul.verifyTitle(pageTitle);
		
		ul.selectRadioButton2(selectAirline, 1);
		ul.selectRadioButton2(selectAirline, 5);
		ul.clickElement(continueButton);
		return this;
	}

}

