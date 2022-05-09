/**
 * 
 */
package com.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.BaseClass.BaseClass;
import com.pageObjects.HomePage;
import com.pageObjects.IndexPage;
import com.pageObjects.LoginPage;
import com.utitlities.DataProviderClass;

/**
 * @author Nagaraj K
 *
 */
public class VerifyLoginFunctionality extends BaseClass{
	
	IndexPage indexPage;
	LoginPage loginPage;
	HomePage homePage;
	
	
	@Test(dataProvider="credentials", dataProviderClass = DataProviderClass.class)
	public void verifyingLoginFunctionality(String emailId, String password)
	{
		indexPage=new IndexPage();
		loginPage=indexPage.signinBtnInIndexPage();
		Assert.assertEquals("Login - My Store", driver.getTitle());
		
		loginPage =new LoginPage();
		
		loginPage.loginEmailID(emailId);
		
		loginPage.loginPasswordId(password);
		
		homePage=loginPage.loginBtnInLoginPage();
		
		Assert.assertTrue(homePage.isMyAccountSubTitleDisplayed());
	}

}
