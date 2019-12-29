package hong.练习的包.Day10_io流;

import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Stream;

/**
 * Created by zhangyuhong
 * Date:2019/12/28
 */
public class Demo {

    public static void main(String[] args) throws IOException {
        File aFile = new File("exercise\\src\\hong\\练习的包\\Day10_io流\\file\\a.txt");
        File zhangFile = new File("exercise\\src\\hong\\练习的包\\Day10_io流\\file\\zhang.txt");
        FileOutputStream fileOutputStream = new FileOutputStream(zhangFile);
        FileInputStream fileInputStream = new FileInputStream(aFile);
        byte[] bytes=new byte[1024];
        int read ;
        while ((read = fileInputStream.read(bytes))!=-1){
            fileOutputStream.write(bytes,0,read);
        }
        fileInputStream.close();
        fileOutputStream.close();
    }

}
