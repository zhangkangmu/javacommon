package 基础.day10_File类_递归_字节流_字符流.demo3_递归计算累加和;

/**
 * @author 彭智林
 * @date 2019/12/28 10:45
 */
public class Demo {
    public static void main(String[] args) {
        /*
            递归计算累加和:
                分析:定义一个方法来计算累加和
                    1的累加和 = 1
                    2的累加和 = 1 + 2
                    3的累加和 = 1 + 2 + 3
                    4的累加和 = 1 + 2 + 3 + 4
                    ....
                    数的累加和 = (上一个数的累加和) + 这个数  格式: num =  (num-1)的累加和 + num
         */
        System.out.println(getSum(5));// 15
    }

    /**
     * 计算一个数的累加和
     * @param n
     * @return
     */
    public static int getSum(int n){
        if(n == 1){
            return 1;
        }
        return getSum(n-1) + n;
    }
}
