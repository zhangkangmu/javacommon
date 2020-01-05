package 基础.day14_正则表达式.demo6_正则表达式的概述;

import java.util.Scanner;

/**
 * @author 彭智林
 * @date 2020/1/3 14:38
 */
public class Demo {
    /*
        需求:定义一个方法,判断用户输入的QQ号码是否正确，正确的qq号码满足以下条件：
            - QQ号码必须是5--15位长度
            - 而且必须全部是数字
            - 而且首位不能为0
     */
    public static void main(String[] args) {
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("请输入qq号码:");
            String qq = sc.next();
            // 传统方式判断
            // System.out.println(checkQQ(qq));
            // 正则表达式判断
            // String 类 boolean matches(String regex)
            System.out.println(qq.matches("[1-9]\\d{4,14}"));
        }
    }

    /**
     * 判断用户输入的QQ号码是否正确
     * @param qqStr
     * @return
     */
    public static boolean checkQQ(String qqStr){
        // 判断是否null
        if(qqStr == null){
            return false;
        }
        // QQ号码必须是5--15位长度
        if(qqStr.length() < 5 || qqStr.length() > 15){
            return false;
        }

        // 必须全部是数字
        for (int i = 0; i < qqStr.length(); i++) {
            char ch = qqStr.charAt(i);
            if(ch < '0' || ch > '9'){
                return false;
            }
        }

        // 首位不能为0
        if(qqStr.charAt(0) == '0'){
            return false;
        }

        return true;
    }


}
