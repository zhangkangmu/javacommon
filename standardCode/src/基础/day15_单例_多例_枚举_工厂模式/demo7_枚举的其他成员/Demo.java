package 基础.day15_单例_多例_枚举_工厂模式.demo7_枚举的其他成员;

/**
 * @author 彭智林
 * @date 2020/1/5 10:09
 */
public class Demo {
    public static void main(String[] args) {
        /*
            枚举的其他成员:
                由于枚举是一种数据类型,本质其实是一个实现了多例模式的类,
                既然是类,就应该还有成员变量和成员方法,构造方法
         */
        // 取出Sex枚举中的值,并打印
        System.out.println(Sex.BOY);// BOY
        System.out.println(Sex.GIRL);// GIRL

        // 给Sex枚举类型的变量赋值
        Sex sex = Sex.BOY;
        System.out.println(sex);// BOY
    }
}
