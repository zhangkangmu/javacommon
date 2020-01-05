package 基础.day03_权限修饰符_代码块_常用API.demo18_基本类型与字符串之间的转换;

/**
 * @author 彭智林
 * @date 2017/12/18 16:10
 */
public class Demo {
    public static void main(String[] args) {
        /*
            基本类型与字符串之间的转换:
                基本数据类型==============>字符串
                    第一种方式: 基本数据类型的数据 + ""
                    第二种方式: String类中的静态方法valueOf(XXX)方法
                字符串===================>基本数据类型
                    第一种方式: String--->包装类类型--->基本数据类型
                                String----->包装类类型: 除了Character,其他的每一个包装类中都有一个静态方法valueOf()来实现这个需求
                                包装类类型--->基本数据类型:每一个包装类中都一个XXXValue()方法来实现这个需求

                    第二种方式: 包装类类型中的parseXXX()方法解析成基本数据类型
                        除了Character类之外，其他所有包装类都具有parseXxx静态方法可以将字符串参数转换为对应的基本类型:
                         Byte类      - public static byte parseByte(String s)：将字符串参数转换为对应的byte基本类型。
                         Short类     - public static short parseShort(String s)：将字符串参数转换为对应的short基本类型。
                         Integer类   - public static int parseInt(String s)：将字符串参数转换为对应的int基本类型。
                         Long类      - public static long parseLong(String s)：将字符串参数转换为对应的long基本类型。
                         Float类     - public static float parseFloat(String s)：将字符串参数转换为对应的float基本类型。
                         Double类    - public static double parseDouble(String s)：将字符串参数转换为对应的double基本类型。
                         Boolean类   - public static boolean parseBoolean(String s)：将字符串参数转换为对应的boolean基本类型。
         */
        // 基本数据类型==============>字符串
        // 第一种方式: 基本数据类型的数据 + ""
        String str1 = 100 + "";// 掌握
        // 第二种方式: String类中的静态方法valueOf(XXX)方法
        String str2 = String.valueOf(100);

        // 字符串===================>基本数据类型
        // 第一种方式: String--->包装类类型--->基本数据类型
        // String--->包装类类型: 包装类中的静态方法valueOf(String str)
        Integer i = Integer.valueOf("1000");
        // 包装类类型-->基本数据类型: 包装类中的xxxValue()
        int num = i.intValue();

        // 以上合并
        int num1 = Integer.valueOf("1000");

        // 第二种方式:
        int num2 = Integer.parseInt("1000");// 掌握



    }
}
