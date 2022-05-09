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

/** This class identifies web elements of index page and  
 * writes action method for each web element
 * 
 * @author Nagaraj K
 */
public class IndexPage extends BaseClass{
	
	
	ActionDriverClass actionDriverClass=new ActionDriverClass();
	
	public IndexPage() {
		
		PageFactory.initElements(driver, this);
	}
	/*
	 * 
	 * 
	 * Following are web elements of the index page 
	 * 
	 * 
	 * 
	 */
	@FindBy(xpath="//img[@class='logo img-responsive']")
	WebElement webSiteLogo;
	
	@FindBy(id="search_query_top")
	WebElement searchBoxInIndexPage;
	
	@FindBy(name="submit_search")
	WebElement searchButtonInIndexPage;
	
	@FindBy(xpath="//a[@class=\"login\"]")
	WebElement signInBtnInIndexPage;
	
	@FindBy(css="ul#home-page-tabs>li")
	List<WebElement> popularBestSellersTabs;
	
	@FindBy(css="ul#homefeatured>li")
	List<WebElement> popularProducts;
	
	@FindBy(css="ul#blockbestsellers>li")
	List<WebElement> bestsellerProducts;
	
	@FindBy(css="ul#homefeatured>li>div>div.right-block>h5>a")
	List<WebElement> popularProductsNames;
	
	@FindBy(css="ul#blockbestsellers>li>div>div.right-block>h5>a")
	List<WebElement> bestSellersNames;
	
	@FindBy(css="ul#blockbestsellers>li>div>div>div>div>a")
	List<WebElement> popularProductQuickView;
	
	@FindBy(css="ul#homefeatured>li>div>div>div>div.quick-view-wrapper-mobile>a")
	List<WebElement> bestsellerProductQuickView;
	
	@FindBy(id="newsletter-input")
	WebElement EmailForNewsletter;
	
	@FindBy(name="submitNewsletter")
	WebElement submitNewsletterBtn;
	
	/*
	 * 
	 * 
	 * 
	 * Following are the action methods for the index page's web elements
	 * 
	 * 
	 */
	public boolean webSiteLogo()
	{
		boolean resultLogo=actionDriverClass.isDisplayed(webSiteLogo);
		return resultLogo;
	}
	
	public void searchBoxInIndexPage(String productName)
	{
		actionDriverClass.typeText(searchBoxInIndexPage,productName);
		
	}
	
	public ProductSearchResultPage searchButtonInIndexPage()
	{
		actionDriverClass.click(searchButtonInIndexPage);
		return new ProductSearchResultPage();
	}
	
	
	public LoginPage signinBtnInIndexPage()
	{
		actionDriverClass.click(signInBtnInIndexPage);
		return new LoginPage();
	}
	
	public List<WebElement> popularBestSellersTabs()
	{
		return popularBestSellersTabs;
	}
	
	public List<WebElement> popularProducts()
	{
		return popularProducts;
	}
	
	public List<WebElement> bestsellerProducts()
	{
		return bestsellerProducts;
	}
	
	public List<WebElement> bestSellersNames()
	{
		return bestSellersNames;
	}
	
	public List<WebElement> bestsellerProductQuickView()
	{
		return bestsellerProductQuickView;
	}
	
	public List<WebElement> popularProductQuickView()
	{
		return popularProductQuickView;
	}
	
	public List<WebElement> popularProductsNames()
	{
		
		return popularProductsNames;
	}
	

}
