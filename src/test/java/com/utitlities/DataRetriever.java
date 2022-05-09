package com.utitlities;

public class DataRetriever {
	
	public static String[][] extractDataFromExcelSheet(String filePath, String sheetName)
	{
		ExcelDataReader edr=new ExcelDataReader(filePath);
		int rowCount=edr.getRowCountFromTheSheet(sheetName);
		int cellCount=edr.getCellCountOfTheRowInASheet(sheetName, 0);
		String data[][]=new String[rowCount][cellCount];
		
		for(int row=1;row<=rowCount;row++)
		{
			for(int col=0;col<cellCount;col++)
			{
				data[row-1][col]=edr.getCellData(sheetName, row, col);
			}
		}
		return data;
	}

}
