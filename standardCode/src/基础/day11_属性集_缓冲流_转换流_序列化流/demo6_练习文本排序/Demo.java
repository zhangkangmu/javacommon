package 基础.day11_属性集_缓冲流_转换流_序列化流.demo6_练习文本排序;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 彭智林
 * @date 2019/12/30 11:03
 */
public class Demo {
    public static void main(String[] args) throws Exception {
        /*
            练习: 文本排序
            需求:请将文本信息恢复顺序。
         */
        // 1.从a.txt文件中读取数据以键值对的形式存储到Map集合中
        // 1.1 创建HashMap集合,指定键的类型为String,值的类型为String
        Map<String, String> map = new HashMap<>();

        // 1.2 创建字符缓冲输入流对象,关联数据源文件路径
        FileReader fr = new FileReader("day11\\bbb\\a.txt");
        BufferedReader br = new BufferedReader(fr);

        // 1.3 定义一个String类型的变量,用来存储读取到的行数据
        String line = null;

        // 1.4 循环读取
        while ((line = br.readLine()) != null) {
            // 1.5 在循环中,对读取出来的行数据以点进行分割
            String[] arr = line.split("\\.");
            // 1.6 分割之后的第一个元素作为键,第二个元素作为值,存储到map集合中
            map.put(arr[0],arr[1]);
        }
        // 1.7 关闭流,释放资源
        br.close();

        // 2.将Map集合中的数据按照键的从小到大的顺序写回到a.txt文件中
        // 2.1 创建字符缓冲输出流对象,关联目的地文件路径
        FileWriter fw = new FileWriter("day11\\bbb\\a.txt");
        BufferedWriter bw = new BufferedWriter(fw);

        // 2.2 按照1-9的顺序开始循环
        for (int i = 1; i <= 9; i++) {
            // 2.3 在循环中,根据1-9的顺序作为键去map集合中取值
            String value = map.get(i + "");
            // 2.4 在循环中,使用键+点+值得到原有的行数据
            String newLine = i+"."+value;
            // 2.5 在循环中,使用字符输出流,把拼接后的行数据写回到目的地文件中
            bw.write(newLine);
            bw.newLine();
        }
        // 2.6 在循环外,关闭流,释放资源
        bw.close();
    }
}
