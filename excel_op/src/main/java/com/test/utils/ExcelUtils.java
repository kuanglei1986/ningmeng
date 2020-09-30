package com.test.utils;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

public class ExcelUtils {
    public static void main(String[] args) throws IOException {
        Object[][] datas = read();
        for(Object[] objects : datas) {
            System.out.println(Arrays.toString(objects));
        }
    }

    public static Object[][] read() throws IOException {
        FileInputStream fis = null;
        Object[][] datas = null;
        try {
            fis = new FileInputStream("cases_v1.xls");
            Workbook workbook = WorkbookFactory.create(fis);
//        获取sheet
            Sheet sheet = workbook.getSheet("用例");
//        获取row
            int lastRowNum = sheet.getLastRowNum();
            datas = new Object[lastRowNum][4];
//            跳过表头，从1开始
            for(int i = 1;i <= lastRowNum; i++) {
                Row row = sheet.getRow(i);

//                获取url
                Cell urlcell = row.getCell(2, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                urlcell.setCellType(CellType.STRING);
                String urlCellValue = urlcell.getStringCellValue();
                datas[i-1][0] = urlCellValue;

                //                获取type
                Cell typecell = row.getCell(3, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                typecell.setCellType(CellType.STRING);
                String typecellValue = typecell.getStringCellValue();
                datas[i-1][1] = typecellValue;

                //                获取Params
                Cell Paramscell = row.getCell(5, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                Paramscell.setCellType(CellType.STRING);
                String ParamscellValue = Paramscell.getStringCellValue();
                datas[i-1][2] = ParamscellValue;

                //                获取content-type
                Cell contenTypecell = row.getCell(6, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                contenTypecell.setCellType(CellType.STRING);
                String contenTypecellValue = contenTypecell.getStringCellValue();
                datas[i-1][3] = contenTypecellValue;

                System.out.println("url: "+urlCellValue + ",type:" + typecellValue +
                        ", params: " + ParamscellValue+",content-type:" + contenTypecellValue);

            }
            return datas;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return datas;
    }
}
