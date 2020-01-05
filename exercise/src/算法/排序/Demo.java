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
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 0; j < arr.length - i-1; j++) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
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
}
