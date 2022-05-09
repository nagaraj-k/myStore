/**
 * 
 */
package com.pageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.BaseClass.BaseClass;

import actionDriver.ActionDriverClass;

/**
 * @author Nagaraj K
 *
 */
public class HomePage extends BaseClass {
	
	ActionDriverClass actionDriverClass=new ActionDriverClass();
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	/*
	 * Following are web elements of home page
	 * 
	 */
	
	@FindBy(xpath="//h1[text()=\"My account\"]")
	WebElement myAccountSubTitle;
	
	
	@FindBy(xpath="//span[text()=\"Order history and details\"]")
	WebElement orderHistoryAndDetailsBtn;
	
	@FindBy(xpath="//span[text()=\"My wishlists\"]")
	WebElement myWishListBtn;
	
	
	@FindBy(css="ul[class='sf-menu clearfix menu-content sf-js-enabled sf-arrows']>li>a")
	List<WebElement> shoppingOptions;
	
	@FindBy(css="div[class=\"header_user_info\"]>a[class=\"logout\"]")
	WebElement sigOutBtn;
	
	
	@FindBy(xpath="(//ul[@class=\"submenu-container clearfix first-in-line-xs\"])[2]/li")
	List<WebElement> dressesOptions;
	
	@FindBy(css="div.cat_desc>span")
	WebElement categoryName;

	/*
	 * Following are action methods for web elements of home page
	 * 
	 */
	
	
	public boolean isMyAccountSubTitleDisplayed()
	{
		actionDriverClass.fluentWait(driver, myAccountSubTitle);
		return actionDriverClass.isDisplayed(myAccountSubTitle);
	}
	
	public boolean isorderHistoryAndDetailsBtnDisplayed()
	{
		actionDriverClass.fluentWait(driver, orderHistoryAndDetailsBtn);
		return actionDriverClass.isDisplayed(orderHistoryAndDetailsBtn);
	}
	
	public LoginPage signOutBtnOptn()
	{
		actionDriverClass.click(sigOutBtn);
		return new LoginPage();
	}
	
	
	public boolean ismyWishListBtnDisplayed()
	{
		actionDriverClass.fluentWait(driver, myWishListBtn);
		return actionDriverClass.isDisplayed(myWishListBtn);
	}
	
	public List<WebElement> shoppingOptions()
	{
		return shoppingOptions;
	}
	
	public List<WebElement> dressesOptions()
	{
		return dressesOptions;
	}
	
	public WebElement categoryName()
	{
		return categoryName;
	}
}
