package 基础.day03_权限修饰符_代码块_常用API.demo17_装箱与拆箱;

/**
 * @author 彭智林
 * @date 2017/12/18 16:01
 */
public class Demo {
    public static void main(String[] args) {
        /*
            装箱与拆箱:
                - 装箱：从基本类型转换为对应的包装类对象。
                - 拆箱：从包装类对象转换为对应的基本类型

            自动装箱与自动拆箱:
                自动装箱: 系统自动 把基本数据类型 转换为对应的 包装类对象
                自动拆箱: 系统自动 把包装类对象转 换为对应的 基本数据类型

         */
        // int类型  ===========> Integer 类型    手动装箱
        // 通过构造方法:
        Integer i1 = new Integer(100);
        Integer i2 = new Integer("100");

        Integer i3 = Integer.valueOf(100);
        Integer i4 = Integer.valueOf("100");


        // Integer类型 =========> int类型    手动拆箱
        int num1 = i1.intValue();


        System.out.println("====================================================");

        // int类型  ===========> Integer 类型    自动装箱
        // 左边Integer包装类类型,右边是int类型
        Integer i5 = 100;


        // Integer类型 =========> int类型    自动拆箱
        // 左边是int类型,右边是Integer包装类类型
        int num2 = i5;


        Double d1 = 3.14;// 自动装箱
        double d11 = d1;//  自动拆箱


    }
}
