/**
 * 
 */
package com.pageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.BaseClass.BaseClass;

/**
 * @author nagaraj.k
 *
 */
public class DressesPage extends BaseClass {
	
	public DressesPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//ul[@class=\"product_list grid row\"]/descendant::div[@class=\"right-block\"]/h5/a")
	List<WebElement> dressesList;
	
	
	public List<WebElement> dessesList()
	{
		return dressesList;
	}

}
