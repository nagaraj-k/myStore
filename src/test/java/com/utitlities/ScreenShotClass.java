/**
 * 
 */
package com.utitlities;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.BaseClass.BaseClass;



/**
 * @author nagaraj.k
 *
 */
public class ScreenShotClass extends BaseClass {
	
	public static String takeScreenShot()
	{
		
		/*
		 * String date=String.valueOf(new Date()); String
		 * formattedDate=date.replace(" ", "_").replace(":", "-"); File
		 * source=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); String
		 * imageName=methodName+formattedDate+".png"; String
		 * destinationPath="./ScreenShots/"+imageName; File destination=new
		 * File(destinationPath); try { FileUtils.copyFile(source, destination); } catch
		 * (IOException e) { // TODO Auto-generated catch block e.printStackTrace(); }
		 * 
		 * return destinationPath;
		 */
		 
		
		return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);
		
		
		
	}

}
