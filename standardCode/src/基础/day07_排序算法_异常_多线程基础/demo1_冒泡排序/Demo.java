package 基础.day07_排序算法_异常_多线程基础.demo1_冒泡排序;

import java.util.Arrays;

/**
 * @author 彭智林
 * @date 2019/12/23 18:23
 */
public class Demo {
    public static void main(String[] args) {
        int[] arr = {45,25,35,55,15};

        // 冒泡排序
        for (int i = 0; i < arr.length - 1; i++) {
            for(int j = 0;j<arr.length-1-i;j++){
                // 比较arr[j] arr[j+1)
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        System.out.println("排序之后的数组:"+ Arrays.toString(arr));// 排序之后的数组:[15, 25, 35, 45, 55]
    }
}
