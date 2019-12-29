package 基础.day02_static_接口_多态_内部类.demo9_接口的多继承;

/**
 * @author 彭智林
 * @date 2019/12/16 10:59
 */
public class Demo {
    public static void main(String[] args) {
        /*
            接口和接口之间的关系:单继承,多层继承,多继承
            接口的多继承:
                格式:
                    public interface 接口名 extends 父接口名1,父接口名2,...{

                    }

                多继承接口中成员的使用:
                    如果一个接口的多个父接口中有同名的默认方法,那么子接口必须重写该默认方法,重写的默认方法必须加default

                总结:
                    实现类重写接口中的默认方法,不需要加default
                    子接口重写父接口中的默认方法,必须加default

         */
    }
}
