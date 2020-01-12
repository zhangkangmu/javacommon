package hong.utils;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;

/**
 * Created by zhangyuhong
 * Date:2017/12/6
 */
public class Utils {

    public long testName(Method method) {
        long now = System.currentTimeMillis();
//        反射
//        method.invoke(Object,);
        long end = System.currentTimeMillis();
        return end-now;
    }

    /**
     * 是否是素数：只能自己和1整除
     *
     * @param num
     * @return
     */
    public static boolean isPrime(int num) {
        int count = 0;
        for (int i = 1; i <= num; i++) {
            if (num % i == 0) {
                count++;
            }
        }
        if (count == 2) {
            return true;
        } else {
            return false;
        }
    }

    private static void sort(int num) {
        for (int i = 1; i <= 200; i++) {
            System.out.print(i + " ");
            if (i / 10 >= 1 && i / 10 <= 9) {
                System.out.print(" ");
            } else if (i / 10 < 1) {
                System.out.print("  ");
            }

            if (i % num == 0) {
                System.out.println("");
            }
        }
    }

    private static void sort02() {
        //冒泡排序
        int[] resource = {5, 1, 8, 3, 9, 2, 4, 7, 1, 3, 1, 5};
        int temp;
        for (int i = 0; i < resource.length - 2; i++) {
            for (int j = 0; j < resource.length - i - 1; j++) {
                if (resource[j + 1] < resource[j]) {
                    temp = resource[j + 1];
                    resource[j + 1] = resource[j];
                    resource[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(resource));

    }

    private static void calculateNumber() {
        /**【程序13】
         *题目：一个整数,它加上100 后是一个完全平方数,再加上168 又是一个完全平方数,请问
         *该数是多少？
         */
        double number = 0;
        double m = 0;
        double n = 0;
        while (true) {
            number += 1;
            m = Math.sqrt(number + 100);
            n = Math.sqrt(number + 168 + 100);
            if (m * m == (number + 100) && n * n == (number + 168 + 100)) {
                System.out.println(number);
                break;
            } else {
                number += 1;
            }
        }

    }

    private static void calculateThreeNumber() {
        //题目：有1、2、3、4 四个数字,能组成多少个互不相同且无重复数字的三位数？都是多少？
        //组成的三位数
        int sum = 0;
        //个数
        int number = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 4; k++) {
                    if (i != j && i != k && j != k) {
                        number = number + 1;
                        System.out.print(i * 100 + j * 10 + k + "--");
                    }
                }
            }
        }
        System.out.println("一共有不重复三位数的数量是：" + number);

    }

    private static void calculateTotal() {
        /**20.  如果一个数等于其所有因子之和,我们就称这个数为"完数",
         例如6 的因子为1,2,3,6=1+2+3,6就是一个完数.请编程打印出1000  以内所有的完数
         */
        for (int i = 0; i < 1000; i++) {
            int sum = 0;
            for (int j = 1; j <= i / 2; j++) {
                if (i % j == 0) {
                    sum = sum + j;
                }
            }
            if (sum == i) {
                System.out.print(i + "--");
            }
        }

    }

    private static void calculateChar() {
        /**
         * 【程序7】
         *题目：输入一行字符,分别统计出其中英文字母、空格、数字和其它字符的个数。英文字母(65-90,97-122),空格（10）,数字（48 - 57）
         */
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入字符串：");
        String str = scanner.nextLine();
        char[] c = str.toCharArray();
        int charNumber = 0;
        int number = 0;
        int spaceNumber = 0;
        int ohterNumber = 0;
        for (int i = 0; i < c.length; i++) {
            if (c[i] >= 65 && c[i] <= 90 || c[i] >= 97 && c[i] <= 122) {
                System.out.print(c[i] + "-");
                //說明是字母
                charNumber += 1;
            } else if (48 <= c[i] && 57 >= c[i]) {
                number += 1;
            } else if (c[i] == ' ') {
                spaceNumber += 1;
            } else {
                ohterNumber += 1;
            }
        }
        System.out.println("英文字母数：" + charNumber + "空格数：" + spaceNumber + "数字数：" + number + "其他的文字数：" + ohterNumber);
    }

    private static void calculateMaxAndMin() {
        //	题目：输入两个正整数m 和n,求其最大公约数和最小公倍数。
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入第一个数：");
        int firstNumber = scanner.nextInt();
        System.out.println("请输入第二个数：");
        int secondNumber = scanner.nextInt();
        //	12 18
        int maxNumber = firstNumber > secondNumber ? firstNumber : secondNumber;
        int minBumber = firstNumber < secondNumber ? firstNumber : secondNumber;
        int total = maxNumber * minBumber;
        while (minBumber != 0) {
            int temp = maxNumber % minBumber;
            maxNumber = minBumber;
            minBumber = temp;
        }
        System.out.println("最大公约数是：" + maxNumber);
        System.out.println("最小公倍数是:" + total / maxNumber);
    }

    private static void gradeABC() {
		/*利用条件运算符的嵌套来完成此题：学习成绩> =90 分的同学用A 表示,60-89 分之
				间的用B 表示,60 分以下的用C 表示。
				解题思路：用三元表达式*/
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("请依次输入分数");
            int score = scanner.nextInt();
            String c = score >= 90 ? "A" : (score >= 60 ? "B" : "C");
            System.out.println(c);
        }
    }

    private static void calculate() {
        //		题目：输入某年某月某日,判断这一天是这一年的第几天？
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("请依次输入年月日 例如 2017 12 1");
            System.out.println("请依次输入年：");
            int yeas = scanner.nextInt();
            System.out.println("请依次输入月：");
            int month = scanner.nextInt();
            System.out.println("请依次输入日：");
            int day = scanner.nextInt();
            int[] months = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
            if (yeas % 400 == 0 || yeas % 4 == 0 && yeas % 100 != 0) {
                months[1] = months[1] + 1;
            }
            int totalDay = 0;
            for (int i = 0; i < month - 1; i++) {
                totalDay = totalDay + months[i];
            }
            totalDay = totalDay + day;
            System.out.println("结果：" + totalDay);
        }
    }

    private static void flower() {
        // 水仙花    例如：121，214  --> 即  个十百 的三次方=数字
        for (int i = 100; i < 1000; i++) {
            // 个位
            int a = i % 10;
            int b = i / 10 % 10;
            //百位
            int c = i / 100 % 10;
            if ((a * a * a + b * b * b + c * c * c) == i) {
                System.out.println("水仙花==" + i);
            }
        }
    }

    public static long noDieRubbit(int n) {
        if (n <= 2) {
            System.out.println("输入错误！" + "\n" + "请输入一个大于2的数字！");
            return -1;
        }
        int[] arr = new int[n];
        arr[0] = 1;
        arr[1] = 1;
        for (int i = 2; i < arr.length; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr[arr.length - 1];
    }

    /**
     * 数组反转
     *
     * @param str
     */
    public static void reversal(int[] str) {
        int temp;
        for (int i = 0, j = str.length - 1; i < str.length / 2 && j >= 0; i++, j--) {
            temp = str[i];
            str[i] = str[j];
            str[j] = temp;
        }
    }

    /**
     * 打印数组
     *
     * @param str
     */
    public static void printArray(int[] str) {
        System.out.print("[");
        for (int i = 0; i < str.length; i++) {
            if (i == str.length - 1) {
                System.out.print(str[i]);
            } else {
                System.out.print(str[i] + ",");
            }
        }
        System.out.println("]");
    }

    /**
     * 需求:输入一个字符串,统计该字符串中每个字符出现的次数。
     */
    public static void testName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个字符串统计");
        String str = scanner.nextLine();
        char[] chars = str.toCharArray();
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < chars.length; i++) {
            Character c = chars[i];
            if (map.containsKey(c)) {
                map.put(chars[i], map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        System.out.println(map);

    }
}

