package 基础.day15_单例_多例_枚举_工厂模式.demo6_定义枚举和使用枚举;

/**
 * @author 彭智林
 * @date 2020/1/5 10:02
 */
public class Demo {
    public static void main(String[] args) {
        /*
            枚举:
                概述:枚举表示一种数据类型,但本质就是一个实现了多例模式的类,可以表示固定个数的类型
                格式:
                    public enum 枚举名{
                        // 第一行都是罗列枚举对象(枚举值),这些枚举实例直接写大写名字即可。
                        枚举值,枚举值,...;
                    }
                使用枚举: 枚举名.枚举值
         */
        // 取出Sex枚举中的值,并打印
        //实际上Sex.BOY就是new Sex("BOY");
        System.out.println(Sex.BOY);// BOY
        System.out.println(Sex.GIRL);// GIRL

        // 给Sex枚举类型的变量赋值
        Sex sex = Sex.BOY;
        System.out.println(sex);// BOY
    }
}
