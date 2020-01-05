package 基础.day02_static_接口_多态_内部类.demo17_引用类型的转型;

/**
 * @author 彭智林
 * @date 2017/12/16 14:44
 */
public class Demo {
    public static void main(String[] args) {
        /*
            基本类型转换:
                自动类型转换:把取值范围小的类型 自动转换为 取值范围大的类型
                            格式: 取值范围大的类型 变量名 = 取值范围小的类型的数据;
                            例如: long numL = 10;

                强制类型转换:把取值范围大的类型 强制转换为 取值范围小的类型
                            格式: 取值范围小的类型 变量名 = (取值范围小的类型)取值范围大的类型的变量;
                            例如: int num = (int)100L;   int num = (int)3.14;

             引用类型转换:---->父子类关系 或者  实现类关系
                向上转型: 子类类型向父类类型向上转换的过程，这个过程是自动的。
                        格式: 父类类型 变量名 = 子类对象;
                        例如: Animal anl = new  Dog();   Dog是Animal类的子类

                向下转型: 父类类型向子类类型向下转换的过程，这个过程是强制的。
                        格式: 子类类型 变量名 = (子类类型)父类类型的变量;
                        例如: Dog dog = (Dog)anl;   anl是Animal类型
          */
        // 类类型的转型
        // 向上转型:
        Animal anl = new Dog();

        // 向下转型:
        Dog dog = (Dog) anl;

        // 接口类型的转型
        // 向上转型:
        AInterface a = new AImp();

        // 向下转型:
        AImp aImp = (AImp) a;


        // 创建Person对象
        Person p = new Person();
        // 把p的Person类型转换为Student类型 向下转型
        Student stu = (Student) p;


        Person p2 = new Student();// 向上转型

    }
}
