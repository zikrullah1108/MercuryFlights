package com.mercury.tests;

import org.junit.Ignore;
import org.junit.Test;

import com.mercury.pages.ConfirmationPage;
import com.mercury.pages.GoogleHomePage;
import com.mercury.pages.GoogleSearchPage;
import com.mercury.pages.MercuryFlightPage;
import com.mercury.pages.MercuryHomePage;
import com.mercury.pages.MercuryRegisterPage;
import com.mercury.pages.PaymentPage;
import com.mercury.pages.SelectFlightPage;
import com.mercury.utilityLibrary.BasePage;

public class RegressionTests extends BasePage{
	
	GoogleHomePage hpGoogle = new GoogleHomePage();
	GoogleSearchPage srGoogle = new GoogleSearchPage();
	MercuryHomePage hpMercury = new MercuryHomePage();
	MercuryRegisterPage rpMercury = new MercuryRegisterPage();
	MercuryFlightPage fpMercury = new MercuryFlightPage();
	SelectFlightPage sfpMercury = new SelectFlightPage();
	PaymentPage ppMercury = new PaymentPage();
	ConfirmationPage cnpMercury = new ConfirmationPage();
	
	
	@Ignore
	@Test
	public void googleTests()
	{
		hpGoogle.goto_googleHomePage();
		srGoogle.search_MecuryTours();
	}
	
	@Ignore
	@Test
	public void mercuryTest1()
	{
		hpGoogle.goto_googleHomePage();
		srGoogle.search_MecuryTours();
		hpMercury.VerifyMercuryHomePageTitle_clickRegister();
		rpMercury.verifyMercuryRegisterPageTitle();
		rpMercury.fillOutRegisInfo();
		rpMercury.clickFlightLink();
	}
	
	@Ignore
	@Test
	public void mercuryTest2()
	{
		hpGoogle.goto_googleHomePage();
		srGoogle.search_MecuryTours();
		hpMercury.VerifyMercuryHomePageTitle_clickRegister();
		rpMercury.verifyMercuryRegisterPageTitle();
		rpMercury.fillOutRegisInfo();
		rpMercury.clickFlightLink();
		fpMercury.verifyMercuryFlightPage();
		fpMercury.fillOutFlightInfo();
	}
	
	@Ignore
	@Test
	public void mercuryTest3()
	{
		hpGoogle.goto_googleHomePage();
		srGoogle.search_MecuryTours();
		hpMercury.VerifyMercuryHomePageTitle_clickRegister();
		rpMercury.verifyMercuryRegisterPageTitle();
		rpMercury.fillOutRegisInfo();
		rpMercury.clickFlightLink();
		fpMercury.verifyMercuryFlightPage();
		fpMercury.fillOutFlightInfo();
		sfpMercury.ticket_Depart_And_Return();
	}
	@Ignore
	@Test
	public void mercuryTest4()
	{
		hpGoogle.goto_googleHomePage();
		srGoogle.search_MecuryTours();
		hpMercury.VerifyMercuryHomePageTitle_clickRegister();
		rpMercury.verifyMercuryRegisterPageTitle();
		rpMercury.fillOutRegisInfo();
		rpMercury.clickFlightLink();
		fpMercury.verifyMercuryFlightPage();
		fpMercury.fillOutFlightInfo();
		sfpMercury.ticket_Depart_And_Return();
		ppMercury.fillOutPaymentInfo();
	}
	
	@Test
	public void mercuryTest5()
	{
		hpGoogle.goto_googleHomePage();
		srGoogle.search_MecuryTours();
		hpMercury.VerifyMercuryHomePageTitle_clickRegister();
		rpMercury.verifyMercuryRegisterPageTitle();
		rpMercury.fillOutRegisInfo();
		rpMercury.clickFlightLink();
		fpMercury.verifyMercuryFlightPage();
		fpMercury.fillOutFlightInfo();
		sfpMercury.ticket_Depart_And_Return();
		ppMercury.fillOutPaymentInfo();
		cnpMercury.confirmNum();
	}
	
}
