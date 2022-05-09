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

/**
 * @author Nagaraj K
 *
 */
public class AddToCartAndValidate extends BaseClass {
	
	IndexPage indexPage;
	ProductSearchResultPage productSearchResult;
	ProductDetailsPage productDetailsPage;
	OrderPage orderPage;
	
	@Test
	public void validatingAddToCart()
	{
		indexPage=new IndexPage();
		indexPage.searchBoxInIndexPage("t shirt");
		productSearchResult=indexPage.searchButtonInIndexPage();
		boolean result=productSearchResult.productSearchResultMsg();
		if(result)
		{
			productDetailsPage=productSearchResult.clickOnProduct();
			productDetailsPage.selectSizeFromDropDownList("L");
			productDetailsPage.clickAddToCartBtn();
			
			boolean addResult=productDetailsPage.validatingAdditionToCart();
			
			if(addResult)
			{
				orderPage=productDetailsPage.proceedToCheckOutBtn();
				
				Assert.assertTrue(orderPage.validatingOrderSummarySubTitle());
			}
		}
		
	}

}
