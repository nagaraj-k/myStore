
package com.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.BaseClass.BaseClass;
import com.pageObjects.IndexPage;
import com.utitlities.DataProviderClass;


/**
 * @author Nagaraj K
 *
 */
public class VerifyWebSiteLogoAndTitle extends BaseClass {
	
	IndexPage indexPage;
	
	@Test(dataProvider = "dataMethod", dataProviderClass = DataProviderClass.class,priority=0)
	public void verifyingWebSiteLogo(String product)
	{
		indexPage =new IndexPage();
		Assert.assertTrue(indexPage.webSiteLogo());
	}

	@Test(priority=1)
	public void verifyingWebSiteTitle()
	{
		String expectedTitle="My Store";
		Assert.assertEquals(expectedTitle, driver.getTitle());
		
	}
	
}
