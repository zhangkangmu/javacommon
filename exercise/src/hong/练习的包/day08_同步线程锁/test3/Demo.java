package hong.练习的包.day08_同步线程锁.test3;

import java.util.Enumeration;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * Created by zhangyuhong
 * Date:2019/12/25
 */
public class Demo {
    public static void main(String[] args) {
        ConcurrentHashMap<Integer, String> map = new ConcurrentHashMap<>();
        for (int i = 0; i < 10; i++) {
            map.put(i, "数据" + i);
            map.remove(i);
        }


        CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
            list.remove(0);
        }

        CopyOnWriteArraySet<String> set = new CopyOnWriteArraySet<>();
        for (int i = 0; i < 10; i++) {

            set.add(i+"");
            set.remove(i+"");
        }
        System.out.println(map);
        System.out.println(list);
        System.out.println(set);
    }
}
