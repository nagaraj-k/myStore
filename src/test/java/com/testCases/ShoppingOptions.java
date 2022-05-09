/**
 * 
 */
package com.testCases;

import java.util.ListIterator;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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
public class ShoppingOptions extends BaseClass {
	
	IndexPage indexPage;
	LoginPage loginPage;
	HomePage homePage;
	
	@Test(dataProvider = "credentials", dataProviderClass=DataProviderClass.class)
	public void selectShoppingOption(String email, String pswd) throws InterruptedException
	{
		indexPage=new IndexPage();
		loginPage=indexPage.signinBtnInIndexPage();
		loginPage.loginEmailID("abcxyz@xyz.com");
		loginPage.loginPasswordId("abcde");
		homePage=loginPage.loginBtnInLoginPage();
		
		Actions action = new Actions(driver);;
		ListIterator<WebElement>shoppingOptn=homePage.shoppingOptions().listIterator();
		
		while(shoppingOptn.hasNext())
		{
			WebElement shopingSection=shoppingOptn.next();
			if(shopingSection.getText().equalsIgnoreCase("dresses"))
			{
				action.moveToElement(shopingSection).build().perform();
				break;
			}
		}
		
		ListIterator<WebElement> dressOptns= homePage.dressesOptions().listIterator();
		String categoryNameExpected="Casual Dresses";
		while(dressOptns.hasNext())
		{
			WebElement dressType=dressOptns.next();
			if(dressType.getText().strip().equalsIgnoreCase(categoryNameExpected))
			{
				action.moveToElement(dressType).build().perform();
				action.click(dressType).build().perform();
				break;
			}
		}
		
		Assert.assertTrue(homePage.categoryName().getText().strip().equalsIgnoreCase(categoryNameExpected));
	}

}
