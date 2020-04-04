package com.zhang.demo01;

import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.support.ExcelTypeEnum;
import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangyuhong
 * Date:2020/2/26
 *
 * 阿里巴巴的读表
 */
public class Excel {

    @Test
    public void testRead() throws FileNotFoundException {
        InputStream inputStream =getInputStream("test.xlsx");
        try {
            ExcelReader reader = new ExcelReader(inputStream, ExcelTypeEnum.XLS, null, new AnalysisEventListener() {
                @Override
                public void invoke(Object o, AnalysisContext analysisContext) {
                    System.out.println("当前sheet"+analysisContext.getCurrentSheet().getSheetNo()+ " 当前行：" + analysisContext.getCurrentRowNum()
                            + " data:" + o);
                }

                @Override
                public void doAfterAllAnalysed(AnalysisContext analysisContext) {

                }
            });
            reader.read();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    @Test
    public void testWriter() throws FileNotFoundException {
        OutputStream out = new FileOutputStream("test.xlsx");
        try {
            ExcelWriter writer = new ExcelWriter(out,ExcelTypeEnum.XLS);
            //写第一个sheet
            Sheet sheet = new Sheet(2,3,ImportInfo.class);
            writer.write(getDate(),sheet);
            for (ImportInfo in: getDate()
            ) {
                System.out.println(in.getName());
            }
            writer.finish();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public List<ImportInfo> getDate(){
        List<ImportInfo> list = new ArrayList<ImportInfo>();
        ImportInfo info = new ImportInfo();
        info.setAge(12);
        info.setName("zhangsan");
        info.setEmail("11111@qq.com");
        ImportInfo info1 = new ImportInfo();
        info1.setAge(12);
        info1.setName("zhangsan1");
        info1.setEmail("11111@qq.com");
        ImportInfo info2 = new ImportInfo();
        info2.setAge(12);
        info2.setName("zhangsan2");
        info2.setEmail("11111@qq.com");
        list.add(info);list.add(info1);list.add(info2);
        return list;
    }



    private InputStream getInputStream(String fileName) {
        try {
            return new FileInputStream(new File(fileName));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
