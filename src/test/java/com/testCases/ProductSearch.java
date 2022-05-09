/**
 * 
 */
package com.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.BaseClass.BaseClass;
import com.pageObjects.IndexPage;
import com.pageObjects.ProductSearchResultPage;
import com.utitlities.DataProviderClass;

/**
 * @author Nagaraj K
 *
 */
public class ProductSearch extends BaseClass {
	
	IndexPage indexPage;
	ProductSearchResultPage productSearchResultPage;
	
	@Test(dataProvider="productToSearch", dataProviderClass = DataProviderClass.class)
	public void searchingProduct(String productName, String productExist)
	{
		indexPage=new IndexPage();
		
		indexPage.searchBoxInIndexPage(productName);
		productSearchResultPage=indexPage.searchButtonInIndexPage();
		
		if(Boolean.valueOf(productExist))
			Assert.assertTrue(productSearchResultPage.productSearchResultMsg());
		else
			Assert.assertTrue(productSearchResultPage.productIsNotFoundMsg());
			
		
	}

}
