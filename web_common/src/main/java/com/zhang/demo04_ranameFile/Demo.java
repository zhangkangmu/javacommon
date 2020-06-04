package com.zhang.demo04_ranameFile;

import java.io.File;

/**
 * Created by zhangyuhong
 * Date:2020/6/5
 */
public class Demo {
    public static void main(String[] args) {

//        File folder = new File("J:\\程序\\java高级\\黑马头条项目 - 14天完整-VIP\\黑马头条_day12\\讲义\\media");
        File folder = new File("J:\\程序\\java高级\\黑马头条项目 - 14天完整-VIP\\黑马头条_day14\\笔记\\img");
        //获取该目录下所有文件的File数组
        File[] fileArray = folder.listFiles();
        for(File f : fileArray){
            String name = f.getName();
            int index = name.indexOf("【");
            int i = name.lastIndexOf(".");
            if (index!=-1&&i!=-01){
                String newName = name.substring(index,i);
                String replace = name.replace(newName, "");
                System.out.println(newName);
                File newFile = new File(folder,replace);
                f.renameTo(newFile);
            }
        }
    }
}
