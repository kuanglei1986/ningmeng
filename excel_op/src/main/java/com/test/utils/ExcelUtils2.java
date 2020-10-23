package com.test.utils;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.test.constants.constants;
import com.test.pojo.API;
import com.test.pojo.Case;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExcelUtils2 {
    public static List<API> apiList = ExcelUtils2.read(0,API.class);
    public static List<Case> caseList = ExcelUtils2.read(1,Case.class);

    public static void main(String[] args) throws Exception {
//        for(API api:apiList) {
//            System.out.println(api);
//        }
//        System.out.println("-------------------");
//        for(Case c:caseList) {
//            System.out.println(c);
//        }
        getAPIandCaseByApild("1");



    }

//    从已经读取好的所有List<API>和所有List<Case>*两个集合中获取符合条件的数据。
    public static void getAPIandCaseByApild(String apild) {
        //需要Api对象
        API wantAPI = null;
//        需要case集合
        List<Case> wantCaseList = new ArrayList<Case>();
//        匹配API对象
        for(API api:apiList) {
            //apild和api集合中的apild相等则返回
            if(apild.equals(api.getId())) {
                System.out.println("api= "+ api);
                wantAPI = api;
                System.out.println("wantAPI= "+ wantAPI);
                break;
            }

        }
//        匹配case对象
        for(Case c:caseList) {
            if(apild.equals(c.getApiId())) {
                System.out.println("c= " + c);
                wantCaseList.add(c);
                System.out.println("wantCaseList= " + wantCaseList);
            }
        }




    }


    /**
     * 读取excel数据并封装到指定对象中
     *
     * @param sheetIndex 开始sheet索引
     * @param sheetNum   sheet个数
     * @param clazz      excel映射类字节对象
     * @return
     */

    public static <E> List<E> read(int sheetIndex, Class clazz)  {
//        URL filepath = ExcelUtils.class.getResource("/cases_v1.xls");
        //1、excel文件流
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(constants.EXCEL_PATH);
            //2、easypoi导入参数
            ImportParams params = new ImportParams();
            //从第0个sheet开始读取
            params.setStartSheetIndex(sheetIndex);
            //读取1个sheet
            params.setSheetNum(1);
            //3、导入 importExcel(execl文件流，映射关系字节码对象，导入参数)
            List<E> list = ExcelImportUtil.importExcel(fis, clazz, params);
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;


//        System.out.println(list.size());
//        for (E e : list) {
//            System.out.println(e);
//        }

//
//        //当前类的绝对路径
////        System.out.println(ExcelUtils.class.getResource("/cases_v1.xls").getFile());
////        指定CLASSPATH文件的绝对路径
////        System.out.println(ExcelUtils.class.getResource(cp).getFile());
//
//
//
//    }


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

}