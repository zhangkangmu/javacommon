package 基础.day10_File类_递归_字节流_字符流.demo2_递归的概述和执行流程;

/**
 * @author 彭智林
 * @date 2017/12/28 10:20
 */
public class Demo {

    static int count = 0;

    public static void main(String[] args) {
        /*
            递归的概述和执行流程:
                概述:指在当前方法内调用自己的这种现象。
                例如:   public static void method(){
                            method();
                        }
                分析递归的执行流程: 方法一旦调用就会加载进栈,必须等方法中所有的代码都执行完毕才能弹栈
                使用递归:
                    1.一定要设置出口,否则会栈内存溢出错误StackOverflowError
                    2.设置的出口不能太晚,否则也会出现栈内存溢出错误StackOverflowError

                出口,规律:
                    出口: 避免栈内存溢出错误(合理递归)
                    规律: 确定什么时候去递归

                    递归就是函数不断调用自身，会占用更多栈内存空间，效率比循环低；
         */
        method();
    }

    public static void method(){
        if(count > 15000){
            return;
        }
        count++;
        System.out.println("count:"+count);
        method();
    }
}
