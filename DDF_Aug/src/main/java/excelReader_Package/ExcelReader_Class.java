package excelReader_Package;

import java.util.Hashtable;

import org.testng.annotations.Test;

public class ExcelReader_Class {
	public Xls_Reader xls =null;
	@Test
	public void getExcelData(){

		xls = new Xls_Reader("C://Manoj_Data//Test_Data.xlsx");
		String sheetName ="Sheet1";
		String testCaseName = "TC_02";
		int TestStartRow = 1;
		while(!xls.getCellData(sheetName, 0, TestStartRow).equals(testCaseName)){
			TestStartRow++;
		}
		System.out.println(TestStartRow);
		int rowStart_No = TestStartRow+2;
		int colStart_No = TestStartRow+1;
		int row = 0;
		while(!xls.getCellData(sheetName, 0, rowStart_No+row).equals("")){
			row++;
		}
		System.out.println("Start Test from Row Number --- > " + rowStart_No);
		int col =0;
		while(!xls.getCellData(sheetName, col, colStart_No).equals("")){
			col++;
		}
		System.out.println("Column Start from Number ---- > " + colStart_No);
		
		/*Object[][] data=new Object[row][1];
		int RowData=0;
		Hashtable<String,String> table=null;
		for(int r=rowStart_No;r<rowStart_No+row;r++){
			table = new Hashtable<String,String>();
			for(int c=0;c<col;c++){
				String key = xls.getCellData(sheetName, c, colStart_No);
				String value = xls.getCellData(sheetName, c, r);
				table.put(key, value);
			}
			data[RowData][0]=table;
			RowData++;
		}
		return data;*/
	}

}
