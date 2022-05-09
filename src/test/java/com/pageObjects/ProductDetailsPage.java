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
public class ProductDetailsPage extends BaseClass {
	
	Actions action=new Actions(driver);
	
	ProductSearchResultPage productSearchResultPage;
	ActionDriverClass actionDriverClass=new ActionDriverClass();
	
	public ProductDetailsPage() {
		PageFactory.initElements(driver, this);
	}
	
	/*
	 * 
	 * 
	 */
	
	@FindBy(id="add_to_cart")
	WebElement addToCartBtn;
	
	@FindBy(xpath="//i[@class=\"icon-ok\"]")
	WebElement validatingAdditionCart;
	
	@FindBy(xpath="//span[contains(text(),'Proceed to checkout')]")
	WebElement proceedToCheckOutBtn;
	
	@FindBy(xpath="//select[@id=\"group_1\"]")
	WebElement sizeDropDownList;
	
	/*
	 * 
	 * 
	 */
	
	public void clickAddToCartBtn()
	{
		actionDriverClass.fluentWait(driver, addToCartBtn);
		actionDriverClass.click(addToCartBtn);
	}
	
	public boolean validatingAdditionToCart()
	{
		actionDriverClass.fluentWait(driver, validatingAdditionCart);
		return actionDriverClass.isDisplayed(validatingAdditionCart);
	}
	
	public OrderPage proceedToCheckOutBtn()
	{
		
		actionDriverClass.fluentWait(driver, proceedToCheckOutBtn);
		action.moveToElement(proceedToCheckOutBtn).build().perform();
		actionDriverClass.click(proceedToCheckOutBtn);
		return new OrderPage();
	}
	
	public void selectSizeFromDropDownList(String sizeValue)
	{
		actionDriverClass.selectFromDropDown(sizeDropDownList, sizeValue);
	}
	

}
