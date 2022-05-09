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
public class VerifyHomePage extends BaseClass {
	IndexPage indexPage;
	LoginPage loginPage;
	HomePage homePage;
	
	@Test(dataProvider = "credentials", dataProviderClass = DataProviderClass.class)
	public void loginMethod(String emialId, String password)
	{
		indexPage=new IndexPage();
		loginPage=indexPage.signinBtnInIndexPage();
		
		loginPage.loginEmailID(emialId);
		loginPage.loginPasswordId(password);
		
		homePage=loginPage.loginBtnInLoginPage();
	}
	
	@Test(groups="failing",dependsOnMethods = "loginMethod" ,dataProvider = "credentials", dataProviderClass = DataProviderClass.class)
	public void verifyingOrderHistoryBtnPresence(String emialId, String password)
	{
		
		  indexPage=new IndexPage(); loginPage=indexPage.signinBtnInIndexPage();
		  
		  loginPage.loginEmailID(emialId); loginPage.loginPasswordId(password);
		  
		  homePage=loginPage.loginBtnInLoginPage();
		 
		/*
		 * String methodName=new Object(){}.getClass().getEnclosingMethod().getName();
		 * System.out.println("Thread from "+methodName+" "+Thread.currentThread().getId
		 * () );
		 */
//		homePage=new HomePage();
		Assert.assertTrue(homePage.isorderHistoryAndDetailsBtnDisplayed());
		Assert.assertFalse(true);
	}
	
	@Test(ignoreMissingDependencies=true,dependsOnGroups = {"failing"},dataProvider = "credentials", dataProviderClass = DataProviderClass.class)
	public void verifyingWishListBtnPresence(String emailId, String password)
	{
		
		  indexPage=new IndexPage(); loginPage=indexPage.signinBtnInIndexPage();
		  loginPage.loginEmailID(emailId); loginPage.loginPasswordId(password);
		  
		  homePage=loginPage.loginBtnInLoginPage();
		 
		
		/*
		 * String methodName=new Object(){}.getClass().getEnclosingMethod().getName();
		 * System.out.println("Thread from "+methodName+" "+Thread.currentThread().getId
		 * () );
		 */
//		homePage=new HomePage();
		Assert.assertTrue(homePage.ismyWishListBtnDisplayed());
	}

}
