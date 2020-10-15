package com.test.utils;

import com.test.pojo.API;
import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;

public class ExcelUtils {
    public static void main(String[] args) throws Exception {
        read();
    }

    /**
     * 读取excel数据并封装到指定对象中
     * @param sheetIndex        开始sheet索引
     * @param sheetNum          sheet个数
     * @param clazz             excel映射类字节对象
     * @return
     */
    public static void read() throws Exception {
//        URL filepath = ExcelUtils.class.getResource("/cases_v1.xls");
        //1、excel文件流
        FileInputStream fis = new FileInputStream("excel_op\\cases_v1.xls");
//        FileInputStream fis = new FileInputStream(String.valueOf(filepath));
        //2、easypoi导入参数
        ImportParams params = new ImportParams();
        //3、导入 importExcel(execl文件流，映射关系字节码对象，导入参数)
        List<API> list = ExcelImportUtil.importExcel(fis, API.class,params);
        System.out.println(list.size());
        for(API api:list) {
            System.out.println(api);
        }

        //当前类的绝对路径
//        System.out.println(ExcelUtils.class.getResource("/cases_v1.xls").getFile());
//        指定CLASSPATH文件的绝对路径
//        System.out.println(ExcelUtils.class.getResource(cp).getFile());



    }



//    public static Object[][] read() throws IOException {
//        FileInputStream fis = null;
//        Object[][] datas = null;
//        try {
//            fis = new FileInputStream("cases_v1.xls");
//            Workbook workbook = WorkbookFactory.create(fis);
////        获取sheet
//            Sheet sheet = workbook.getSheet("用例");
////        获取row
//            int lastRowNum = sheet.getLastRowNum();
//            datas = new Object[lastRowNum][4];
////            跳过表头，从1开始
//            for(int i = 1;i <= lastRowNum; i++) {
//                Row row = sheet.getRow(i);
//
////                获取url
//                Cell urlcell = row.getCell(2, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
//                urlcell.setCellType(CellType.STRING);
//                String urlCellValue = urlcell.getStringCellValue();
//                datas[i-1][0] = urlCellValue;
//
//                //                获取type
//                Cell typecell = row.getCell(3, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
//                typecell.setCellType(CellType.STRING);
//                String typecellValue = typecell.getStringCellValue();
//                datas[i-1][1] = typecellValue;
//
//                //                获取Params
//                Cell Paramscell = row.getCell(5, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
//                Paramscell.setCellType(CellType.STRING);
//                String ParamscellValue = Paramscell.getStringCellValue();
//                datas[i-1][2] = ParamscellValue;
//
//                //                获取content-type
//                Cell contenTypecell = row.getCell(6, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
//                contenTypecell.setCellType(CellType.STRING);
//                String contenTypecellValue = contenTypecell.getStringCellValue();
//                datas[i-1][3] = contenTypecellValue;
//
//                System.out.println("url: "+urlCellValue + ",type:" + typecellValue +
//                        ", params: " + ParamscellValue+",content-type:" + contenTypecellValue);
//
//            }
//            return datas;
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                fis.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//
//        return datas;
//    }
}
