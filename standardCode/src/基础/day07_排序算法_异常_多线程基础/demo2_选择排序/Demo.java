package 基础.day07_排序算法_异常_多线程基础.demo2_选择排序;

import java.util.Arrays;

/**
 * @author 彭智林
 * @date 2017/12/24 9:33
 */
public class Demo {
    public static void main(String[] args) {
        int[] arr = {45,25,35,55,15};
        // 选择排序
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i+1;j<arr.length;j++){
                if(arr[i] > arr[j]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        System.out.println("排序之后的数组:"+ Arrays.toString(arr));// 排序之后的数组:[15, 25, 35, 45, 55]
    }
}
