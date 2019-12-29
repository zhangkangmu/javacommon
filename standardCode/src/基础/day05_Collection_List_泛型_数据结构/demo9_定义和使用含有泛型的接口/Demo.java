package 基础.day05_Collection_List_泛型_数据结构.demo9_定义和使用含有泛型的接口;

/**
 * @author 彭智林
 * @date 2019/12/21 11:03
 */
public class Demo {
    public static void main(String[] args) {
        /*
            定义和使用含有泛型的接口:
                定义含有泛型的接口:
                    public interface 接口名<E>{

                    }

                使用含有泛型的接口:需要确定该接口的泛型的具体数据类型
                    1.在创建实现类实现接口的时候,确定泛型接口的泛型的具体数据类型
                        实现类的格式:
                            public class 类名 implements 泛型接口名<具体数据类型>{

                            }

                   2.在创建实现类实现接口的时候,始终不确定泛型接口的泛型的具体数据类型,
                     直到创建实现类对象的时候确定该泛型的具体数据类型
                        实现类的格式:
                             public class 类名<E> implements 泛型接口名<E>{

                            }
         */
        Imp2<Integer> imp2 = new Imp2<>();
        imp2.method1(1000);

        Imp2<String> imp3 = new Imp2<>();
        imp3.method1("itheima");
    }
}
