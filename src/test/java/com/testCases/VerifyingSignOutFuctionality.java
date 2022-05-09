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
 * @author nagaraj.k
 *
 */
public class VerifyingSignOutFuctionality extends BaseClass {
	
	IndexPage indexPage;
	LoginPage loginPage;
	HomePage homePage;
	
	
	@Test(dataProvider = "credentials", dataProviderClass = DataProviderClass.class)
	public void verifyingsignOutFuctionality(String username, String paswd)
	{
		indexPage=new IndexPage();
		loginPage=indexPage.signinBtnInIndexPage();
		
		loginPage.loginEmailID(username);
		loginPage.loginPasswordId(paswd);
		
		homePage=loginPage.loginBtnInLoginPage();
		
		Assert.assertTrue(driver.getTitle().equalsIgnoreCase("My account - My Store"));
		
		homePage.signOutBtnOptn();
		
		Assert.assertTrue(driver.getTitle().equalsIgnoreCase("Login - My Store"));
		
	}

}
