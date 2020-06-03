package com.zhang.demo03_jasper_pdf;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanArrayDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhangyuhong
 * Date:2020/4/16
 */
public class Demo02_map {
    public static void main(String[] args) {
        try {
            String jrxmlpath="H:\\javaProject\\javacommon\\web_common\\src\\main\\resources\\allData.jrxml";
            //提供编译后文件的路径名称
            String jasperpath="H:\\javaProject\\javacommon\\web_common\\src\\main\\resources\\allData.jasper";
            //编译模板,这里是两个参数的
            JasperCompileManager.compileReportToFile(jrxmlpath,jasperpath);
//构造数据  ，设置的parameter参数用的
            Map paramters = new HashMap();
            paramters.put("company","张宇洪");

            //构造数据，准备被遍历用等
            List<Map> list = new ArrayList<Map>();
            Map map1 =new HashMap();
            map1.put("price",66.6f);
            map1.put("name","套餐1");
            map1.put("sex","女");

            Map map2 =new HashMap();
            map2.put("price",10f);
            map2.put("name","套餐2");
            map2.put("sex","男");


            list.add(map1);
            list.add(map2);

//填充数据---使用JDBC数据源方式填充
            JasperPrint jasperPrint =
                    JasperFillManager.fillReport(jasperpath,
                            paramters,
                            new JRBeanCollectionDataSource(list));
            //输出文件
            String pdfPath = "H:\\javaProject\\javacommon\\web_common\\src\\main\\resources\\allData.pdf";
            JasperExportManager.exportReportToPdfFile(jasperPrint,pdfPath);
        } catch (JRException e) {
            e.printStackTrace();
        }
    }


}
