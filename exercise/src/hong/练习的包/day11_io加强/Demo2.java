package hong.练习的包.day11_io加强;

import java.io.*;
import java.util.Properties;
import java.util.Set;

/**
 * Created by zhangyuhong
 * Date:2019/12/30
 * Properties练习
 */
public class Demo2 {

    public static void main(String[] args) {
        Properties properties = new Properties();
        try {
            properties.load(new FileReader("exercise\\src\\hong\\练习的包\\source_test\\test.properties"));
            properties.setProperty("time","2019-12-30");
            properties.put("name", "张宇洪");
            properties.store(new FileWriter("exercise\\src\\hong\\练习的包\\source_test\\test.properties"),"zhang");
            Set<String> strings = properties.stringPropertyNames();
            for (String string : strings) {
                System.out.println(string+"---"+properties.get(string));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
