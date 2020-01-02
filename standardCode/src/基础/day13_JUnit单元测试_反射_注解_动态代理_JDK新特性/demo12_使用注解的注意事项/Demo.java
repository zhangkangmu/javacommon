package 基础.day13_JUnit单元测试_反射_注解_动态代理_JDK新特性.demo12_使用注解的注意事项;

/**
 * @author 彭智林
 * @date 2020/1/2 14:59
 */
public class Demo {
    /*
        使用注解的注意事项:
            - 一旦注解有属性了,使用注解的时候,属性必须有值
            - 若属性类型是一维数组的时候,当数组的值只有一个的时候可以省略{}
            - 若属性名为value的时候,且只有这一个属性需要赋值的时候可以省略value【重点】
            - 注解属性可以有默认值  格式: 属性类型 属性名 default 默认值

     */
    @MyAnnotation(arr = {10,20,30,40})
    public void show(){

    }

//    @MyAnnotation(arr = {10})
    @MyAnnotation(arr = 10)
    public void show1(){

    }

//    @MyAnnotation2(value=10)
    @MyAnnotation2(10)
    public void show2(){

    }

    @MyAnnotation3(value = {10,20,30,40})
    public void show3(){

    }

//    @MyAnnotation3({10,20,30,40})
    @MyAnnotation3(10)
    public void show4(){

    }

    @MyAnnotation5
    public void show5(){

    }
}
