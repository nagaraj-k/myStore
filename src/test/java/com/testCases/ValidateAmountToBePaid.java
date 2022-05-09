/**
 * 
 */
package com.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.BaseClass.BaseClass;
import com.pageObjects.IndexPage;
import com.pageObjects.OrderPage;
import com.pageObjects.ProductDetailsPage;
import com.pageObjects.ProductSearchResultPage;
import com.utitlities.DataProviderClass;

/**
 * @author Nagaraj K
 *
 */
public class ValidateAmountToBePaid extends BaseClass {
	
	IndexPage indexPage;
	ProductSearchResultPage productSearchResultPage;
	ProductDetailsPage productDetailsPage;
	OrderPage orderPage;
	
	@Test(dataProvider = "productToSearch", dataProviderClass = DataProviderClass.class)
	public void verifyingQuantityAndAmount(String product, String productExist)
	{
		indexPage=new IndexPage();
		indexPage.searchBoxInIndexPage(product);
		productSearchResultPage=indexPage.searchButtonInIndexPage();
		productDetailsPage=productSearchResultPage.clickOnProduct();
		productDetailsPage.clickAddToCartBtn();
		orderPage=productDetailsPage.proceedToCheckOutBtn();
		
		int productQuantity=orderPage.findingProductQuantity("value");
		double productUnitPrice=orderPage.findingUnitPrice();
		double productTotalPrice=orderPage.findingTotalPrice();
				
		Assert.assertEquals(productTotalPrice, (productQuantity*productUnitPrice));
		
	}
	

}
