package com.mercury.pages;

import org.openqa.selenium.By;

import com.mercury.utilityLibrary.BasePage;

public class MercuryFlightPage extends BasePage{
	
	private By tripType = By.name("tripType");
	private String MercuryFlightPageTitle = "Find a Flight: Mercury Tours:";
	private By formName = By.name("findflight");
	private By passengerDropDown = By.name("passCount");
	private By DepartFromDropDown = By.name("fromPort");
	private By DepartDateMonthDropDown = By.name("fromMonth");
	private By DepartDateDayDropDown = By.name("fromDay");
	private By ArriveInDropDown = By.name("toPort");
	private By ArriveDateMonthDropDown = By.name("toMonth");
	private By ArriveDateDayDropDown = By.name("toDay");
	private By AirlineDropDown = By.name("airline");
	private By continueButton = By.name("findFlights");
	private By serviceClass = By.name("servClass");
	
	public MercuryFlightPage verifyMercuryFlightPage()
	{
		ul.fluentWait(tripType);
		ul.verifyTitle(MercuryFlightPageTitle);
		return this;
	}
	
	public MercuryFlightPage fillOutFlightInfo()
	{
		ul.selectRadioButton(formName, 0);
		ul.selectDropDown(passengerDropDown, "2");
		ul.selectDropDown(DepartFromDropDown, "Paris");
		ul.selectDropDown(DepartDateMonthDropDown, "December");
		ul.selectDropDown(DepartDateDayDropDown, "10");
		ul.selectDropDown(ArriveInDropDown, "New York");
		ul.selectDropDown(ArriveDateMonthDropDown, "June");
		ul.selectDropDown(ArriveDateDayDropDown, "10");
		ul.selectRadioButton2(serviceClass, 2);
		ul.selectDropDown(AirlineDropDown, "Unified Airlines");
		ul.clickElement(continueButton);
		return this;
	}
}
