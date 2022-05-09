package com.BaseClass;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.propertyReader.PropertyReaderClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
 Logger log=LogManager.getLogger(BaseClass.class.getName());
	
	public static WebDriver driver;
	static PropertyReaderClass prc = new PropertyReaderClass();
	static String baseURL=prc.getBaseURL();
	static String browser=prc.getBrowser();
	
	@BeforeTest
	public void initializeLog()
	{
		log.debug("The test is started");
	}
	
	@Parameters("browser")
	@BeforeMethod
	public void setUp(String browser)
	{
		
		if(browser.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			log.debug("driver is initialised");
		}
		if(browser.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			log.debug("driver is initialised");
		}
		if(browser.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			log.debug("driver is initialised");
		}
		
		driver.get(baseURL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
	}
	
		
	@AfterMethod
	public void tearDown()
	{
		log.debug("Its is done");
		driver.quit();
	}

}
