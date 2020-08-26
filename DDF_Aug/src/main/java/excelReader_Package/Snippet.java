package excelReader_Package;

import org.testng.annotations.Test;

public class Snippet {
	@Test
	public void redingExcelData(){
	    Xls_Reader xl=new Xls_Reader("C:\\Manoj_Data\\Excel_Test_Data\\Excel_Data.xlsx");
		
		int RowCount=xl.getRowCount("Sheet1");
		System.out.println(RowCount);
		
		int ColCount=xl.getColumnCount("Sheet1");
		System.out.println(ColCount);
		
		String CellData = xl.getCellData("Sheet1", "UserName", 4);
		System.out.println(CellData);
		
		String data=xl.getCellData("Sheet1", 3 , 4);
		System.out.println(data);
		
		//xl.setCellData("Sheet1", "UserName", 25, "Selenium");
	}
}

