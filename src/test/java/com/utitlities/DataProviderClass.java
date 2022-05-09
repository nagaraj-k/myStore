package com.utitlities;

import org.testng.annotations.DataProvider;

public class DataProviderClass {
	private static String DataFilePath=System.getProperty("user.dir")+"\\DataFiles\\DataFile.xlsx";
	
	@DataProvider(name="productToSearch")
	public String[][] productToBeSearched()
	{
		String sheetName="productToSearch";
		String data[][]=DataRetriever.extractDataFromExcelSheet(DataFilePath,sheetName);
		return data;
	}
	
	
	@DataProvider(name="credentials")
	public String[][] loginCredentials()
	{
		String sheetName="credentials";
		String data[][]=DataRetriever.extractDataFromExcelSheet(DataFilePath, sheetName);
		return data;
	}
	
	@DataProvider(name="EndToEnd")
	public String[][] endToEnd()
	{
		String sheetName="EndToEnd";
		String data[][]=DataRetriever.extractDataFromExcelSheet(DataFilePath, sheetName);
		return data;
	}
	
	@DataProvider(name="registrationDetailsForAllField")
	public String[][] registrationWithAllFields()
	{
		String sheetName="registrationDetailsForAllField";
		String data[][]=DataRetriever.extractDataFromExcelSheet(DataFilePath, sheetName);
		return data;
	}

	@DataProvider(name="emailForRegistration")
	public String[][] emailForRegistration()
	{
		String sheetName="emailForRegistration";
		String data[][]=DataRetriever.extractDataFromExcelSheet(DataFilePath, sheetName);
		return data;
	}
	
	@DataProvider(name="registrationForMandatoryFields")
	public String[][] registrationForMandatoryFields()
	{
		String sheetName="registrationForMandatoryFields";
		String data[][]=DataRetriever.extractDataFromExcelSheet(DataFilePath, sheetName);
		return data;
	}
	
}
