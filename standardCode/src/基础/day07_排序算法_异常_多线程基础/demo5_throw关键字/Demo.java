package 基础.day07_排序算法_异常_多线程基础.demo5_throw关键字;

/**
 * @author 彭智林
 * @date 2017/12/24 11:06
 */
public class Demo {
    public static void main(String[] args) {
        /*
            throw关键字:
                概述: 在java中，提供了一个throw关键字，它用来抛出一个指定的异常对象
                格式: throw new 异常类名(参数);
                使用: throw用在方法内，用来抛出一个异常对象，将这个异常对象传递到调用者处，并结束当前方法的执行。

         */
        int[] arr = {10, 20, 30, 40};
        getArrayElement(arr, 4);

    }

    public static void getArrayElement(int[] arr, int index) {
        if(index < 0 || index > arr.length-1){
            // 说明索引不存在,出现了数组索引越界异常,创建异常对象,并抛出异常对象,传递给调用者
            throw new ArrayIndexOutOfBoundsException(index+"");
        }
        int element = arr[index];
        System.out.println("索引为" + index + "的元素是:" + element);
    }
}
