package hong.练习的包.day11_io加强;

import java.io.*;

/**
 * Created by zhangyuhong
 * Date:2019/12/30
 */
public class Demo {

//    private static BufferedReader bufferedReader;
//    private static BufferedWriter bufferedWriter;

    public static void main(String[] args) {
        try (
                BufferedReader bufferedReader = new BufferedReader(new FileReader("exercise\\src\\hong\\练习的包\\source_test\\a.txt"));
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("exercise\\src\\hong\\练习的包\\source_test\\b.txt"));
        ) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                bufferedWriter.write(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
