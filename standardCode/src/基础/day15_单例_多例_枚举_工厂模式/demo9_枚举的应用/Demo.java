package 基础.day15_单例_多例_枚举_工厂模式.demo9_枚举的应用;

/**
 * @author 彭智林
 * @date 2020/1/5 10:23
 */
public class Demo {
    public static void main(String[] args) {
        /*
            枚举的应用L
                枚举的作用：枚举通常可以用于做信息的分类，如性别，方向，季度等。
                 需求:定义表示性别，方向，季度的类型---->枚举类型
         */
        Person p1 = new Person("张三",Sex.BOY);
        Person p2 = new Person("张三",Sex.GIRL);
    }
}
