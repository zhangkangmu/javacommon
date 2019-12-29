package 基础.day02_static_接口_多态_内部类.demo4_以后开发中static的应用;

/**
 * @author 彭智林
 * @date 2019/12/16 9:43
 */
public class Demo {
    public static void main(String[] args) {
        /*
            以后开发中static的应用:
                以后的项目中，通常会需要一些“全局变量”或者“全局的工具方法”，这些全局变量和方法，
                可以单独定义在一个类中，并声明为static(静态)的，可以很方便的通过类名访问
         */
        System.out.println("π的值:"+Utils.PI);

        int[] arr = {19,56,34,22,55,88,1};
        int max = Utils.getArrayMax(arr);
        System.out.println(max);
    }
}
