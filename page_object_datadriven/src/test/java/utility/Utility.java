package utility;
import java.io.File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
public class Utility {
	
	private static XSSFSheet ExcelWSheet;

	private static XSSFWorkbook ExcelWBook;

	private static XSSFCell Cell;

	public static void captureScreenShot(WebDriver driver,String name){
		File scrnsht =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrnsht, new	File("./Results/"+name+".png"));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
}
	
	
	public static Object[][] getTableArray(String FilePath, String SheetName) throws Exception {   

	   String[][] tabArray = null;

	   try {

		   FileInputStream ExcelFile = new FileInputStream(FilePath);

		   // Access the required test data sheet

		   ExcelWBook = new XSSFWorkbook(ExcelFile);

		   ExcelWSheet = ExcelWBook.getSheet(SheetName);

		   int startRow = 1;

		   int startCol = 1;

		   int ci,cj;

		   int totalRows = ExcelWSheet.getLastRowNum();

		   // you can write a function as well to get Column count

		   int totalCols = 3;

		   tabArray=new String[totalRows][totalCols];

		   ci=0;

		   for (int i=startRow;i<=totalRows;i++, ci++) {           	   

			  cj=0;

			   for (int j=startCol;j<=totalCols;j++, cj++){

				   tabArray[ci][cj]=getCellData(i,j);

				   System.out.println(tabArray[ci][cj]);  

					}

				}

			}

		catch (FileNotFoundException e){

			System.out.println("Could not read the Excel sheet");

			e.printStackTrace();

			}

		catch (IOException e){

			System.out.println("Could not read the Excel sheet");

			e.printStackTrace();

			}

		return(tabArray);

		}

	public static String getCellData(int RowNum, int ColNum) throws Exception {

		try{
			Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
			String CellData = Cell.getStringCellValue();
			return CellData;	
		}
		catch (Exception e){

			System.out.println(e.getMessage());

			throw (e);

			}

		}

}


