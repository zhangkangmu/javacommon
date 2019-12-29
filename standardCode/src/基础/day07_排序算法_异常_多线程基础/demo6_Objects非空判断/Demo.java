package 基础.day07_排序算法_异常_多线程基础.demo6_Objects非空判断;

import java.util.Objects;

/**
 * @author 彭智林
 * @date 2019/12/24 11:17
 */
public class Demo {
    public static void main(String[] args) {
        /*
            Objects非空判断:
                public static <T> T requireNonNull(T obj) {
                    if (obj == null){
                        throw new NullPointerException();
                    }
                    return obj;
                }
         */
        Object obj = null;
        Object obj2 = Objects.requireNonNull(obj);
    }

    public static void method(Object obj){
        if(obj == null){

        }
    }
}
