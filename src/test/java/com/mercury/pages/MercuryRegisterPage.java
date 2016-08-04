package com.mercury.pages;

import org.openqa.selenium.By;

import com.mercury.utilityLibrary.BasePage;

public class MercuryRegisterPage extends BasePage {
	private By firstNameTextfield = By.name("firstName");
	private By lastNameTextfield = By.name("lastName");
	private By phoneTextfield = By.name("phone");
	private By emailTextfield = By.name("userName");
	private By addressTextfield = By.name("address1");
	private By cityTextfield = By.name("city");
	private By stateTextfield = By.name("state");
	private By postalTextfield = By.name("postalCode");
	private By usernameTextfield = By.id("email");
	private By passwordTextfield = By.name("password");
	private By confirmPasswordTextfield = By.name("confirmPassword");
	private By submitButton = By.name("register");
	private By flightLink = By.linkText("Flights");
	
	public MercuryRegisterPage verifyMercuryRegisterPageTitle()
	{
		ul.fluentWait(firstNameTextfield);
		ul.verifyTitle("Register: Mercury Tours");
		return this;
	}
	
	public MercuryRegisterPage fillOutRegisInfo()
	{
		ul.enterTextField(firstNameTextfield, "Zeke");
		ul.enterTextField(lastNameTextfield, "salem");
		ul.enterTextField(phoneTextfield, "123456789");
		ul.enterTextField(emailTextfield, "zeke@kmail.com");
		ul.enterTextField(addressTextfield, "123 pear st");
		ul.enterTextField(cityTextfield, "Fairfax");
		ul.enterTextField(stateTextfield, "Virginia");
		ul.enterTextField(postalTextfield, "22003");
		ul.enterTextField(usernameTextfield, "zeke123");
		ul.enterTextField(passwordTextfield, "zzzzzz");
		ul.enterTextField(confirmPasswordTextfield, "zzzzzz");
		ul.clickElement(submitButton);
	
		return this;
	}
	
	public MercuryRegisterPage clickFlightLink()
	{
		ul.clickElement(flightLink);
		return this;
	}
}
