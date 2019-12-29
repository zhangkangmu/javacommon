package 基础.day05_Collection_List_泛型_数据结构.demo8_定义和使用含有泛型的方法;

/**
 * @author 彭智林
 * @date 2019/12/21 10:53
 */
public class Demo {
    public static void main(String[] args) {
        /*
            定义和使用含有泛型的方法:
                定义含有泛型的方法:
                    修饰符 <T> 返回值类型 方法名(形参列表){
                        方法体
                    }

               使用含有泛型的方法:需要确定该方法中的泛型的具体数据类型
                                调用方法的时候确定泛型的具体数据类型
         */
        GenericMethodClass gm = new GenericMethodClass();
        gm.method();
        gm.method1();
        String str = gm.method2("jack");
        Integer i = gm.method2(100);
        System.out.println(str);
        System.out.println(i);
    }
}
