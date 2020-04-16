package com.zhang.demo03_jasper_pdf;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import org.junit.Test;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;

/**
 * Created by zhangyuhong
 * Date:2020/4/16
 *
 * 用的很少
 */
public class Demo01_jdbc {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");

        Connection connection =
                DriverManager.getConnection("jdbc:mysql://localhost:3306/project_healthy",
                        "root",
                        "root");
        String jrxmlpath="H:\\javaProject\\javacommon\\web_common\\src\\main\\resources\\allData.jrxml";
            //提供编译后文件的路径名称
            String jasperpath="H:\\javaProject\\javacommon\\web_common\\src\\main\\resources\\allData.jasper";
            //编译模板
            JasperCompileManager.compileReportToFile(jrxmlpath);
            //构造数据,不能加泛型,因为fillReport里的map数据不是object
            HashMap map = new HashMap();
            //字段要跟allData.jrxml里的pageFooter里的company字段名一样
            map.put("company","张宇洪");
            //填充数据---使用JDBC数据源方式填充
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperpath, map, connection);

            String pdfpath="H:\\javaProject\\javacommon\\web_common\\src\\main\\resources\\allData.pdf";
//            中文问题,一定要改成华文宋体,还有要导包
            JasperExportManager.exportReportToPdfFile(jasperPrint,pdfpath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
