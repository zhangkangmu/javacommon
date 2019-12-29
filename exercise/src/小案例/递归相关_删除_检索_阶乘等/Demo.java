package 小案例.递归相关_删除_检索_阶乘等;

import java.io.File;

/**
 * Created by zhangyuhong
 * Date:2019/12/28
 */
public class Demo {

    public static void main(String[] args) {
//        search(new File("H:\\javaProject\\javaCommonKnowledge\\exercise\\src\\hong"), ".txt");
        int a = calculateJieCheng(5);
        System.out.println(a);
    }

    /**
     * 递归求阶乘
     *
     * @param num
     * @return
     */
    private static int calculateJieCheng(int num) {
        if (num == 1) {
            return 1;
        }
        return calculateJieCheng(num - 1) * num;
    }


    /**
     * 搜索文件，以stringEnd结尾的
     *
     * @param file
     * @param stringEnd
     */
    public static void search(File file, String stringEnd) {
        File[] files = file.listFiles();
        for (File file1 : files) {
            if (file1.isFile() && file1.getName().endsWith(stringEnd)) {
                System.out.println(file1.getAbsolutePath());
            } else if (file1.isDirectory()) {
                search(file1, stringEnd);
            }
        }
    }

    /**
     * 递归删除
     *
     * @param file
     */
    public static void deleteAll(File file) {
        File[] files = file.listFiles();
        for (File file1 : files) {
            if (file1.isFile()) {
                file1.delete();
            }
            if (file1.isDirectory()) {
                deleteAll(file1);
                //从后往前看，倒数第二个执行到了这里就会忘后执行删除，然后执行完了代码才再往前走一步
                file1.delete();
            }
        }

    }
}
