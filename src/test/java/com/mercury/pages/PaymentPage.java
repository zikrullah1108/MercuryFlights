package com.mercury.pages;

import org.openqa.selenium.By;

import com.mercury.utilityLibrary.BasePage;

public class PaymentPage extends BasePage{
	
	private By pageWiat = By.name("bookflight");
	private String pageTitle = "Book a Flight: Mercury Tours";
	private By verifyDepartFlight = By.className("frame_header_info");
	private By verifyReturnFlight = By.className("data_left");
	private By firstNamepp = By.name("passFirst0");
	private By lastNamepp = By.name("passLast0");
	private By mealSelect = By.name("pass.0.meal");
	private By creditCardSelect = By.name("creditCard");
	private By cardNum = By.name("creditnumber");
	private By expirMonth = By.name("cc_exp_dt_mn");
	private By expirYear = By.name("cc_exp_dt_yr");
	private By ccFirstNamePp = By.name("cc_frst_name");
	private By ccMiddleName = By.name("cc_mid_name");
	private By ccLastNamePp = By.name("cc_last_name");
	private By bAddress = By.name("billAddress1");
	private By bCity = By.name("billCity");
	private By bState = By.name("billState");
	private By bPostal = By.name("billZip");
	private By bCountrySelect = By.name("billCountry");
	private By addressCheckbox = By.name("ticketLess");
	private By dAddressPp = By.name("delAddress1");
	private By dCityPp = By.name("delCity");
	private By dStatePp = By.name("delState");
	private By dZipPp = By.name("delZip");
	private By dCountry = By.name("delCountry");
	private By purchase = By.name("buyFlights");
	
	public PaymentPage fillOutPaymentInfo()
	{
		ul.fluentWait(pageWiat);
		ul.verifyTitle(pageTitle);
		ul.verifyText(verifyDepartFlight, "Paris to New York");
		ul.verifyText(pageWiat,verifyReturnFlight, 1, "New York to Paris");
		ul.verifyText(pageWiat, verifyReturnFlight, 9, "$1177");
		ul.enterTextField(firstNamepp, "Zeke");
		ul.enterTextField(lastNamepp, "Salem");
		ul.selectDropDown(mealSelect, "Muslim");
		ul.selectDropDown(creditCardSelect, "Visa");
		ul.enterTextField(cardNum, "5529420350615465");
		ul.selectDropDown(expirMonth, "09");
		ul.selectDropDown(expirYear, "2008");
		ul.enterTextField(ccFirstNamePp, "Zeke");
		ul.enterTextField(ccMiddleName, "middle");
		ul.enterTextField(ccLastNamePp, "Salem");
		ul.handleCheckBox(addressCheckbox, 0, true);
		ul.enterTextField(bAddress, "4327 Ravensworth Rd");
		ul.enterTextField(bCity, "Annandale");
		ul.enterTextField(bState, "VA");
		ul.enterTextField(bPostal, "22003");
		ul.selectDropDown(bCountrySelect, "UNITED STATES");
		ul.handleCheckBox(addressCheckbox, 1, true);
		ul.enterTextField(dAddressPp, "5049 Tibbitt ln");
		ul.enterTextField(dCityPp, "Burke");
		ul.enterTextField(dStatePp, "VA");
		ul.enterTextField(dZipPp, "22015");
		ul.selectDropDown(dCountry, "UNITED STATES");
		ul.clickElement(purchase);
		
		return this;
	}
}
