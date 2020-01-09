package 基础.day15_单例_多例_枚举_工厂模式.demo5_多例模式的应用;

/**
 * @author 彭智林
 * @date 2018/1/5 9:51
 */
public class Demo {
    public static void main(String[] args) {
        /*
            需求: 当一个方法的参数想要接收一个性别,所以参数类型得为性别类型
            分析:
                1.性别类型应该定义为一个性别类
                2.由于性别只有男和女,所以性别类只能有2个对象
         */
        System.out.println(Sex.BOY);
        System.out.println(Sex.BOY);
        System.out.println(Sex.BOY);
        System.out.println(Sex.GIRL);
        System.out.println(Sex.GIRL);
        System.out.println(Sex.GIRL);


        getSex(Sex.BOY);
        getSex(Sex.GIRL);
    }

    public static void getSex(Sex sex){

    }
}
