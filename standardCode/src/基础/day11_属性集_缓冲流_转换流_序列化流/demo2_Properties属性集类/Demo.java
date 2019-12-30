package 基础.day11_属性集_缓冲流_转换流_序列化流.demo2_Properties属性集类;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

/**
 * @author 彭智林
 * @date 2019/12/30 9:10
 */
public class Demo {
    public static void main(String[] args) throws Exception {
        /*
            Properties属性集类:
                1.包: java.util
                2.概述:java.util.Properties 继承于Hashtable ，来表示一个持久的属性集。
                3.特点:
                    3.1 Properties类实现了Map接口,所以可以当成是Map集合使用
                    3.2 Properties类当成属性集来使用,键和值的类型是String类型
                    3.3 Properties类可以与流一起使用,来加载文件中的数据
                4.构造方法:
                    Properties()  创建一个无默认值的空属性列表。
                5.成员方法:
                    基本存储方法:
                    - public Object setProperty(String key, String value) ： 保存一对属性。
                    - public String getProperty(String key) ：使用此属性列表中指定的键搜索属性值。
                    - public Set<String> stringPropertyNames() ：所有键的名称的集合。

                    与流相关的方法
                        - public void load(InputStream inStream)： 从字节输入流中读取键值对。
                        - public void load(Reader reader):从字符输入流中读取键值对。
                        参数中使用了输入流，通过流对象，可以关联到某文件上，这样就能够加载文本中的数据了。
                        文本数据格式: 键值对的格式
                        文本中的数据，必须是键值对形式，可以使用空格、等号、冒号等符号分隔。
                        例如:
                            usrername=zs
                            password=123456
         */
        // 扩展:如果加载的文件中数据有中文
        // 1.创建Properties对象
        Properties prop = new Properties();

        // 2.调用load方法进行加载配置文件中的键值对数据
//        prop.load(new FileInputStream("day11\\aaa\\a.txt"));
        prop.load(new FileReader("day11\\aaa\\a.txt"));

        // 3.获取所有的键
        Set<String> keys = prop.stringPropertyNames();

        // 4.循环遍历所有的键,再根据键找值
        for (String key : keys) {
            String value = prop.getProperty(key);
            System.out.println(key+"....."+value);
        }

        // 扩展:往a.txt文件中添加一对键值对 sex=男  了解即可
        /*
            Properties类: void store(Writer writer, String comments) 把Properties对象中的数据保存到指定文件中
         */
        prop.setProperty("sex","男");
        FileWriter fw = new FileWriter("day11\\aaa\\a.txt");
        prop.store(fw,"zhangsan");

        /*FileWriter fw = new FileWriter("day11\\aaa\\a.txt",true);
        fw.write("\r\n");
        fw.write("sex=男");
        fw.close();*/

    }

    /**
     * Properties类与流相关的方法
     * @throws IOException
     */
    private static void method02() throws IOException {
        // 1.创建Properties对象
        Properties prop = new Properties();

        // 2.调用load方法进行加载配置文件中的键值对数据
//        prop.load(new FileInputStream("day11\\aaa\\db.properties"));
        prop.load(new FileReader("day11\\aaa\\db.properties"));

        // 3.获取所有的键
        Set<String> keys = prop.stringPropertyNames();

        // 4.循环遍历所有的键,再根据键找值
        for (String key : keys) {
            String value = prop.getProperty(key);
            System.out.println(key+"....."+value);
        }
    }

    /**
     * Properties类的构造方法和基本存储方法
     */
    private static void method01() {
        // 1.创建Properties对象
        Properties prop = new Properties();
        // 2.往prop对象中添加键值对 : setProperty(String key, String value)
        prop.setProperty("谢霆锋","张柏芝");
        prop.setProperty("文章","马伊琍");
        prop.setProperty("王宝强","马蓉");
        prop.put("贾乃亮","李小璐");
        System.out.println("prop:"+prop);

        // 3.根据键找值 : String getProperty(String key)
        System.out.println("王宝强这个键对应的值:"+prop.getProperty("王宝强"));
        System.out.println("贾乃亮这个键对应的值:"+prop.get("贾乃亮"));

        // 4.获取所有的键: Set<String> stringPropertyNames()
        Set<String> keys = prop.stringPropertyNames();
        for (String key : keys) {
            System.out.println("key:"+key);
        }


        Set<Object> keySet = prop.keySet();
        System.out.println(keySet);
    }
}
