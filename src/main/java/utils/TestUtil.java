package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import base.TestBase;

public class TestUtil extends TestBase {
	
	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 10;
	public static String TESTDATA_SHEET_PATH = System.getProperty("user.dir")+"\\src\\main\\java\\testdata\\codingTaskTestData.xlsx";
	
	static Workbook book;
	static Sheet sheet;

//	public void switchToFrame() {
//		driver.switchTo().frame("");
//	}
	
	
	public static Object[][] getTestData(String sheetName){
		FileInputStream file = null;
		
		 try {
			 file = new FileInputStream(TESTDATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		 
		 try {
			book = WorkbookFactory.create(file);
		} catch (EncryptedDocumentException e) {			
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		 
		 sheet = book.getSheet(sheetName);
		 Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		 
		 for(int i=0;i < sheet.getLastRowNum(); i++) {
			 for(int k = 0;k < sheet.getRow(0).getLastCellNum(); k++) {
				 data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
			 }			 
		 }	
		return data;		
	}
	
	public void getScreenShotPath(String testCaseName, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
		FileUtils.copyFile(source, new File(destinationFile));
		
	}
	
}
