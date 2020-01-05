package 基础.day05_Collection_List_泛型_数据结构.demo9_定义和使用含有泛型的接口;

/**
 * @author 彭智林
 * @date 2017/12/21 11:04
 */
public interface GenericInterface<E> {

    public abstract void method1(E e);

    default E method2(E e){
        return e;
    }

}
