package 基础.day10_File类_递归_字节流_字符流.demo4_递归求阶乘;

/**
 * @author 彭智林
 * @date 2017/12/28 11:02
 */
public class Demo {
    public static void main(String[] args) {
        /*
            递归求阶乘:
                分析: n的阶乘：n! = n * (n-1) *...* 3 * 2 * 1
                例如:
                    1! = 1
                    2! = 2 * 1
                    3! = 3 * 2 * 1
                    4! = 4 * 3 * 2 * 1
                    5! = 5 * 4 * 3 * 2 * 1
                    ...
                    n! = n * (n-1)!
         */
        System.out.println(jieCheng(5));// 120
    }

    public static int jieCheng(int n){
        if(n == 1){
            return 1;
        }
        return n * jieCheng(n-1);
    }
}
