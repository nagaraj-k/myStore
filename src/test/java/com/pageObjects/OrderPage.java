/**
 * 
 */
package com.pageObjects;

import java.util.List;

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
public class OrderPage extends BaseClass {

	ActionDriverClass actionDriverClass=new ActionDriverClass();
	Actions action =new Actions(driver);
	
	public OrderPage() {
		PageFactory.initElements(driver, this);
	}

	/*
	 * 
	 * 
	 */

	@FindBy(xpath="//h1[contains(text(),'Shopping-cart summary')]")
	WebElement orderSummarySubTitle;


	@FindBy(xpath="//input[@type=\"text\" and contains(@class,\"cart_quantity_input form-control grey\")]")
	WebElement productQuantity;

	@FindBy(xpath="//td[@class=\"cart_unit\"]/descendant::span[contains(text(),'$')]")
	WebElement productUnitPrice;

	@FindBy(xpath="//td[@class=\"cart_total\"]/descendant::span[contains(text(),'$')]")
	WebElement productTotalPrice;


	@FindBy(id="total_product")
	WebElement totalPriceOfCartProductsWithoutShippingCharge;

	@FindBy(id="total_shipping")
	WebElement shippingCharge;

	@FindBy(id="total_price_without_tax")
	WebElement totalPriceOfCartProductsWithoutTax;

	@FindBy(id="total_tax")
	WebElement totalTaxOnCartProducts;

	@FindBy(id="total_price_container")
	WebElement grandTotal;
	
	@FindBy(xpath="(//span[contains(text(),'Proceed to checkout')])[2]")
	WebElement proceedToCheckOutBtn;
	
	
	@FindBy(css="p[class=\"payment_module\"]")
	List<WebElement> paymentOptions;

	@FindBy(css="button[class=\"button btn btn-default button-medium\"]")
	WebElement confirmOrder;

	@FindBy(id="uniform-cgv")
	WebElement termsOfService;

	/*
	 * 
	 * 
	 * 
	 */

	public boolean validatingOrderSummarySubTitle()
	{
		
		actionDriverClass.fluentWait(driver, orderSummarySubTitle);
		action.moveToElement(orderSummarySubTitle).build().perform();
		return actionDriverClass.isDisplayed(orderSummarySubTitle);
	}

	public int findingProductQuantity(String value)
	{
		
		actionDriverClass.fluentWait(driver, productQuantity);
		action.moveToElement(productQuantity).build().perform();
		return actionDriverClass.getIntValueOfElement(productQuantity, value);
	}

	public double findingUnitPrice() {
		action.moveToElement(productUnitPrice).build().perform();
		return actionDriverClass.getDoubleValueOfElementFromText(productUnitPrice);
	}

	public double findingTotalPrice() {
		
		action.moveToElement(productTotalPrice).build().perform();
		return actionDriverClass.getDoubleValueOfElementFromText(productTotalPrice);
	}

	public double findingTotalPriceOfCartProductsWithoutShippingCharge()
	{
		action.moveToElement(totalPriceOfCartProductsWithoutShippingCharge).build().perform();
		return actionDriverClass.getDoubleValueOfElementFromText(totalPriceOfCartProductsWithoutShippingCharge);
	}

	public double findingShippingCharge()
	{
		action.moveToElement(shippingCharge).build().perform();
		return actionDriverClass.getDoubleValueOfElementFromText(shippingCharge);
	}

	public double findingTotalPriceOfCartProductsWithoutTax()
	{
		action.moveToElement(totalPriceOfCartProductsWithoutTax).build().perform();
		return actionDriverClass.getDoubleValueOfElementFromText(totalPriceOfCartProductsWithoutTax);
	}

	public double findingTotalTaxOnCartProducts()
	{
		action.moveToElement(totalTaxOnCartProducts).build().perform();
		return actionDriverClass.getDoubleValueOfElementFromText(totalTaxOnCartProducts);
	}

	public double findingGrandTotal()
	{
		action.moveToElement(grandTotal).build().perform();
		return	actionDriverClass.getDoubleValueOfElementFromText(grandTotal);
	}
	
	public List<WebElement> paymentOptions()
	{
		
		return paymentOptions;
	}
	
	public OrderConfirmationPage confirmOrder()
	{
//		action.moveToElement(confirmOrder).build().perform();
		actionDriverClass.click(confirmOrder);
		return new OrderConfirmationPage();
	}
	
	public void proceedToCheckOutBtn()
	{
		action.moveToElement(proceedToCheckOutBtn).build().perform();
		actionDriverClass.fluentWait(driver, proceedToCheckOutBtn);
		actionDriverClass.click(proceedToCheckOutBtn);
	}
	
	public void termsOfService()
	{
		action.moveToElement(termsOfService).build().perform();
		actionDriverClass.fluentWait(driver, termsOfService);
		actionDriverClass.click(termsOfService);
	}
}
