package 基础.day02_static_接口_多态_内部类.demo4_以后开发中static的应用;

/**
 * @author 彭智林
 * @date 2019/12/16 9:46
 */
public class Utils {

    public static final double PI = 3.14;


    // 找int数组中的最大值
    public static int getArrayMax(int[] arr){
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] > max){
                max = arr[i];
            }
        }
        return max;
    }

}
