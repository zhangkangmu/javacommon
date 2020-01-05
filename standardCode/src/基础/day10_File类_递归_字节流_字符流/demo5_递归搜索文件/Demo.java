package 基础.day10_File类_递归_字节流_字符流.demo5_递归搜索文件;

import java.io.File;

/**
 * @author 彭智林
 * @date 2017/12/28 11:06
 */
public class Demo {
    public static void main(String[] args) {
        /*
            递归搜索文件:
                练习:搜索G:\szitheima87\day10路径下的所有.java文件
                分析:
                    1.获取文件夹路径下的所有子文件和子文件夹
                    2.循环遍历获取的所有子文件和子文件夹
                    3.在循环中判断遍历出来的是文件还是文件夹
                    3.如果是文件,就判断后缀是否是.java,如果是,就打印输出
                    3.如果是文件夹,就递归
         */
        File file = new File("day10");
        findJavaFile(file);
    }

    public static void findJavaFile(File file){
       // 1.获取文件夹路径下的所有子文件和子文件夹
        File[] files = file.listFiles();

        // 2.循环遍历获取的所有子文件和子文件夹
        for (File file1 : files) {
            // 3.在循环中判断遍历出来的是文件还是文件夹
            // 3.如果是文件,就判断后缀是否是.java,如果是,就打印输出
            if(file1.isFile() && file1.getName().endsWith(".java")){
                System.out.println(file1);
            }
            // 3.如果是文件夹,就递归
            if(file1.isDirectory()){
                findJavaFile(file1);// 传入子文件夹路径的File对象
            }
        }
    }

}
