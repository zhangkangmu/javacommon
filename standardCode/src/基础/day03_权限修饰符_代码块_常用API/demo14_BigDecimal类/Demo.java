package 基础.day03_权限修饰符_代码块_常用API.demo14_BigDecimal类;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author 彭智林
 * @date 2017/12/18 15:11
 */
public class Demo {
    public static void main(String[] args) {
        /*
            BigDecimal类:
                1.包: java.math  需要导包
                2.概述:BigDecimal类提供了更加精准的数据计算方式
                3.构造方法:
                    BigDecimal(double val) 将double类型的数据封装为BigDecimal对象  忽略
                    BigDecimal(String val) 将 BigDecimal 的字符串表示形式转换为 BigDecimal  推荐

                    注意:推荐使用第二种方式，第一种存在精度问题

                4.成员方法:
                    public BigDecimal add(BigDecimal value) 加法运算
                    public BigDecimal subtract(BigDecimal value) 减法运算
                    public BigDecimal multiply(BigDecimal value) 乘法运算
                    public BigDecimal divide(BigDecimal value) 除法运算
                     double doubleValue()  将此 BigDecimal 转换为 double。
                注意：对于divide方法来说，如果除不尽的话，就会出现java.lang.ArithmeticException异常。
                此时可以使用divide方法的另一个重载方法:
                            BigDecimal divide(BigDecimal divisor, int scale, RoundingMode roundingMode):
                                            divisor：除数对应的BigDecimal对象；
                                            scale:精确的位数；
                                            roundingMode取舍模式
                              RoundingMode枚举: RoundingMode.HALF_UP 四舍五入

         */
        // 精度问题
        System.out.println(0.09 + 0.01);
        System.out.println(1.0 - 0.32);
        System.out.println(1.015 * 100);
        System.out.println(1.301 / 100);

        System.out.println("===============================");
        BigDecimal bg1 = new BigDecimal("0.09");
        BigDecimal bg2 = new BigDecimal("0.01");
        BigDecimal res1 = bg1.add(bg2);
        double d1 = res1.doubleValue();
        System.out.println("d1:"+d1);// d1: 0.1
        System.out.println("res1:"+res1);// res1:0.10


        System.out.println("===============================");
        BigDecimal bg3 = new BigDecimal("1.0");
        BigDecimal bg4 = new BigDecimal("0.32");
        BigDecimal res2 = bg3.subtract(bg4);
        System.out.println("res2:"+res2);// res2:0.68


        System.out.println("===============================");
        BigDecimal bg5 = new BigDecimal("1.015");
        BigDecimal bg6 = new BigDecimal("100");
        BigDecimal res3 = bg5.multiply(bg6);
        System.out.println("res3:"+res3);// res3:101.500


        System.out.println("===============================");
        // 除的尽
        BigDecimal bg7 = new BigDecimal("1.301");
        BigDecimal bg8 = new BigDecimal("100");
        BigDecimal res4 = bg7.divide(bg8);
        System.out.println("res4:"+res4);// res4:0.01301

        System.out.println("===============================");
        // 除不尽
        BigDecimal bg9 = new BigDecimal("10");
        BigDecimal bg10 = new BigDecimal("3");
        BigDecimal res5 = bg9.divide(bg10,3, RoundingMode.HALF_UP);
        System.out.println("res5:"+res5);// res5:3.333


    }
}
