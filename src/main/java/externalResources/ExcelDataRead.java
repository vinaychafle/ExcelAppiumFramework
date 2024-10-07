package externalResources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataRead {
	XSSFWorkbook wb;
	XSSFSheet sh;
	String fileName;
	
	
	public ExcelDataRead(String fileName) throws IOException {
		this.fileName=fileName;
		File src = new File(System.getProperty("user.dir")+"\\src\\main\\java\\externalResources\\"+fileName+".xlsx");
		FileInputStream fis= new FileInputStream(src);
		wb=new XSSFWorkbook(fis);
		
	}
	
	public void writeExcel(String sheetName,String element, String colName,String msg) throws IOException {
		int rowNo=getRowNumber(sheetName, element);
		int colNo=getColNumber(sheetName, colName);
		sh=wb.getSheet(sheetName);
		
		sh.getRow(rowNo).createCell(colNo, CellType.STRING);
		sh.getRow(rowNo).getCell(colNo).setCellValue(msg);
		
		File srcOut = new File(System.getProperty("user.dir")+"\\src\\main\\java\\externalResources\\"+fileName+".xlsx");
		FileOutputStream fos= new FileOutputStream(srcOut);
		wb.write(fos);
		fos.close();
		
		
	}
	public static void main(String[] args) throws IOException {
		ExcelDataRead read=new ExcelDataRead("IncidentData");
		read.writeExcel("TestOutput", "0", "SRNO", "N011672384");
	}
	
	
	public int getRowNumber(String sheetName,String element) {
		int rowNo = 0;
		String data;
		sh=wb.getSheet(sheetName);
		
		for(int i=0;i<=sh.getLastRowNum();i++) {
			if(!(sh.getRow(i).getCell(0).getCellType()==CellType.STRING)) {
				sh.getRow(i).getCell(0).setCellType(CellType.STRING);
			}
			data=sh.getRow(i).getCell(0).getStringCellValue();
			if(data.equalsIgnoreCase(element)) {
				rowNo=i;
			}
			
		}
		return rowNo;
	}
	
	
	public int getColNumber(String sheetName,String colName) {
		int colNo = 0;
		String data;
		sh=wb.getSheet(sheetName);
		for(int i=0;i<sh.getRow(0).getLastCellNum();i++) {
			if(!(sh.getRow(0).getCell(i).getCellType()==CellType.STRING)) {
				sh.getRow(0).getCell(i).setCellType(CellType.STRING);
			}
			data=sh.getRow(0).getCell(i).getStringCellValue();
			if(colName.equalsIgnoreCase(data)) {
				colNo=i;
			}
			
		}
			return colNo;
	}
	
	public int getLastRowNum(String sheetName) {
		sh=wb.getSheet(sheetName);
		return sh.getLastRowNum();
	}
	
	
	public String getData(String sheetName,String element, String colName) {
		int rowNo=getRowNumber(sheetName, element);
		int colNo=getColNumber(sheetName, colName);
		String data;
		
		data=sh.getRow(rowNo).getCell(colNo).getStringCellValue();
		
		return data;
			
		
	}
	
	
	public String getData(String sheetName,int row, int column) {
		sh=wb.getSheet(sheetName);
		String data; 
		if(sh.getRow(row).getCell(column).getCellType()==CellType.STRING) {
			data=sh.getRow(row).getCell(column).getStringCellValue();
		}
		else {
			sh.getRow(row).getCell(column).setCellType(CellType.STRING);
			data=sh.getRow(row).getCell(column).getStringCellValue();
		}
		return data;
	}
	
	
}
