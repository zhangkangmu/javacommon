package 基础.day03_权限修饰符_代码块_常用API.demo1_访问权限;

/**
 * @author 彭智林
 * @date 2019/12/18 8:51
 */
public class Demo {
    public static void main(String[] args) {
        /*
            访问权限:
                在Java中提供了四种访问权限，使用不同的访问权限修饰符修饰时，被修饰的内容会有不同的访问权限
                public: 公共的
                protected: 受保护的
                default: 默认的
                private: 私有的
            不同权限的访问能力:
                                         private        default(默认)         protected           public
                同一个类                   true             true                true                true
                同一个包(无关类和父子类)     false           true                 true                true
                不同包的父子类             false            false                true                true
                不同包的无关类             false            false                false               true

            四种访问权限可以修饰成员变量,成员方法,构造方法,类
            修饰类的权限修饰符: public  default(默认)      一般修饰类使用public
            修饰成员变量: public private protected 默认   一般修饰成员变量使用private
            修饰成员方法: public private protected 默认   一般修饰成员方法使用public
            修饰构造方法: public private protected 默认   一般修饰成员方法使用public

         */
        Person p = new Person();
        System.out.println(p.name);
    }
}
