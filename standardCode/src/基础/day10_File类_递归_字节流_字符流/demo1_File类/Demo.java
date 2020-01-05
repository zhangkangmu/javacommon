package 基础.day10_File类_递归_字节流_字符流.demo1_File类;

import java.io.File;
import java.io.IOException;

/**
 * @author 彭智林
 * @date 2017/12/28 8:40
 */
public class Demo {
    public static void main(String[] args) throws IOException {
        /*
            File类:
                1.包  java.io 需要导包
                2.概述:
                    java.io.File 类是文件和目录路径名的抽象表示，主要用于文件和目录的创建、查找和删除等操作。
                3.构造方法
                    - public File(String pathname) ：通过将给定的路径名字符串转换为抽象路径名来创建新的 File实例。
                    - public File(String parent, String child) ：从父路径名字符串和子路径名字符串创建新的 File实例。
                    - public File(File parent, String child) ：从父抽象路径名和子路径名字符串创建新的 File实例。
                    注意:无论该路径下是否存在文件或者目录，都不影响File对象的创建。

                4.绝对路径和相对路径
                    - 绝对路径：从符盘开始的路径，这是一个完整的路径。
                    - 相对路径：相对于项目目录的路径，这是一个便捷的路径，开发中经常使用。
                    例如:表示项目中的a.txt文件的路径
                    绝对路径: G:\szitheima87\day10\aaa\a.txt
                    相对路径: day10\aaa\a.txt

                    例如: 你女朋友在楼下的喜士多,你在2-A楼402教室
                    绝对路径: 中国广东省深圳市宝安区留仙二路庭威工业园2-A楼402教室
                    相对路径: 2-A楼402教室

                5.成员方法
                    获取功能的方法
                        - public String getAbsolutePath() ：返回此File的绝对路径名字符串。
                        - public String getPath() ：获取的是构造路径(创建该File对象使用的路径)
                        - public String getName()  ：返回由此File表示的文件或目录的名称。
                        - public long length()  ：返回由此File表示的文件的字节大小。注意不能获取文件夹的字节大小
                    判断功能的方法
                        - public boolean exists() ：此File表示的文件或目录是否实际存在。
                        - public boolean isDirectory() ：此File表示的是否为目录。
                        - public boolean isFile() ：此File表示的是否为文件。
                    创建删除功能的方法
                        - public boolean createNewFile() ：当且仅当具有该名称的文件尚不存在时，创建一个新的空文件。
                        - public boolean delete() ：删除由此File表示的文件或目录。注意不能删除非空文件夹,只能删除空文件夹和文件
                        - public boolean mkdir() ：创建由此File表示的目录。
                        - public boolean mkdirs() ：创建由此File表示的目录，包括任何必需但不存在的父目录。
                   目录遍历的方法
                        - public String[] list() ：返回一个String数组，表示该File目录中的所有子文件或目录。
                        - public File[] listFiles() ：返回一个File数组，表示该File目录中的所有的子文件或目录。
                    注意:调用listFiles方法的File对象，表示的必须是实际存在的目录，否则返回null，无法进行遍历。
                    注意:调用listFiles方法的File对象，表示的目录如果没有访问权限，就会返回null，无法进行遍历。
         */
        //  public String[] list(): 返回字符串数组,获取一个目录下的所有子文件和子目录的名称
        // 创建一个File对象,表示day10目录路径
        File file1 = new File("day10");
        // 使用File对象调用list()方法,获取所有的子文件和子目录
        String[] arr1 = file1.list();
        // 遍历所有的子文件和子目录的数组,打印输出
        for (String e : arr1) {
            System.out.println(e);
        }

        System.out.println("======================================================");
        // public File[] listFiles():返回File数组,获取一个目录下的所有字文件和子目录路径的File对象
        // 创建一个File对象,表示day10目录路径
        File file2 = new File("day10");//
        // 使用File对象调用listFiles()方法,获取所有的子文件和子目录
        File[] arr2 = file2.listFiles();
        // 遍历所有的子文件和子目录的数组,打印输出
        for (File file : arr2) {
            System.out.println(file);
        }


        System.out.println("======================================================");
        // 注意:调用listFiles方法的File对象，表示的必须是实际存在的目录，否则返回null，无法进行遍历。
        /*// 创建一个File对象,表示day100目录路径
        File file3 = new File("day100");
        // 使用File对象调用listFiles()方法,获取所有的子文件和子目录
        File[] arr3 = file3.listFiles();// null
        // 遍历所有的子文件和子目录的数组,打印输出
        for (File file : arr3) {
            System.out.println(file);
        }*/


        System.out.println("======================================================");
        // 注意:调用listFiles方法的File对象，表示的目录如果没有访问权限，就会返回null，无法进行遍历。
        /*// 创建一个File对象,表示C:\System Volume Information目录路径
        File file4 = new File("C:\\System Volume Information");// 该路径是没有访问权限
        // 使用File对象调用listFiles()方法,获取所有的子文件和子目录
        File[] arr4 = file4.listFiles();// null
        // 遍历所有的子文件和子目录的数组,打印输出
        for (File file : arr4) {
            System.out.println(file);
        }*/


    }

    /**
     * 创建删除功能的方法
     */
    private static void method04() {
        // public boolean createNewFile(): 当且仅当该文件不存在的时候,才会创建一个新的空文件
        // 创建一个File对象,表示一个实际不存在的文件路径
       /* File file1 = new File("day10\\ccc\\a.txt");
        boolean flag1 = file1.createNewFile();
        System.out.println("flag1:"+flag1);// flag1:true*/

       /* File file2 = new File("day10\\ccc\\bbb");
        boolean flag2 = file2.createNewFile();
        System.out.println("flag2:"+flag2);// flag2:true*/


        // public boolean delete() ：删除由此File表示的文件或目录。
        // 删除文件  删除ccc文件夹下的bbb文件
        /*File file3 = new File("day10\\ccc\\bbb");
        boolean flag3 = file3.delete();
        System.out.println("flag3:"+flag3);// true*/

        // 删除文件夹 删除day10下面的ccc文件夹
        /*File file4 = new File("day10\\ccc");
        boolean flag4 = file4.delete();
        System.out.println("flag4:"+flag4);// flag4: false  因为ccc文件夹是非空文件夹*/

        // 删除文件夹 删除ccc下面的ddd文件夹
        /*File file5 = new File("day10\\ccc\\ddd");
        boolean flag5 = file5.delete();
        System.out.println("flag5:"+flag5);// flag5:true*/

        // public boolean mkdir() ：创建由此File表示的目录。
        // 创建一个File对象,表示day10\\ddd文件夹
        /*File file6 = new File("day10\\ddd");
        boolean flag6 = file6.mkdir();// 创建day10下面的ddd文件夹
        System.out.println("flag6:"+flag6);// flag6:true*/


        // public boolean mkdirs() 创建多级目录,包含必须但不存在的父目录
        // 创建一个File对象,表示day10\\ddd\\aaa\\bbb\\ccc\\ddd\\eee文件夹
        File file7 = new File("day10\\ddd\\aaa\\bbb\\ccc\\ddd\\eee");
        // 创建的day10\\ddd下面的eee文件夹,但是eee前面还有aaa\\bbb\\ccc\\ddd这些父目录不存在
        boolean flag7 = file7.mkdirs();
        System.out.println("flag7:" + flag7);
    }

    /**
     * 判断功能的方法
     */
    private static void method03() {
        // 1.路径存在:
        // 1.1 文件路径 真实存在的
        File file1 = new File("day10\\aaa\\a.txt");
        boolean flag1 = file1.exists();// 判断file1表示的文件是否真实存在
        System.out.println("flag1:" + flag1);// true

        boolean flag2 = file1.isDirectory();// 判断file1表示的文件是否是文件夹
        System.out.println("flag2:" + flag2);// false

        boolean flag3 = file1.isFile();// 判断file1表示的文件是否是文件
        System.out.println("flag3:" + flag3);// true

        System.out.println("=================================");
        // 1.2 文件夹路径 真实存在的
        File file2 = new File("day10\\aaa");
        boolean flag4 = file2.exists();// 判断file2表示的文件夹是否真实存在
        System.out.println("flag4:" + flag4);// true

        boolean flag5 = file2.isDirectory();// 判断file2表示的文件夹是否是文件夹
        System.out.println("flag5:" + flag5);// true

        boolean flag6 = file2.isFile();// 判断file表示的文件夹是否是文件
        System.out.println("flag6:" + flag6);// false

        System.out.println("=================================");
        // 2.路径不存在
        // 2.1 文件路径 不存在的
        File file3 = new File("day10\\aaa\\b.txt");
        boolean flag7 = file3.exists();// 判断file3表示的文件是否真实存在
        System.out.println("flag7:" + flag7);// false

        boolean flag8 = file3.isDirectory();// 判断file3表示的文件是否是文件夹
        System.out.println("flag8:" + flag8);// false

        boolean flag9 = file3.isFile();// 判断file3表示的文件是否是文件
        System.out.println("flag9:" + flag9);// false

        System.out.println("=================================");
        // 2.2 文件夹路径 不存在的
        File file4 = new File("day10\\bbb");
        boolean flag10 = file4.exists();// 判断file4表示的文件夹是否真实存在
        System.out.println("flag10:" + flag10);// false

        boolean flag11 = file4.isDirectory();// 判断file4表示的文件夹是否是文件夹
        System.out.println("flag11:" + flag11);// false

        boolean flag12 = file4.isFile();// 判断file4表示的文件夹是否是文件
        System.out.println("flag12:" + flag12);// false
    }

    /**
     * 获取功能的方法
     */
    private static void method02() {
        //  public String getAbsolutePath(): 获取该File对象的绝对路径
        // 创建一个File对象,表示项目中的a.txt文件路径
        File file = new File("day10\\aaa\\a.txt");
        String absolutePath = file.getAbsolutePath();
        System.out.println("absolutePath:" + absolutePath);// G:\szitheima87\day10\aaa\a.txt

        System.out.println("=========================================================");
        //  public String getPath() ：获取的是构造路径(创建该File对象使用的路径)
        File file1 = new File("day10\\aaa\\a.txt");
        File file2 = new File("G:\\szitheima87\\day10\\aaa\\a.txt");
        String file1Path = file1.getPath();
        String file2Path = file2.getPath();
        System.out.println("file1Path:" + file1Path);// day10\aaa\a.txt
        System.out.println("file2Path:" + file2Path);// G:\szitheima87\day10\aaa\a.txt


        System.out.println("=========================================================");
        // public String getName()  ：返回由此File表示的文件或目录的名称。
        File file3 = new File("day10\\aaa\\a.txt");// 文件路径
        File file4 = new File("day10\\aaa");// 文件夹路径
        String file3Name = file3.getName();
        String file4Name = file4.getName();
        System.out.println("file3Name:" + file3Name);// a.txt
        System.out.println("file4Name:" + file4Name);// aaa

        System.out.println("=========================================================");
        //  public long length()  ：返回由此File表示的文件的字节大小。注意不能获取文件夹的字节大小
        File file5 = new File("day10\\aaa\\a.txt");// 文件路径
        File file6 = new File("day10\\aaa");// 文件夹路径
        long file5length = file5.length();
        long file6length = file6.length();
        System.out.println("file5length:" + file5length);// 7
        System.out.println("file6length:" + file6length);// 0
    }

    /**
     * File类的构造方法:
     */
    private static void method01() {
        // 构造方法:
        // 1.根据字符串路径创建一个File对象
        File file1 = new File("G:\\szitheima87\\day10\\aaa\\a.txt");// 文件路径
        File file2 = new File("G:\\szitheima87\\day10\\aaa");// 文件夹路径

        // 2.根据父路径名称的字符串和子路径名称的字符串创建一个File对象
        String parent = "G:\\szitheima87\\day10\\aaa";
        String child = "a.txt";
        File file3 = new File(parent, child);// 文件路径

        File file4 = new File("G:\\szitheima87\\day10", "aaa");// 文件夹路径


        // 3.根据父路径名称的File对象和子路径名称的字符串创建一个File对象
        File file5 = new File(file2, "a.txt");// 文件路径

        File fileParent = new File("G:\\szitheima87\\day10");
        File file6 = new File(fileParent, "aaa");// 文件夹路径


        // 4.注意:无论该路径下是否存在文件或者目录，都不影响File对象的创建。
        // file7表示:G:\szitheima87\day10\aaa\b.txt文件路径   不存在
        File file7 = new File(file2, "b.txt");

        // file8表示:G:\szitheima87\day10\bbb文件夹路径   不存在
        File file8 = new File(fileParent, "bbb");
    }
}
