package com.training.dataproviders;

import java.io.IOException;
import java.util.List;

import org.testng.annotations.DataProvider;

import com.training.bean.LoginBean;
import com.training.dao.ELearningDAO;
import com.training.readexcel.ApachePOIExcelRead;
import com.training.readexcel.POIExcelManju;
import com.training.readexcel.ReadExcel;

public class LoginDataProviders {

	@DataProvider(name = "db-inputs")
	public Object [][] getDBData() {

		List<LoginBean> list = new ELearningDAO().getLogins(); 
		
		Object[][] result = new Object[list.size()][]; 
		int count = 0; 
		for(LoginBean temp : list){
			Object[]  obj = new Object[2]; 
			obj[0] = temp.getUserName(); 
			obj[1] = temp.getPassword(); 
			
			result[count ++] = obj; 
		}
		
		
		return result;
	}
	
	@DataProvider(name = "excel-inputs67")
	public Object[][] getExcelData67() throws IOException{
		String fileName = "C:\\Users\\ms130k\\Desktop\\Selenium_ITO\\LPB8\\RTTC_067.xlsx";
		//String fileName = "C:\\Users\\ms130k\\Desktop\\Selenium_ITO\\LPB8\\RTTC_068.xlsx";
		//String fileName = "C:\\Users\\ms130k\\Desktop\\Selenium_ITO\\LPB8\\RTTC_069.xlsx";
		return new POIExcelManju().getExcelContent1(fileName);
	}
	
	@DataProvider(name = "excel-inputs68")
	public Object[][] getExcelData68() throws IOException{
		String fileName = "C:\\Users\\ms130k\\Desktop\\Selenium_ITO\\LPB8\\RTTC_068.xlsx";
		//String sheetName = "Sheet1";
		return new POIExcelManju().getExcelContent1(fileName);
	}
	
	@DataProvider(name = "excel-inputs69")
	public Object[][] getExcelData69() throws IOException{
		String fileName = "C:\\Users\\ms130k\\Desktop\\Selenium_ITO\\LPB8\\RTTC_069.xlsx";
		return new POIExcelManju().getExcelContent1(fileName);
	}
		
		@DataProvider(name = "excel-inputs69APOI")
		public Object[][] getExcelData67APOI() throws IOException{
			//String fileName = "C:\\Users\\ms130k\\Desktop\\Selenium_ITO\\LPB8\\RTTC_069.xlsx";
			String fileName = "C:/Users/ms130k/Desktop/Selenium_ITO/LPB8/RTTC067.xlsx";
			return new ApachePOIExcelRead().getExcelContent(fileName);
	}
		
		@DataProvider(name = "excel-common_fn")
		public Object[][] getExcelDataCFN() throws IOException{
			//String fileName = "C:\\Users\\ms130k\\Desktop\\Selenium_ITO\\LPB8\\RTTC_069.xlsx";
			String fileName = "C:/Users/ms130k/Desktop/Selenium_ITO/LPB8/RTTC067.xlsx";
			return new ApachePOIExcelRead().getExcelContent(fileName);
			
			
	}
		
	@DataProvider(name = "xls-inputs")
	public Object[][] getXLSData(){
		// ensure you will have the title as first line in the file 
		return new ReadExcel().getExcelData("C:/Users/Naveen/Desktop/Testing.xls", "Sheet1"); 
	}
}
