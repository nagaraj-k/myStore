package actionDriver;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.BaseClass.BaseClass;

/**
 * @author Nagaraj K
 *
 */
public class ActionDriverClass extends BaseClass {

	Actions action;
	public void click(WebElement element)
	{
		action=new Actions(driver);
		action.moveToElement(element).click().build().perform();
	}

	public boolean isDisplayed(WebElement ele)
	{
		boolean result=false;

		if(ele.isDisplayed())
		{
			result=true;
		}

		return result;
	}

	public void typeText(WebElement ele, String textToEnter) {

		try {
			Actions action = new Actions(driver);

			if(ele.isEnabled())
			{
				action.moveToElement(ele).build().perform();
				ele.clear();
				ele.sendKeys(textToEnter);
			}
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	public void implicitWait(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	public void explicitWait(WebDriver driver, WebElement ele)
	{
		new WebDriverWait(driver,Duration.ofSeconds(10))
		.until(ExpectedConditions.visibilityOf(ele));
	}

	public void fluentWait(WebDriver driver, WebElement ele)
	{
		new FluentWait<WebDriver>(driver)
		.withTimeout(Duration.ofSeconds(10))
		.pollingEvery(Duration.ofMillis(100))
		.ignoring(Exception.class)
		.until(ExpectedConditions.visibilityOf(ele));
	}
	
	public void selectFromDropDown(WebElement ele, String stringValue)
	{
		action = new Actions(driver);
		action.moveToElement(ele).build().perform();
		Select select = new Select(ele);
		select.selectByVisibleText(stringValue);
		
	}
	
	public int getIntValueOfElement(WebElement ele,String attribute)
	{
		return Integer.valueOf(ele.getAttribute(attribute));
	}
	
	public double getDoubleValueOfElementFromText(WebElement ele)
	{
		return Double.valueOf(ele.getText().substring(1).strip());
	}

}
