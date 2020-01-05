package 基础.day05_Collection_List_泛型_数据结构.demo7_定义和使用含有泛型的类;

/**
 * @author 彭智林
 * @date 2017/12/21 10:43
 */
public class GenericClass<E> {
    // 含有泛型的类:简称泛型类
    E e;// 成员变量

    // 成员方法
    public boolean add(E e){
        return true;
    }

    public E get(int index){

        return e;
    }

    public void method(int num){

    }

    public <T> T method2(T t){
        System.out.println("method2方法...."+t);
        return t;
    }
}
