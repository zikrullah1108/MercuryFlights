package com.mercury.pages;

import org.openqa.selenium.By;

import com.mercury.utilityLibrary.BasePage;

public class ConfirmationPage extends BasePage {
	
	private By confirmationNumber = By.className("frame_header_info");
	private String cpTitle = "Flight Confirmation: Mercury Tours";
	
	public ConfirmationPage confirmNum()
	{
		ul.fluentWait(confirmationNumber);
		ul.verifyTitle(cpTitle);
		ul.printText(confirmationNumber, "The confirmation number is: ");
		return this;
	}
}
