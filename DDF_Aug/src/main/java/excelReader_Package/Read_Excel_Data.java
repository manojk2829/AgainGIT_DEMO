package excelReader_Package;

import java.util.Hashtable;

public class Read_Excel_Data {
	
	public static Object[][] getExcelData(Xls_Reader xls,String testCaseName,String sheetName){
		int TestStart_Row=1;
		while(!xls.getCellData(sheetName, 0, TestStart_Row).equals(testCaseName)) {
			TestStart_Row++;
		}
		System.out.println("Test Start Number ---- >  " + TestStart_Row);
		int rowStart = TestStart_Row+2;
		int colStart = TestStart_Row+1;
		int row=0;
		while(!xls.getCellData(sheetName, 0, rowStart+row).equals("")) {
			row++;
		}
		System.out.println("rowStart  -- > " + rowStart);
		
		int col=0;
		while(!xls.getCellData(sheetName, col, colStart).equals("")) {
			col++;
		}
		System.out.println("colStart --> " + colStart);
	    
		int ROWDATA=0;
		Object[][] data=new Object[row][1];
		Hashtable<String, String> table=null;
		for(int r=rowStart;r<rowStart+row;r++) {
			table = new Hashtable<String, String>();
			for(int c=0;c<col;c++) {
				String key = xls.getCellData(sheetName, c,colStart);
				String value = xls.getCellData(sheetName, c, r);			
			    table.put(key, value);	
			}
			data[ROWDATA][0]=table;
			ROWDATA++;
		}
	   return data;
    }
}
