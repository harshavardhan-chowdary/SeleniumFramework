package com.test.automation.uiAutomations.excelreader;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel_Reader {
	
	public FileOutputStream fileOut = null;
	public String path;
	public FileInputStream fis;
	public XSSFWorkbook wb;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell;
	
	
	public Excel_Reader(String path)
	{
		this.path=path;
		try{
			
		 fis=new FileInputStream(path);
			 wb=new XSSFWorkbook(fis);
			
			
		}
		catch(Exception e){
			e.printStackTrace();
			
			
		}}
		
		@SuppressWarnings({ "deprecation" })
		public String[][] getDataFromSheet(String sheetName, String ExcelName) {
			String dataSets[][] = null;
				try {
					
					XSSFSheet sheet = wb.getSheet(sheetName); // get sheet from excel workbook
					int totalRow = sheet.getLastRowNum() + 1; // count number of active rows
					int totalColumn = sheet.getRow(0).getLastCellNum(); // count number of active columns in row
					dataSets = new String[totalRow - 1][totalColumn]; // Create array of rows and column
					// Run for loop and store data in 2D array
					// This for loop will run on rows
					for (int i = 1; i < totalRow; i++) {
						XSSFRow rows = sheet.getRow(i);
						// This for loop will run on columns of that row
						for (int j = 0; j < totalColumn; j++) {
							// get Cell method will get cell
							XSSFCell cell = rows.getCell(j);
						
							// If cell of type String , then this if condition will work
							if (cell.getCellType() == Cell.CELL_TYPE_STRING)
								dataSets[i - 1][j] = cell.getStringCellValue();
							// If cell of type Number , then this if condition will work
							else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
								String cellText = String.valueOf(cell.getNumericCellValue());
								dataSets[i - 1][j] = cellText;
							} else
								// If cell of type boolean , then this if condition will work
								dataSets[i - 1][j] = String.valueOf(cell.getBooleanCellValue());
						}

					}
					return dataSets;
				} catch (Exception e) {
					System.out.println("Exception in reading Xlxs file" + e.getMessage());
					e.printStackTrace();
				}
				return dataSets;
			}
		
		
		
		
	}
	
	


