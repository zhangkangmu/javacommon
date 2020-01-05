package 基础.day08_线程安全_volatile关键字_原子性_并发包_死锁_线程池.demo5_Lock锁解决线程安全问题.demo14_ConcurrentHashMap;

import java.util.Hashtable;

/**
 * @author 彭智林
 * @date 2017/12/25 15:19
 */
public class Const {
//    public static final HashMap<String,String> map = new HashMap<>();
    public static final Hashtable<String,String> map = new Hashtable<>();
//    public static final ConcurrentHashMap<String,String> map = new ConcurrentHashMap<>();
}
