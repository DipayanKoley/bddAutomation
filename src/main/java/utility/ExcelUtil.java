package utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil
{
	public static XSSFWorkbook wBook = null;
	public static XSSFSheet wSheet = null;
	public static XSSFRow row = null;
	public static XSSFCell cell = null;
	public static int rowLen = 0;
	public static int colLen = 0;
	
	public static void setExcel(String filePath, String sheetName) throws FileNotFoundException
	{
		FileInputStream fis = new FileInputStream(filePath);
		
		wBook = new XSSFWorkbook();
		
		wSheet = wBook.getSheet(sheetName);
		
		rowLen = wSheet.getPhysicalNumberOfRows();
	}
	
	public static String readExcel(int rowVal, int colVal)
	{
		row = wSheet.getRow(rowVal);
		
		cell = row.getCell(colVal);
		
		return cell.getStringCellValue();
	}
}
