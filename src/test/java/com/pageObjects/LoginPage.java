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
public class LoginPage extends BaseClass {

	ActionDriverClass actionDriverClass =new ActionDriverClass();

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	/*
	 * 
	 * Following are web elements in login page
	 * 
	 */
	@FindBy(id="email_create")
	WebElement emailRegistration;

	@FindBy(id="SubmitCreate")
	WebElement accoutnCreateBtnInLoginPage;

	@FindBy(id="email")
	WebElement loginEmailId;


	@FindBy(id="passwd")
	WebElement loginPassword;

	@FindBy(id="SubmitLogin")
	WebElement loginBtnInLoginPage;

	/*
	 * 
	 * Following are action methods for the login page web elements
	 * 
	 */

	public void emailRegistration(String emailId)
	{
		actionDriverClass.typeText(emailRegistration, emailId);
	}

	public PersonalInfoPage accoutnCreateBtnInLoginPage() {

		actionDriverClass.explicitWait(driver, accoutnCreateBtnInLoginPage);
		actionDriverClass.click(accoutnCreateBtnInLoginPage);
		return new PersonalInfoPage();
	}


	public void loginEmailID(String emailId)
	{
		actionDriverClass.fluentWait(driver, loginEmailId);
		
		actionDriverClass.typeText(loginEmailId, emailId);
	}

	public void loginPasswordId(String password)
	{
		actionDriverClass.fluentWait(driver, loginPassword);
		
		actionDriverClass.typeText(loginPassword, password);
	}

	public HomePage loginBtnInLoginPage()
	{
		actionDriverClass.fluentWait(driver, loginBtnInLoginPage);
		actionDriverClass.click(loginBtnInLoginPage);
		return new HomePage();
	}



}
