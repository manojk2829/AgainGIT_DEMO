package excelReader_Package;

import java.util.Hashtable;

public class Excel_Data_Read {
	
	public static Object[][] getExcelData(Xls_Reader xls,String sheetName,String testcases){
		int testStart=1;
		while(!xls.getCellData(sheetName, 0, testStart).equals(testcases)){
			testStart++;
		}
		System.out.println("Test Start --> "+testStart);
		
		int rowStart = testStart+2;
		int colStart = testStart+1;
		
		int row=0;
		while(!xls.getCellData(sheetName, 0, rowStart+row).equals("")){
			row++;
		}
		System.out.println("Row Start --> "+rowStart);
		
		int col=0;
		while(!xls.getCellData(sheetName, col, colStart).equals("")){
			col++;
		}
		System.out.println("Col Start --> "+ colStart);
		
		int RD=0;
		Object[][] da=new Object[row][1];
		Hashtable<String, String> table= null;
		for(int r=rowStart;r<rowStart+row;r++){
			table = new Hashtable<String, String>();
			for(int c=0;c<col;c++){
				String key = xls.getCellData(sheetName, c, colStart);
				String value = xls.getCellData(sheetName, c, r);
				table.put(key, value);
			}
			da[RD][0]=table;
			RD++;
		}
		return da;
	}
}
