/**
 * 
 */
package com.testCases;

import java.util.Iterator;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.BaseClass.BaseClass;
import com.pageObjects.IndexPage;

/**
 * @author nagaraj.k
 *
 */
public class MouseHoveringOnProducts extends BaseClass {
	Actions action;
	IndexPage indexPage;
	@Test
	public void mouseHoveringOnPopularProducts() throws InterruptedException
	{
		indexPage=new IndexPage();
		action = new Actions(driver);
		
		Iterator<WebElement> products=indexPage.popularBestSellersTabs().iterator();
		while(products.hasNext())
		{
			WebElement product=products.next();
			
			if(product.getText().equalsIgnoreCase("Popular"))
			{
				action.moveToElement(product).build().perform();
				product.click();
				break;
			}
		}
		
		Iterator<WebElement> popularProducts=indexPage.popularProducts().iterator();
		
		while(popularProducts.hasNext())
		{
			action.moveToElement(popularProducts.next()).build().perform();
		}
		
	}

	@Test
	public void mouseHoveringOnBestSellersProducts()
	{
		indexPage=new IndexPage();
		action = new Actions(driver);
		
		Iterator<WebElement> products=indexPage.popularBestSellersTabs().iterator();
		while(products.hasNext())
		{
			WebElement product=products.next();
			
			if(product.getText().equalsIgnoreCase("Best Sellers"))
			{
				action.moveToElement(product).build().perform();
				product.click();
				break;
			}
		}
		
		Iterator<WebElement> popularProducts=indexPage.bestsellerProducts().iterator();
		
		while(popularProducts.hasNext())
		{
			action.moveToElement(popularProducts.next()).build().perform();
		}
	}
}
