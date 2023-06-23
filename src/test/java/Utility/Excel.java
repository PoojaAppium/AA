package Utility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

import com.microsoft.appcenter.appium.EnhancedAndroidDriver;

import io.appium.java_client.MobileElement;

public class Excel {

	
	private XSSFWorkbook XW;
	private XSSFSheet XS;
	EnhancedAndroidDriver<MobileElement> Driver ;
	
	
	
	
	
	
	public Excel(EnhancedAndroidDriver<MobileElement> Driver ) {
	      this.Driver = Driver;
		   }
	public void WriteInExcel(int Row , int Cell , String CellValue) throws IOException {

	    FileInputStream fis = new FileInputStream("./TestData/TestData.xlsx");
	     XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet sheet = wb.getSheet("Sheet1");
     //   sheet.getRow(Row).createCell(Cell).setBlank();
        sheet.getRow(Row).createCell(Cell).setCellValue(CellValue);
		FileOutputStream fos = new FileOutputStream("./TestData/TestData.xlsx");
		wb.write(fos);
	    wb.close();
	}
	
	

	public String ReadFromExcel(int Row , int Cell) throws IOException {
		
		FileInputStream ExcelFile = new FileInputStream("./TestData/TestData.xlsx");
     // Access the required test data sheet
		XSSFWorkbook ExcelWBook = new XSSFWorkbook(ExcelFile);
		XSSFSheet   ExcelWSheet = ExcelWBook.getSheet("Sheet1");  
      try {
         String CellData =
            ExcelWSheet.getRow(Row).getCell(Cell).getStringCellValue();
         System.out.println("The value of CellData " + CellData);
         return CellData;
      } catch (Exception e) {
         return "Errors in Getting Cell Data";
      }
      
   }

}
