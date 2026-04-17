package com.nobroker.sprint.utils;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	public String readdata(String sheetName,int row,int col) {
		String path="./src/test/resources/script_data/Landlord_Tenant_details.xlsx";
		String data="";
		try {
			FileInputStream fis=new FileInputStream(path);
			Workbook wb=WorkbookFactory.create(fis);
			Sheet sheet=wb.getSheet("Details");
			data=sheet.getRow(row).getCell(col).toString();
		}
		catch(Exception e) {
            e.printStackTrace();

		}
		return data;
		
	}

}
