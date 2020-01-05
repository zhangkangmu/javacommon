package 基础.day07_排序算法_异常_多线程基础.demo3_二分查找;

/**
 * @author 彭智林
 * @date 2017/12/24 10:14
 */
public class Demo {
    public static void main(String[] args) {
        int[] arr = {6, 16, 26, 36, 46, 56, 76, 86};

        // 1.定义一个变量,用来存储要查找的值
        int num = 26;
        int index = method01(arr, num);
        if(index == -1){
            System.out.println("没有找到");
        }else{
            System.out.println("找到了,索引为:"+index);
        }

    }

    private static int method01(int[] arr, int num) {
        // 2.定义一个变量,用来存储左索引,初始值为0
        int left = 0;

        // 3.定义一个变量,用来存储右索引,初始值为arr.length-1
        int right = arr.length - 1;

        // 4.使用while循环,循环比较,循环结束的条件:右索引<左索引
        while (right >= left) {
            // 5.在循环中,计算中间索引的值,定义一个变量存储起来
            int mid = (left + right) / 2;
            // 6.在循环中,取出中间索引对应的元素
            int midElement = arr[mid];
            // 7.比较中间索引对应的元素与要查找的值
            if (midElement > num) {
                // 7.如果中间索引对应的元素大于要查找的值,就重置右索引的值(中间索引-1)
                right = mid - 1;
            } else if (midElement < num) {
                // 7.如果中间索引对应的元素小于要查找的值,就重置左索引的值(中间索引+1)
                left = mid + 1;
            } else {
                // 7.如果中间索引对应的元素等于要查找的值,说明找到了

                return mid;
            }
        }
        return -1;
    }
}
