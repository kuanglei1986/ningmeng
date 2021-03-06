package com.lemon.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;


public class demo {
    public static void main(String[] args) throws InvalidFormatException {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("excel_op/src/main/resources/demo.xlsx");
//            workbook=整个excel
            Workbook workbook = WorkbookFactory.create(fis);
            Sheet sheet = workbook.getSheetAt(0);
            Row row = sheet.getRow(0);

//            第一行第一个单元格
            Cell cell = row.getCell(0, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
            cell.setCellType(CellType.STRING);
            String value2 = cell.getStringCellValue();
            System.out.println(value2);

            fis.close();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关流
            try {
                if(fis != null) {
                    fis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
