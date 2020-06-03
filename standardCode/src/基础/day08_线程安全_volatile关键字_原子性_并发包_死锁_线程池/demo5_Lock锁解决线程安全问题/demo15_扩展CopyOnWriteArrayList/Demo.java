package 基础.day08_线程安全_volatile关键字_原子性_并发包_死锁_线程池.demo5_Lock锁解决线程安全问题.demo15_扩展CopyOnWriteArrayList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author 彭智林
 * @date 2017/12/25 15:27
 */
public class Demo {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list,"jack","rose","lily","lucy");
        for (String e : list) {
            System.out.println(e);
            list.remove(e);// ConcurrentModificationException 并发修改异常
        }


      /*  CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
        Collections.addAll(list,"jack","rose","lily","lucy");
        for (String e : list) {
            System.out.println(e);
            list.remove(e);// ConcurrentModificationException 不会并发修改异常
        }
        System.out.println(list.size());*/
    }
}
