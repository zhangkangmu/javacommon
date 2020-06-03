package 算法.排序;

import java.rmi.Remote;
import java.util.Arrays;

/**
 * Created by zhangyuhong
 * Date:2017/12/24
 */
public class Demo {


    public static void main(String[] args) {
        int[] arr = {25, 10, 32, 1, 50, 11, 8};
//        sort1(arr);
//        sort2(arr);
    }

    private static void sort2(int[] arr) {
        //冒泡排序
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    private static void sort1(int[] arr) {
        //顺序排序,从小到大
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    public static int[] sort3(int[] ins) {
//        https://blog.csdn.net/qq_28081081/article/details/80594386
        //插入排序--原理,去除当前的值,不断和前面的值比较,如果
        for (int i = 1; i < ins.length; i++) {
            int temp = ins[i];//保存每次需要插入的那个数
            int j;
            for (j = i; j > 0 && ins[j - 1] > temp; j--) {//这个较上面有一定的优化
                ins[j] = ins[j - 1];//吧大于需要插入的数往后移动。最后不大于temp的数就空出来j
            }
            ins[j] = temp;//将需要插入的数放入这个位置
        }
        return ins;
    }
}
