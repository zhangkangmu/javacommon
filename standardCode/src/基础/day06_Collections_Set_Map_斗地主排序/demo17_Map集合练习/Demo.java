package 基础.day06_Collections_Set_Map_斗地主排序.demo17_Map集合练习;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author 彭智林
 * @date 2019/12/22 15:45
 */
public class Demo {
    public static void main(String[] args) {
        /*
            需求:输入一个字符串,统计该字符串中每个字符出现的次数。
         */
        // 思路:
        // 1.创建一个Scanner对象,用来键盘录入
        Scanner sc = new Scanner(System.in);
        // 2.获取键盘录入的字符串
        System.out.println("请输入一个字符串:");
        String str = sc.nextLine();

        // 3.创建Map集合,键的类型为Character,值的类型为Integer
        Map<Character, Integer> map = new HashMap<>();

        // 4.循环遍历键盘录入的字符串
        for (int i = 0; i < str.length(); i++) {
            // 5.在循环中,取出每一个字符
            char c = str.charAt(i);
            // 6.判断Map集合中是否包含该遍历出来的字符键
            if (map.containsKey(c)) {
                // 8.如果该集合中存在该字符键,就从集合中取出该字符键对应的值,然后+1,再存储到Map集合中
                Integer value = map.get(c) + 1;
                map.put(c,value);
            } else {
                // 7.如果该集合中没有该字符键,就让这个字符作为键,值为1,存入Map集合
                map.put(c,1);
            }
        }
        // 9.循环结束后,打印Map集合
        System.out.println(map);
    }
}
