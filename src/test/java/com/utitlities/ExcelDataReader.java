package com.utitlities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataReader {
	
	public static FileInputStream fis;
	
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	public String path;
	
	public ExcelDataReader(String path) {
		this.path=path;
	}
	
	public int getRowCountFromTheSheet(String sheetName)
	{
		try {
			fis=new FileInputStream(path);
			workbook=new XSSFWorkbook(fis);
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		catch (IOException e) {
			
			e.printStackTrace();
		}
		sheet=workbook.getSheet(sheetName);
		int rowCount=sheet.getLastRowNum();
		try {
			workbook.close();
			fis.close();
		} catch (IOException e) {
		
			e.printStackTrace();
		}
		return rowCount;
	}
	
	public int getCellCountOfTheRowInASheet(String sheetName, int rowNum)
	{
		try {
			fis=new FileInputStream(path);
			workbook=new XSSFWorkbook(fis);
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		sheet=workbook.getSheet(sheetName);
		row=sheet.getRow(rowNum);
		int cellCount=row.getLastCellNum();
		try {
			workbook.close();
			fis.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return cellCount;
	}
	
	
	public String getCellData(String sheetName,int rowNum, int colNum)
	{
		try {
			fis=new FileInputStream(path);
			workbook=new XSSFWorkbook(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet=workbook.getSheet(sheetName);
		row=sheet.getRow(rowNum);
		cell=row.getCell(colNum);
		
		DataFormatter formatter=new DataFormatter();
		
		String data;
		try {
			data = formatter.formatCellValue(cell);
		} catch (Exception e) {
			data="";
		}
		
		try {
			workbook.close();
			fis.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return data;
	}
	

}
