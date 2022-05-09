/**
 * 
 */
package com.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.BaseClass.BaseClass;

import actionDriver.ActionDriverClass;

/**
 * @author Nagaraj K
 *
 */
public class PersonalInfoPage extends BaseClass {
	
	ActionDriverClass actionDriverClass=new ActionDriverClass();
	public PersonalInfoPage() {
		PageFactory.initElements(driver, this);
	}
	
	/*
	 * 
	 * Following are personal info page web elements
	 * 
	 */
	
	@FindBy(id="id_gender1")
	WebElement mrRadioBtn;
	
	@FindBy(id="id_gender2")
	WebElement mrsRadioBtn;
	
	@FindBy(id="customer_firstname")
	WebElement firstNamePersonalInfo;
	
	@FindBy(id="customer_lastname")
	WebElement lastNamePersonalInfo;
	
	@FindBy(id="passwd")
	WebElement password;
	
	@FindBy(id="newsletter")
	WebElement newsletterCheckBox;
	
	@FindBy(id="optin")
	WebElement offersCheckBox;
	
	@FindBy(id="firstname")
	WebElement firstnameAddress;
	
	@FindBy(id="lastname")
	WebElement lastnameAddress;
	
	@FindBy(id="company")
	WebElement companyAddress;
	
	@FindBy(id="address1")
	WebElement address1Address;
	
	@FindBy(id="address2")
	WebElement address2Address;
	
	@FindBy(id="city")
	WebElement cityAddress;
	
	@FindBy(id="id_state")
	WebElement id_stateAddress;
	
	@FindBy(id="other")
	WebElement otherTextArea;
	
	@FindBy(id="phone")
	WebElement homePhoneAddress;
	
	@FindBy(id="phone_mobile")
	WebElement phone_mobileAddress;
	
	@FindBy(id="alias")
	WebElement aliasAddress;
	
	@FindBy(id="submitAccount")
	WebElement submitAccountBtn;
	
	@FindBy(id="days")
	WebElement daysDropDown;
	
	@FindBy(id="months")
	WebElement monthsDropDown;
	
	@FindBy(id="years")
	WebElement yearsDropDown;
	
	@FindBy(id="id_state")
	WebElement id_stateDropDown;
	
	
	@FindBy(id="id_country")
	WebElement id_countryDropDown;
	
	@FindBy(id="postcode")
	WebElement postcodeAddress;
	
	@FindBy(css="div[class='alert alert-danger']>p")
	WebElement dangerAlertMsg;
	
	
	@FindBy(xpath="//*[text()=\"Your personal information\"]")
	WebElement personalInfpoTxtMsg;
	

	
	/*
	 * 
	 * Following are action methods for the personal info page web elements
	 * 
	 */
	
	public WebElement firstNameTxtBox()
	{
		firstNamePersonalInfo.clear();
		return firstNamePersonalInfo;
	}
	
	public WebElement lastNameTxtBox()
	{
		lastNamePersonalInfo.clear();
		return lastNamePersonalInfo;
	}
	
	public WebElement password()
	{
		password.clear();
		return password;
	}
	
	public WebElement mrRadioBtn()
	{
		actionDriverClass.explicitWait(driver, mrRadioBtn);
		return mrRadioBtn;
	}
	
	public WebElement mrsRadioBtn()
	{
		actionDriverClass.explicitWait(driver, mrRadioBtn);
		return mrsRadioBtn;
	}
	
	public WebElement newsletterCheckBox()
	{
		return newsletterCheckBox;
	}
	
	public WebElement offersCheckBox()
	{
		return offersCheckBox;
	}
	
	public WebElement firstnameAddress()
	{
		firstnameAddress.clear();
		return firstnameAddress;
	}
		
	public WebElement lastnameAddress()
	{
		lastnameAddress.clear();
		return lastnameAddress;
	}
	
	public WebElement companyAddress()
	{
		companyAddress.clear();
		return companyAddress;
	}
	
	public WebElement address1Address()
	{
		address1Address.clear();
		return address1Address;
	}
	
	public WebElement addressLine2Address()
	{
		address2Address.clear();
		return address2Address;
	}
	
	public WebElement cityAddress()
	{
		cityAddress.clear();
		return cityAddress;
	}
	
	public WebElement id_stateAddress()
	{
		return id_stateAddress;
	}
	
	public WebElement otherTextArea()
	{
		otherTextArea.clear();
		return otherTextArea;
	}
	
	public WebElement homePhoneAddress()
	{
		homePhoneAddress.clear();
		return homePhoneAddress;
	}
	
	public WebElement phone_mobileAddress()
	{
		phone_mobileAddress.clear();
		return phone_mobileAddress;
	}
	
	public WebElement aliasAddress()
	{
		aliasAddress.clear();
		return aliasAddress;
	}
	
	public WebElement submitAccountBtn()
	{
		return submitAccountBtn;
	}
	
	
	public WebElement daysDob()
	{
		return daysDropDown;
	}
	
	public WebElement monthsDob()
	{
		return monthsDropDown;
	}
	
	public WebElement yearsDob()
	{
		return yearsDropDown;
	}
	
	public WebElement stateAddress()
	{
		return id_stateAddress;
	}
	
	public WebElement countryAddress()
	{
		return id_countryDropDown;
	}
	
	public WebElement postcodeAddress()
	{
		return postcodeAddress;
	}
	
	public WebElement dangerAlertMsg()
	{
		return dangerAlertMsg;
	}
	
	public boolean personalInfpoTxtMsg()
	{
		
		actionDriverClass.explicitWait(driver, personalInfpoTxtMsg);
		return actionDriverClass.isDisplayed(personalInfpoTxtMsg);
	}
	

}
