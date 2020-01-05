package 基础.day03_权限修饰符_代码块_常用API.demo13_System类;

import java.util.Date;

/**
 * @author 彭智林
 * @date 2017/12/18 14:47
 */
public class Demo {
    public static void main(String[] args) {
        /*
            System类:
                1.包:java.lang  不需要导包
                2.概述:
                    java.lang.System类中提供了大量的静态方法，可以获取与系统相关的信息或系统级操作。

                3.成员方法:
                    public   static void exit(int status) 终止当前运行的Java虚拟机，非零表示异常终止
                    public   static long currentTimeMillis() 返回当前时间(以毫秒为单位)
                    static void arraycopy(Object src, int srcPos, Object dest, int destPos, int length) 拷贝数组中的元素到另一个数组
                                         参数1src: 源数组
                                         参数2srcPos:源数组要拷贝的元素的起始索引(从哪个索引位置开始拷贝)
                                         参数3dest: 目标数组
                                         参数3destPos:目标数组接收拷贝元素的起始索引(从哪个索引位置开始接收)
                                         参数4length:需要拷贝多少个元素(拷贝多少个)
                Arrays类:包含了很多静态方法
                    static String toString(int[] arr) 把传入的数组转换为指定格式的字符串
         */
       /* System.out.println("Hello World!1");
        System.out.println("Hello World!2");
        // 结束程序运行
        System.exit(0);
        System.out.println("Hello World!3");*/


        System.out.println("==========================================");
        long time = System.currentTimeMillis();
        System.out.println("time:"+time);

        long time2 = new Date().getTime();
        System.out.println("time2:"+time2);

        System.out.println("==========================================");
        int[] src = {1,2,3,4,5,6,7};
        int[] dest = {10,20,30,40,50,60,70};

        // 需求:把src数组中的2,3,4拷贝到dest目标数组中,使得目标数组的元素为:{10,20,30,2,3,4,70};
        System.arraycopy(src,1,dest,3,3);

        // System.out.println("源数组:"+Arrays.toString(src));
        // System.out.println("目标数组:"+Arrays.toString(dest));
        for (int i = 0; i < dest.length; i++) {
            System.out.println(dest[i]);
        }

    }
}
