package 基础.day15_单例_多例_枚举_工厂模式.demo8_枚举的原理;

/**
 * @author 彭智林
 * @date 2018/1/5 10:16
 */
public class Demo {
    public static void main(String[] args) {
        /*
            枚举的原理:枚举本质就是一个实现了多例模式的类


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
