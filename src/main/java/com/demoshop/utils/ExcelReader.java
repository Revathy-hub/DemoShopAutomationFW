package com.demoshop.utils;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.demoshop.context.Constants;

public class ExcelReader {
	public static String getCellValue(int rowNumber, int cellNumber) throws IOException {

		FileInputStream fis = new FileInputStream(Constants.EXCELFILEPATH);
		XSSFWorkbook xs = new XSSFWorkbook(fis);
		XSSFSheet sh = xs.getSheet("Sheet1");
		Row row = sh.getRow(rowNumber);
		Cell cell = row.getCell(cellNumber);
		return cell.toString();

	}
}
