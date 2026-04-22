package com.nobroker.sprint.utils;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

public class ExcelUtilities {
	WebDriver driver;
    Workbook workbook;
    Sheet sheet;
    private static final String FILE_PATH = "./src/main/resources/Notary.xlsx";

    public ExcelUtilities(WebDriver driver) throws EncryptedDocumentException, IOException {
        this.driver = driver;
  
    }

 
    	public void init(String sheetName) {

    		try {
    			FileInputStream fileInputStream = new FileInputStream(FILE_PATH);
    			workbook = WorkbookFactory.create(fileInputStream);
    			sheet = workbook.getSheet(sheetName);
    			fileInputStream.close();
    		} catch (Exception e) {
    			System.out.println(e);
    		}

    	}

    	public Row getRow(int rowNumber) {
    		if (sheet == null) {
    			System.out.println("Invaid Sheet : Initilize");
    			return null;
    		}
    		return sheet.getRow(rowNumber);
    	}

    	public int getNumberOfRows() {
    		if (sheet == null) {
    			System.out.println("Invaid Sheet : Initilize");
    			return -1;
    		}
    		return sheet.getPhysicalNumberOfRows();
    	}

    	public int getNumberOfCols() {
    		if (sheet == null) {
    			System.out.println("Invaid Sheet : Initilize");
    			return -1;
    		}
    		return sheet.getRow(0).getPhysicalNumberOfCells();
    	}

    	public String getData(int row, int col) {

    		if (sheet == null) {
    			System.out.println("Invaid Sheet : Initilize");
    			return null;
    		}
    		CellType type = sheet.getRow(row).getCell(col).getCellType();

    		if (type == CellType.NUMERIC) {
    			String value = sheet.getRow(row).getCell(col).toString();
    			return value.split("\\.")[0];
    		}
    		return sheet.getRow(row).getCell(col).toString();
    	}

    	public Object[][] getExcelDataAsArray(String sheetName) throws Exception {

    		try (FileInputStream fis = new FileInputStream(FILE_PATH); Workbook wb = WorkbookFactory.create(fis)) {

    			Sheet sheet = wb.getSheet(sheetName);

    			if (sheet == null) {
    				throw new Exception("Sheet not found: " + sheetName);
    			}
    			int row = sheet.getLastRowNum();
    			int col = sheet.getRow(0).getLastCellNum();
    			Object[][] data = new Object[row][col];
    			DataFormatter formatter = new DataFormatter();
    			for (int i = 1; i <= row; i++) {
    				Row currentRow = sheet.getRow(i);
    				if (currentRow == null)
    					continue;
    				for (int j = 0; j < col; j++) {
    					Cell cell = currentRow.getCell(j);
    					if (cell == null) {
    						data[i - 1][j] = "";
    						continue;
    					}
    					switch (cell.getCellType()) {
    					case NUMERIC:
    						data[i - 1][j] = formatter.formatCellValue(cell);
    						break;
    					case BOOLEAN:
    						data[i - 1][j] = cell.getBooleanCellValue();
    						break;
    					case STRING:
    						data[i - 1][j] = cell.getStringCellValue();
    						break;
    					default:
    						data[i - 1][j] = formatter.formatCellValue(cell);
    						break;
    					}
    				}
    			}

    			return data;
    		}

    	}

  
    public static String getExcelData(String sheet, int row, int col) {
        try {
        	FileInputStream fls = new FileInputStream("./src/test/resources/Readers/Config.xlsx");
            XSSFWorkbook wb = new XSSFWorkbook(fls);
            String data = wb.getSheet(sheet).getRow(row).getCell(col).toString();
            wb.close();
            return data;
        } catch (Exception e) {
            return "";
        }
    }
    
    public static int getRowCount(String sheet) {
        try (FileInputStream fis = new FileInputStream("./src/test/resources/Readers/Config.xlsx");
             Workbook wb = WorkbookFactory.create(fis)) {

            return wb.getSheet(sheet).getLastRowNum();

        } catch (Exception e) {
            return 0;
        }
    }
}
