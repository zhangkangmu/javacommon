package com.zhang.demo02;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.joda.time.DateTime;
import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by zhangyuhong
 * Date:2020/4/4
 */
public class Demo01_ApachePoi_Excel {

    //03版本 的excel
    @Test
    public void testWrite03() throws IOException {
        // 创建新的Excel 工作簿  表格是从0开始算的
        Workbook workbook = new HSSFWorkbook();
        // 在Excel工作簿中建一工作表，其名为缺省值 Sheet0
        //Sheet sheet = workbook.createSheet();
        // 如要新建一名为"会员登录统计"的工作表，其语句为：
        Sheet sheet = workbook.createSheet("会员登录统计");
        // 创建行（row 1）
        Row row1 = sheet.createRow(0);
        // 创建单元格（col 1-1）
        Cell cell11 = row1.createCell(0);
        cell11.setCellValue("今日人数");
        // 创建单元格（col 1-2）
        Cell cell12 = row1.createCell(1);
        cell12.setCellValue(666);
        // 创建行（row 2）
        Row row2 = sheet.createRow(1);
        // 创建单元格（col 2-1）
        Cell cell21 = row2.createCell(0);
        cell21.setCellValue("统计时间");
        //创建单元格（第三列）
        Cell cell22 = row2.createCell(1);
        String dateTime = new DateTime().toString("yyyy-MM-dd HH:mm:ss");
        cell22.setCellValue(dateTime);
        // 新建一输出文件流（注意：要先创建文件夹）
        FileOutputStream out = new FileOutputStream("test-write03.xls");  //表示当前项目下的
        // 把相应的Excel 工作簿存盘
        workbook.write(out);
        // 操作结束，关闭文件
        out.close();
        System.out.println("文件生成成功");
    }

    //07版本
    @Test
    public void testWrite07() throws IOException {
        // 创建新的Excel 工作簿
        Workbook workbook = new XSSFWorkbook();
        //...............
        // 新建一输出文件流（注意：要先创建文件夹）
        FileOutputStream out = new FileOutputStream("d:/excel-poi/test-write07.xlsx");
        //...............
    }
/*
1、使用HSSF
缺点：最多只能处理65536行，否则会抛出异常
java.lang.IllegalArgumentException: Invalid row number (65536) outside allowable range (0..65535)
优点：过程中写入缓存，不操作磁盘，最后一次性写入磁盘，速度快*/
    @Test
    public void testWrite03BigData() throws IOException {
        //记录开始时间
        long begin = System.currentTimeMillis();
        //创建一个SXSSFWorkbook
        Workbook workbook = new HSSFWorkbook();
        //创建一个sheet
        Sheet sheet = workbook.createSheet();
        //xls文件最大支持65536行
        for (int rowNum = 0; rowNum < 65536; rowNum++) {
            //创建一个行
            Row row = sheet.createRow(rowNum);
            for (int cellNum = 0; cellNum < 10; cellNum++) {//创建单元格
                Cell cell = row.createCell(cellNum);
                cell.setCellValue(cellNum);
            }
        }
        System.out.println("done");
        FileOutputStream out = new FileOutputStream("d:/excel-poi/test-write03-bigdata.xls");
        workbook.write(out);
        // 操作结束，关闭文件
        out.close();
        //记录结束时间
        long end = System.currentTimeMillis();
        System.out.println((double)(end - begin)/1000);
    }
/*
    2、使用XSSF
    缺点：写数据时速度非常慢，非常耗内存，也会发生内存溢出，如100万条
    优点：可以写较大的数据量，如20万条*/
@Test
public void testWrite07BigData() throws IOException {
    //记录开始时间
    long begin = System.currentTimeMillis();
    Workbook workbook = new XSSFWorkbook();
    //.........
    FileOutputStream out = new FileOutputStream("d:/excel-poi/test-write07-bigdata.xlsx");
    // ......
}
/*  3、使用SXSSF
    注意：
    过程中会产生临时文件，需要清理临时文件
    默认由100条记录被保存在内存中，如果查过这数量，则最前面的数据被写入临时文件
    如果想自定义内存中数据的数量，可以使用new SXSSFWorkbook(数量)*/
    @Test
    public void testWrite07BigDataFast() throws IOException {
        //记录开始时间
        long begin = System.currentTimeMillis();
        //创建一个SXSSFWorkbook
        Workbook workbook = new SXSSFWorkbook();
//   ......
        FileOutputStream out = new FileOutputStream("d:/excel-poi/test-write07-bigdata-fast.xlsx");
        workbook.write(out);
        // 操作结束，关闭文件
        out.close();
        //清除临时文件
        ((SXSSFWorkbook)workbook).dispose();
        //记录结束时间
        long end = System.currentTimeMillis();
        System.out.println((double)(end - begin)/1000);
    }
//    SXSSFWorkbook-来至官方的解释：实现“BigGridDemo”策略的流式XSSFWorkbook版本。这允许写入非常大的文件而不会耗尽内存，因为任何时候只有可配置的行部分被保存在内存中。
//    请注意，仍然可能会消耗大量内存，这些内存基于您正在使用的功能，例如合并区域，注释......仍然只存储在内存中，因此如果广泛使用，可能需要大量内存。
}
