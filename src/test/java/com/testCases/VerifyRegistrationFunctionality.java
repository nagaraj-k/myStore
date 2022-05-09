/**
 * 
 */
package com.testCases;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.BaseClass.BaseClass;
import com.pageObjects.IndexPage;
import com.pageObjects.LoginPage;
import com.pageObjects.PersonalInfoPage;
import com.utitlities.DataProviderClass;

/**
 * @author Nagaraj K
 *
 */
public class VerifyRegistrationFunctionality extends BaseClass {
	
	IndexPage indexPage;
	LoginPage loginPage;
	PersonalInfoPage personalInfoPage;
	
	
	@Test(dataProvider = "emailForRegistration", dataProviderClass = DataProviderClass.class)
	public void verifyingRegistrationWithoutData(String emailId)
	{
		indexPage=new IndexPage();
		loginPage=indexPage.signinBtnInIndexPage();
		
		loginPage.emailRegistration(emailId);
		
		personalInfoPage = loginPage.accoutnCreateBtnInLoginPage();
		personalInfoPage.submitAccountBtn().click();
		
		Assert.assertTrue(personalInfoPage.dangerAlertMsg().isDisplayed());
	}
	
	@Test(dataProvider = "registrationForMandatoryFields", dataProviderClass = DataProviderClass.class)
	public void verifyingRegistrationWithMandatoryFields(String emailId,
			String firstname, String lastname, String password,
			String addressLine1, String city, String state, String postcode, String country, 
			String mobileNumber, String aliasAddress) 
	{
		
		indexPage=new IndexPage();
		loginPage=indexPage.signinBtnInIndexPage();
		
		loginPage.emailRegistration(emailId);
		
		personalInfoPage = loginPage.accoutnCreateBtnInLoginPage();
					
		personalInfoPage.firstNameTxtBox().sendKeys(firstname);
		
		personalInfoPage.lastNameTxtBox().sendKeys(lastname);
		
		personalInfoPage.password().sendKeys(password);
		
		personalInfoPage.address1Address().sendKeys(addressLine1);
		
		personalInfoPage.cityAddress().sendKeys(city);
		
		Select states =new Select(personalInfoPage.stateAddress());
		states.selectByVisibleText(state);
		
		personalInfoPage.postcodeAddress().sendKeys(postcode);
			
		Select countries =new Select(personalInfoPage.countryAddress());
		countries.selectByVisibleText(country);
		
		personalInfoPage.phone_mobileAddress().sendKeys(mobileNumber);
		
		personalInfoPage.aliasAddress().sendKeys(aliasAddress);
		
		personalInfoPage.submitAccountBtn().click();
		
		Assert.assertEquals(driver.getTitle(), "My account - My Store");
		
	}
	
	@Test(dataProvider = "registrationDetailsForAllField", dataProviderClass = DataProviderClass.class)
	public void verifyingRegistrationWithAllFields(String emailId,
			String gender, String firstname, String lastname, String password,
			String day, String month, String year, String company, String addressLine1, String addressLine2, 
			String city, String state, String postcode, String country, String otherInfo, String homePhone, 
			String mobileNumber, String aliasAddress) 
	{
		
		indexPage=new IndexPage();
		loginPage=indexPage.signinBtnInIndexPage();
		
		loginPage.emailRegistration(emailId);
		
		personalInfoPage = loginPage.accoutnCreateBtnInLoginPage();
		
		if(gender.equalsIgnoreCase("male"))
			personalInfoPage.mrRadioBtn().click();
		else
			personalInfoPage.mrsRadioBtn().click();
		
		personalInfoPage.firstNameTxtBox().sendKeys(firstname);
		
		personalInfoPage.lastNameTxtBox().sendKeys(lastname);
		
		personalInfoPage.password().sendKeys(password);
		
		Select days=new Select(personalInfoPage.daysDob());
		days.selectByVisibleText(day);
		
		Select months=new Select(personalInfoPage.monthsDob());
		months.selectByVisibleText(month);
		
		Select years=new Select(personalInfoPage.yearsDob());
		years.selectByVisibleText(year);
		
		personalInfoPage.newsletterCheckBox().click();
		
		personalInfoPage.offersCheckBox().click();
		
		personalInfoPage.firstnameAddress().sendKeys(firstname);
		
		personalInfoPage.lastnameAddress().sendKeys(lastname);
		
		personalInfoPage.companyAddress().sendKeys(company);
		
		personalInfoPage.address1Address().sendKeys(addressLine1);
		
		personalInfoPage.addressLine2Address().sendKeys(addressLine2);
		
		personalInfoPage.cityAddress().sendKeys(city);
		
		Select states =new Select(personalInfoPage.stateAddress());
		states.selectByVisibleText(state);
		
		personalInfoPage.postcodeAddress().sendKeys(postcode);
		
		Select countries =new Select(personalInfoPage.countryAddress());
		countries.selectByVisibleText(country);
		
		personalInfoPage.otherTextArea().sendKeys(otherInfo);
		
		personalInfoPage.homePhoneAddress().sendKeys(homePhone);
		
		personalInfoPage.phone_mobileAddress().sendKeys(mobileNumber);
		
		personalInfoPage.aliasAddress().sendKeys(aliasAddress);
		
		personalInfoPage.submitAccountBtn().click();
		
		Assert.assertEquals(driver.getTitle(), "My account - My Store");
	}
	

}
