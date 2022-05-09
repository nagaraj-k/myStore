package com.propertyReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyReaderClass {
	
	Properties pro;
	public PropertyReaderClass() {
		
		pro=new Properties();
//		File src=new File(System.getProperty("user.dir")+"\\Configurations\\config.properties");
		File src=new File("./Configurations/config.properties");
		try {
			FileInputStream fis=new FileInputStream(src);
			pro.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String getBaseURL()
	{
		return pro.getProperty("baseURL");
	}
	
	public String getBrowser()
	{
		return pro.getProperty("browser");
	}

}
