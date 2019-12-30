package hong.练习的包.z其他;

import hong.utils.Utils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import java.io.*;
import java.nio.Buffer;
import java.util.*;

/**
 * Created by zhangyuhong
 * Date:2019/12/22
 */
public class Main {
    public static void main(String[] args) throws Exception {
//    String str="zhang";
//        String substring = str.substring(0,4);
//        System.out.println(substring);
//        InputStream resourceAsStream = Main.class.getClassLoader().getResourceAsStream("druid.properties");
//        Properties properties = new Properties();
//        try {
//            properties.load(new FileInputStream("exercise\\src\\test.properties"));
//            properties.setProperty("test","123456");
//            properties.store(new FileWriter("exercise\\src\\test.properties"),"zhang");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//        String string = "zhang.yu";
//        String[] split = string.split("\\.");
//
//        System.out.println(Arrays.toString(split));

//        FileReader fileReader = new FileReader(new File(""));
//        fileReader.read();
//
//        FileInputStream fileInputStream = new FileInputStream(new File(""));
//        fileInputStream.read();


//        IOUtils.gbk2utf8("H:\\javaProject\\javacommon\\exercise\\src\\hong\\练习的包\\source_test\\zhang.txt");
//        IOUtils.utf82gbk("H:\\javaProject\\javacommon\\exercise\\src\\hong\\练习的包\\source_test\\zhang.txt");

        //对象序列化
        //Person person = new Person("zhang","男",  "这里",25);
        //ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("exercise\\src\\hong\\练习的包\\source_test\\zhang.txt"));
        //objectOutputStream.writeObject(person);

//        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("exercise\\src\\hong\\练习的包\\source_test\\zhang.txt"));
//        Object o = objectInputStream.readObject();
//        System.out.println(o);

        //PrintStream
//        IOUtils.printLog("zhang");

//        IOUtils.copy(new FileReader("exercise\\src\\hong\\练习的包\\source_test\\first\\1.txt")
//                ,new FileWriter("exercise\\src\\hong\\练习的包\\source_test\\first\\2.txt"));
//        FileUtils.copyDirectoryToDirectory(new File("exercise\\src\\hong\\练习的包\\source_test\\first"),
//                new File("exercise\\src\\hong\\练习的包\\source_test\\second"));
        FileUtils.copyFileToDirectory(new File("exercise\\src\\hong\\练习的包\\source_test\\first\\1.txt"),
                new File("exercise\\src\\hong\\练习的包\\source_test\\second"));
    }
}
