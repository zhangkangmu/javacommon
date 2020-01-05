package 基础.day05_Collection_List_泛型_数据结构.demo7_定义和使用含有泛型的类;

/**
 * @author 彭智林
 * @date 2017/12/21 10:41
 */
public class Demo {
    public static void main(String[] args) {
        /*
            定义和使用含有泛型的类:
                定义含有泛型的类:
                    public class 类名<E>{

                    }

                    泛型里面的E这个位置可以是任意字母

               使用含有泛型的类:需要确定泛型的具体数据类型
                              创建对象的时候确定泛型的具体的数据类型
         */
        // 创建GenericClass类的对象
        GenericClass<String> gc = new GenericClass<>();
        gc.add("jack");
        gc.add("rose");

        gc.e = "jim";
        String e = gc.get(0);

        System.out.println("===============================");
        GenericClass<Integer> gc2 = new GenericClass<>();
        gc2.add(100);
        gc2.add(200);

        gc2.e = 1000;
        Integer i = gc2.get(0);

    }
}
