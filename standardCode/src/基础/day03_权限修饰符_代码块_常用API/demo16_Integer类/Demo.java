package 基础.day03_权限修饰符_代码块_常用API.demo16_Integer类;

/**
 * @author 彭智林
 * @date 2017/12/18 15:53
 */
public class Demo {
    public static void main(String[] args) {
        // 基本数据类型  <===========> 包装类类型
        // Integer类:
        /*
            public Integer(int   value)  根据 int 值创建 Integer 对象(过时)
            public Integer(String s) 根据 String 值创建 Integer 对象(过时)

            public static Integer valueOf(int i)  返回表示指定的 int 值的 Integer   实例
            public static Integer valueOf(String s) 返回保存指定String值的 Integer 对象
             int intValue()  以 int 类型返回该 Integer 的值
         */
        // int类型  ===========> Integer 类型
        // 通过构造方法:
        Integer i1 = new Integer(100);
        Integer i2 = new Integer("100");

        Integer i3 = Integer.valueOf(100);
        Integer i4 = Integer.valueOf("100");


        // Integer类型 =========> int类型
        int num1 = i1.intValue();


    }
}
