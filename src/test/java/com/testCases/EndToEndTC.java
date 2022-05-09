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
import com.pageObjects.IndexPage;
import com.pageObjects.LoginPage;
import com.pageObjects.OrderPage;
import com.pageObjects.ProductDetailsPage;
import com.pageObjects.ProductSearchResultPage;
import com.utitlities.DataProviderClass;

/**
 * @author Nagaraj K
 *
 */
public class EndToEndTC extends BaseClass {
	
	IndexPage indexPage;
	LoginPage loginPage;
	ProductSearchResultPage productSearchResultPage;
	ProductDetailsPage detailsPage;
	OrderPage orderPage;
	Actions action;
	
	@Test(dataProvider = "EndToEnd", dataProviderClass = DataProviderClass.class)
	public void verifyingEndToEndScenario(String emailId, String password, String productToSearch, String productSize) throws InterruptedException
	{
		action = new Actions(driver);
			
		indexPage=new IndexPage();
		loginPage=indexPage.signinBtnInIndexPage();
		
		loginPage.loginEmailID(emailId);
		loginPage.loginPasswordId(password);
		loginPage.loginBtnInLoginPage();
		indexPage.searchBoxInIndexPage(productToSearch);
		productSearchResultPage=indexPage.searchButtonInIndexPage();
		detailsPage=productSearchResultPage.clickOnProduct();
		detailsPage.selectSizeFromDropDownList(productSize);
		detailsPage.clickAddToCartBtn();
		orderPage=detailsPage.proceedToCheckOutBtn();
		double totalPriceOfAllCartProductsWithoutShippingCharge = orderPage.findingTotalPriceOfCartProductsWithoutShippingCharge();
		double ShippingCharge =  orderPage.findingShippingCharge();
		
		/*This component should not be added in total amount to be paid: 
		 * 
		 * double totalPriceOfAllCartProductsWithoutTax =  orderPage.findingTotalPriceOfCartProductsWithoutTax();
		 * 
		 */
		double totalTaxOnCartProducts =  orderPage.findingTotalTaxOnCartProducts();
		double grandTotal =  orderPage.findingGrandTotal();
		
		double sumOfPriceUnits=(totalPriceOfAllCartProductsWithoutShippingCharge+ShippingCharge
				+totalTaxOnCartProducts);
		
		Assert.assertEquals(grandTotal, sumOfPriceUnits);
		
		orderPage.proceedToCheckOutBtn();
		orderPage.proceedToCheckOutBtn();
		orderPage.termsOfService();
		orderPage.proceedToCheckOutBtn();
		
		ListIterator<WebElement> paymentsType=orderPage.paymentOptions().listIterator();
		while(paymentsType.hasNext()) {
			WebElement payment=paymentsType.next();
			if(payment.getText().strip().contains("check"))
			{
				action.moveToElement(payment).build().perform();
				payment.click();
			}
		}
		
		orderPage.confirmOrder();
		
		Assert.assertTrue(driver.getTitle().strip().equalsIgnoreCase("Order confirmation - My Store"));
		
		Thread.sleep(5000);
	}
	
}
