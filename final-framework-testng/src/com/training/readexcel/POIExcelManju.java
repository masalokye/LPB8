package com.training.readexcel;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class POIExcelManju {
	public  Object [][] getExcelContent1(String fileName) throws IOException {
	//public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
				File sf = new File(fileName);
				//File sf = new File("C:\\Users\\ms130k\\Desktop\\Selenium_ITO\\LPB8\\TestData2Manju.xlsx");
				FileInputStream fis = new FileInputStream(sf);
				XSSFWorkbook wb = new XSSFWorkbook(fis);
				//XSSFSheet sheet = wb.getSheet("RTTC_068");
				XSSFSheet sheet = wb.getSheet("Sheet1");
				int rowCount = sheet.getLastRowNum();
				System.out.println("Row Count  "+rowCount);
				Object[][] data = new Object [4][6];
				for (int i=0; i<4; i++)
				{
					//if (i==0) continue;
					//int colCount = sheet.getRow(i).getLastCellNum();
					//System.out.println("Column Count  "+colCount);
					//System.out.println("Row "+i+" containing "+colCount+" values");
					for(int j=0; j<6; j++)
					{
						//if (j==0) continue;
						CellType cellType = sheet.getRow(i).getCell(j).getCellType();
						//System.out.println("Cell type is " + cellType);
						Cell cell = sheet.getRow(i).getCell(j, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
						if (cell == null) {
							 //cellValue = "";
							data[i][j]="";
							 //cellValue1=cellValue;
						}
						else {
							if (cellType==CellType.NUMERIC) {
								data[i][j] = ((Double) sheet.getRow(i).getCell(j).getNumericCellValue()).toString(); 
								}
							else data[i][j] = sheet.getRow(i).getCell(j).getStringCellValue();
							}

						System.out.println("Value stored at "+i+" th row "+j+" th column is "+data[i][j]); 
							
					}
				}
return data;
			}
	public static void main(String[] args) throws IOException {
		//String fileName = "C:/Users/Naveen/Desktop/Testing.xlsx";
		//String fileName = "C:/Users/ms130k/Desktop/Selenium_ITO/LPB8/TestData2Manju.xlsx";
		//String fileName =  Properties.getProperty("excelfile67");
		//String [][] list3 = new ApachePOIExcelRead().getExcelContent(fileName);
		String fileName = "C:\\Users\\ms130k\\Desktop\\Selenium_ITO\\LPB8\\RTTC_067.xlsx";
		Object[][] data1=new POIExcelManju().getExcelContent1(fileName);
		//System.out.println(data1);
		

	}

		}
