package hong.练习的包.day11_io加强;

import java.io.*;
import java.sql.SQLOutput;
import java.util.HashMap;

/**
 * Created by zhangyuhong
 * Date:2017/12/30
 * 对《出师表》进行排序
 */
public class Demo3 {

    private static HashMap<String, String> stringStringHashMap;

    public static void main(String[] args) throws Exception{
                BufferedReader bufferedReader = new BufferedReader(new FileReader("exercise\\src\\hong\\练习的包\\source_test\\a.txt"));
            stringStringHashMap = new HashMap<>();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] split = line.split("\\.");
                stringStringHashMap.put(split[0], split[1]);
            }
//        System.out.println(stringStringHashMap);
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("exercise\\src\\hong\\练习的包\\source_test\\a.txt"));
        for (int i = 1; i <= stringStringHashMap.size(); i++) {
                System.out.println(i + "." + stringStringHashMap.get(i + ""));
                bufferedWriter.write(i + "." + stringStringHashMap.get(i + ""));
            bufferedWriter.newLine();
            }
        bufferedWriter.close();
        bufferedReader.close();
    }
}
