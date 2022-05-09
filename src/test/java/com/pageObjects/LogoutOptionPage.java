/**
 * 
 */
package com.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.BaseClass.BaseClass;

/**
 * @author nagaraj.k
 *
 */
public class LogoutOptionPage extends BaseClass {
	
	public LogoutOptionPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="div[class=\"header_user_info\"]>a[class=\"logout\"]")
	WebElement sigOutBtn;
	
	public WebElement signOutBtnOptn()
	{
		return sigOutBtn;
	}

}
