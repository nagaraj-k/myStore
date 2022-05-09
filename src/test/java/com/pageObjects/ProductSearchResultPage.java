/**
 * 
 */
package com.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.BaseClass.BaseClass;

import actionDriver.ActionDriverClass;

/**
 * @author Nagaraj K
 *
 */
public class ProductSearchResultPage extends BaseClass {
	
	Actions action=new Actions(driver);
	ActionDriverClass actionDriverClass = new ActionDriverClass();
	public ProductSearchResultPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	/*
	 * 
	 * 
	 */
	
	@FindBy(xpath="//*[@id=\"center_column\"]/descendant::img")
	WebElement productSearchResult;
	
	
	@FindBy(xpath="//p[@class=\"alert alert-warning\"]")
	WebElement productsIsNotFoundMsg;
	
	@FindBy(id="selectProductSort")
	WebElement sortingProductSearch;
	
	
	/*
	 * 
	 * 
	 * 
	 */
	
	public boolean productSearchResultMsg()
	{
		actionDriverClass.fluentWait(driver, productSearchResult);
		return actionDriverClass.isDisplayed(productSearchResult);
	}
	
	public boolean productIsNotFoundMsg()
	{
		actionDriverClass.fluentWait(driver, productsIsNotFoundMsg);
		return actionDriverClass.isDisplayed(productsIsNotFoundMsg);
	}
	
	public ProductDetailsPage clickOnProduct()
	{
		action.moveToElement(productSearchResult).build().perform();
		actionDriverClass.fluentWait(driver, productSearchResult);
		actionDriverClass.click(productSearchResult);
		return new ProductDetailsPage();
	}
	
	public WebElement sortingProductSearch()
	{
		return sortingProductSearch;
	}

}
