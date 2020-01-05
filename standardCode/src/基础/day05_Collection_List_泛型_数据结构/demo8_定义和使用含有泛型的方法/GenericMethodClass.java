package 基础.day05_Collection_List_泛型_数据结构.demo8_定义和使用含有泛型的方法;

/**
 * @author 彭智林
 * @date 2017/12/21 10:54
 */
public class GenericMethodClass {

    // 定义含有泛型的方法
    public  void method(){
        System.out.println("method方法");
    }

    public <T> void method1(){
        System.out.println("method1方法");
    }

    public <T> T method2(T t){
        System.out.println("method2方法...."+t);
        return t;
    }
}
