package 基础.day14_正则表达式.demo7_正则表达式的基本使用;

/**
 * @author 彭智林
 * @date 2020/1/3 14:52
 */
public class Demo {
    public static void main(String[] args) {
        /*
            正则表达式的基本使用: 正则表达式的组成元素
                - 正则表达式-字符类
                - 正则表达式-逻辑运算符
                - 正则表达式-预定义字符
                - 正则表达式-数量词
                - 正则表达式-分组括号

            - 正则表达式-字符类:
                0. [abc]：代表a或者b，或者c字符中的一个。
                1. [^abc]：代表除a,b,c以外的任何字符。
                2. [a-z]：代表a-z的所有小写字符中的一个。
                3. [A-Z]：代表A-Z的所有大写字符中的一个。
                4. [0-9]：代表0-9之间的某一个数字字符。
                5. [a-zA-Z0-9]：代表a-z或者A-Z或者0-9之间的任意一个字符。
                6. [a-dm-p]：a 到 d 或 m 到 p之间的任意一个字符。

            - 正则表达式-逻辑运算符
                1. &&：并且
                2. | ：或者

            -  正则表达式-预定义字符
                1. "." ： 匹配任何字符。如果要表示一个字符点,那么就得使用\.
                2. "\d"：任何数字[0-9]的简写；
                3. "\D"：任何非数字[^0-9]的简写；
                4. "\s"： 空白字符：[ \t\n\x0B\f\r] 的简写
                5. "\S"： 非空白字符：[^\s] 的简写
                6. "\w"：单词字符：[a-zA-Z_0-9]的简写
                7. "\W"：非单词字符：[^\w]

            -正则表达式-数量词
                  1. X? : 0次或1次
                  2. X* : 0次到多次   >=0
                  3. X+ : 1次或多次   >=1
                  4. X{n} : 恰好n次
                  5. X{n,} : 至少n次
                  6. X{n,m}: n到m次(n和m都是包含的)

            - 正则表达式-分组括号( )
         */
        // 验证小数: 3.14,0.25,12.34,-3.14,3.5,1.0 ,301.23    错误: 00.123,01.23  .123  123.
        System.out.println("3.14".matches("[-]?([1-9]\\d*|[0]{1})(\\.\\d+)"));// true
        System.out.println("0.25".matches("[-]?([1-9]\\d*|[0]{1})(\\.\\d+)"));// true
        System.out.println("12.34".matches("[-]?([1-9]\\d*|[0]{1})(\\.\\d+)"));// true
        System.out.println("-3.14".matches("[-]?([1-9]\\d*|[0]{1})(\\.\\d+)"));// true
        System.out.println("3.5".matches("[-]?([1-9]\\d*|[0]{1})(\\.\\d+)"));// true
        System.out.println("1.0".matches("[-]?([1-9]\\d*|[0]{1})(\\.\\d+)"));// true
        System.out.println("301.23".matches("[-]?([1-9]\\d*|[0]{1})(\\.\\d+)"));// true
        System.out.println("00.123".matches("[-]?([1-9]\\d*|[0]{1})(\\.\\d+)"));// false
        System.out.println("01.23".matches("[-]?([1-9]\\d*|[0]{1})(\\.\\d+)"));// false
        System.out.println(".123".matches("[-]?([1-9]\\d*|[0]{1})(\\.\\d+)"));// false
        System.out.println("123.".matches("[-]?([1-9]\\d*|[0]{1})(\\.\\d+)"));// false



    }

    /**
     * 正则表达式-分组括号( )
     */
    private static void method05() {
        String str = "DG8FV-B9TKY-FRT9J-99899-XPQ4G";
        //验证这个序列号：分为5组，每组之间使用-隔开，每组由5位A-Z或者0-9的字符组成
        System.out.println(str.matches("([A-Z0-9]{5}-){4}([A-Z0-9]{5})"));// true
    }

    /**
     * -正则表达式-数量词
     */
    private static void method04() {
        //1.验证字符串是否是三位数字
        System.out.println("258".matches("\\d{3}"));// true
        System.out.println("2568".matches("\\d{3}"));// false
        System.out.println("a68".matches("\\d{3}"));// false
        System.out.println("==============================================");

        //2.验证字符串是否是多位数字
        System.out.println("".matches("\\d+"));// false
        System.out.println("1".matches("\\d+"));// true
        System.out.println("12".matches("\\d+"));// true
        System.out.println("123".matches("\\d+"));// true
        System.out.println("12a".matches("\\d+"));// false
        System.out.println("==============================================");

        //3.验证字符串是否是手机号：
        System.out.println("13539540666".matches("1[35789]\\d{9}"));// true
        System.out.println("135395406669".matches("1[35789]\\d{9}"));// false
        System.out.println("14539540666".matches("1[35789]\\d{9}"));// false
        System.out.println("25539540666".matches("1[35789]\\d{9}"));// false
        System.out.println("==============================================");


        //4.验证小数:必须出现小数点，但是只能出现1次   xxx.xxx   真正小数的正则表达式待会再写
        System.out.println("00.123".matches("\\d+\\.{1}\\d+")); // true
        System.out.println("00.00".matches("\\d+\\.{1}\\d+")); // true
        System.out.println("01.00".matches("\\d+\\.{1}\\d+")); // true
        System.out.println("10.00".matches("\\d+\\.{1}\\d+")); // true
        System.out.println("10.a0".matches("\\d+\\.{1}\\d+")); // false
        System.out.println(".10".matches("\\d+\\.{1}\\d+")); // false
        System.out.println("12.".matches("\\d+\\.{1}\\d+")); // false
        System.out.println("==============================================");

        //5.验证小数：小数点可以不出现，也可以出现1次
        System.out.println("0.123".matches("\\d+\\.?\\d+"));// true
        System.out.println("123.9".matches("\\d+\\.?\\d+"));// true
        System.out.println("1239".matches("\\d+\\.?\\d+"));// true
        System.out.println("123..9".matches("\\d+\\.?\\d+"));// false
        System.out.println("123.9a".matches("\\d+\\.?\\d+"));// false
        System.out.println("==============================================");

        //6.验证小数：要求匹配：3、3.、3.14、+3.14、-3.、4、45.34、....
        System.out.println("3".matches("[+-]?\\d+\\.?\\d*"));// true
        System.out.println("3.".matches("[+-]?\\d+\\.?\\d*"));// true
        System.out.println("3.14".matches("[+-]?\\d+\\.?\\d*"));// true
        System.out.println("+3.14".matches("[+-]?\\d+\\.?\\d*"));// true
        System.out.println("-3.".matches("[+-]?\\d+\\.?\\d*"));// true
        System.out.println("4".matches("[+-]?\\d+\\.?\\d*"));// true
        System.out.println("45.34".matches("[+-]?\\d+\\.?\\d*"));// true
        System.out.println(".43".matches("[+-]?\\d+\\.?\\d*"));// false
        System.out.println("43.a".matches("[+-]?\\d+\\.?\\d*"));// false
        System.out.println("==============================================");


        //7.验证qq号码：1).5--15位；2).全部是数字;3).第一位不是0
        System.out.println("10000".matches("[1-9]\\d{4,14}"));// true
        System.out.println("10000a".matches("[1-9]\\d{4,14}"));// false
        System.out.println("010000".matches("[1-9]\\d{4,14}"));// false
        System.out.println("1234567890123456".matches("[1-9]\\d{4,14}"));// false
        System.out.println("==============================================");


        // 8.验证字符串是否为至少5个数字
        System.out.println("12345".matches("\\d{5,}"));// true
        System.out.println("123456".matches("\\d{5,}"));// true
        System.out.println("1234".matches("\\d{5,}"));// false
    }

    /**
     * 正则表达式-预定义字符
     */
    private static void method03() {
        String str = "258";
        //1.验证str是否是3位数字
        System.out.println(str.matches("\\d\\d\\d"));// true
        System.out.println("2568".matches("\\d\\d\\d"));// false
        System.out.println("a68".matches("\\d\\d\\d"));// false
        System.out.println("==============================================");

        //2.验证手机号：1开头，第二位：3/5/8，剩下9位都是0-9的数字
        System.out.println(str.matches("1[358]\\d\\d\\d\\d\\d\\d\\d\\d\\d"));// false
        System.out.println("13838386668".matches("1[358]\\d\\d\\d\\d\\d\\d\\d\\d\\d"));// true
        System.out.println("14838386668".matches("1[358]\\d\\d\\d\\d\\d\\d\\d\\d\\d"));// false
        System.out.println("25838386668".matches("1[358]\\d\\d\\d\\d\\d\\d\\d\\d\\d"));// false
        System.out.println("158738386668".matches("1[358]\\d\\d\\d\\d\\d\\d\\d\\d\\d"));// false
        System.out.println("==============================================");

        //3.验证字符串是否以h开头，以d结尾，中间是任何字符
        System.out.println(str.matches("h.d"));// false
        System.out.println("had".matches("h.d"));// true
        System.out.println("h%d".matches("h.d"));// true
        System.out.println("h*d".matches("h.d"));// true
        System.out.println("==============================================");

        //4.验证str是否是：had.
        System.out.println(str.matches("had\\."));// false
        System.out.println("had.".matches("had\\."));// true
        System.out.println("had..".matches("had\\."));// false
        System.out.println("hadz".matches("had\\."));// false

        /*String str = "java.itheima.itcast";
        String[] arr = str.split("\\.");
        System.out.println(arr.length);// 3*/
    }

    /**
     * 正则表达式-逻辑运算符
     */
    private static void method02() {
        String str = "had";
        // 1.要求字符串是小写辅音字符开头，后跟ad  除了a,e,i,o,u之外,其他的都是辅音字母
        System.out.println(str.matches("[a-z&&[^aeiou]]ad"));// true
        System.out.println("aad".matches("[a-z&&[^aeiou]]ad"));// false
        System.out.println("aead".matches("[a-z&&[^aeiou]]ad"));// false

        System.out.println("===============================================");
        // 2.要求字符串是aeiou中的某个字符开头，后跟ad
        System.out.println(str.matches("[aeiou]ad"));// false
        System.out.println(str.matches("[a|e|i|o|u]ad"));// false
        System.out.println("ead".matches("[a|e|i|o|u]ad"));// true
    }

    /**
     * 正则表达式-字符类:
     */
    private static void method01() {
        // 正则表达式-字符类:
        String str = "ead";

        //1.验证str是否以h开头，以d结尾，中间是a,e,i,o,u中某个字符
        System.out.println(str.matches("h[aeiou]d"));// false
        System.out.println("hzd".matches("h[aeiou]d"));// false
        System.out.println("haed".matches("h[aeiou]d"));// false
        System.out.println("hed".matches("h[aeiou]d"));// true

        System.out.println("===============================================");
        //2.验证str是否以h开头，以d结尾，中间不是a,e,i,o,u中的某个字符
        System.out.println(str.matches("h[^aeiou]d"));// false
        System.out.println("hzd".matches("h[^aeiou]d"));// true
        System.out.println("haed".matches("h[^aeiou]d"));// false
        System.out.println("hed".matches("h[^aeiou]d"));// false

        //3.验证str是否是a-z的任何一个小写字符开头，后跟ad
        System.out.println("===============================================");
        System.out.println(str.matches("[a-z]ad"));// true
        System.out.println("aead".matches("[a-z]ad"));// false
        System.out.println("Aad".matches("[a-z]ad"));// false

        System.out.println("===============================================");
        //4.验证str是否以a-d或者m-p之间某个字符开头，后跟ad
        System.out.println(str.matches("[a-dm-p]ad"));// false
        System.out.println("aad".matches("[a-dm-p]ad"));// true
        System.out.println("jad".matches("[a-dm-p]ad"));// false
        System.out.println("nad".matches("[a-dm-p]ad"));// true
    }
}
