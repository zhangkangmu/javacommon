package hong.练习的包.Day10_io流;

import java.io.*;

/**
 * Created by zhangyuhong
 * Date:2019/12/28
 */
public class ReadAndWriteDemo {
    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader("exercise\\src\\hong\\练习的包\\Day10_io流\\file\\char.txt");
        FileWriter fileWriter = new FileWriter("exercise\\src\\hong\\练习的包\\Day10_io流\\file\\charCopy.txt");
        int len;
        char[] chars=new char[1024];
        while ((len=fileReader.read(chars))!=-1){
            fileWriter.write(chars,0,len);
        }
        fileWriter.write("zhangyuhong",0,5);
        fileWriter.close();
        fileReader.close();


        BufferedReader bufferedReader1 = new BufferedReader(new FileReader("exercise\\src\\hong\\练习的包\\Day10_io流\\file\\char.txt"));
        String s = bufferedReader1.readLine();
        System.out.println(s);
    }
}
