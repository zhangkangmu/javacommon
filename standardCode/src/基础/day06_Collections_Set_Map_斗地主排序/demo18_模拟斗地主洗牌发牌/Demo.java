package 基础.day06_Collections_Set_Map_斗地主排序.demo18_模拟斗地主洗牌发牌;

import java.util.*;

/**
 * @author 彭智林
 * @date 2017/12/22 16:02
 */
public class Demo {
    public static void main(String[] args) {
        /**
         * List集合:
         *  boolean addAll(Collection<? extends E> c)  :把参数集合中的所有元素添加到此集合中
         */
        //  1.造牌
        //  1.1 创建一个Map集合,键的类型为Integer,表示标记,值的类型为String,表示牌
        Map<Integer, String> map = new HashMap<>();

        //  1.2 创建一个花色单列集合,用来存储4个花色
        ArrayList<String> colors = new ArrayList<>();
        //  1.3 创建一个牌面值单列集合,用来存储13个牌面值
        ArrayList<String> numbers = new ArrayList<>();

        //  1.4 往花色集合中添加4个花色
        Collections.addAll(colors, "♠", "♥", "♣", "♦");

        //  1.5 往牌面值的集合中添加13个牌面值
        Collections.addAll(numbers, "2", "A", "K", "Q", "J", "10", "9", "8", "7", "6", "5", "4", "3");

        //  1.6 定义一个int类型的标记变量,初始值为0
        int flag = 0;

        //  1.7 往map集合中,添加大王,标记为0,添加完后标记+1
        map.put(flag++, "大王");
        //  1.8 往map集合中,添加小王,标记为1,添加完后标记+1
        map.put(flag++, "小王");

        //  1.9 循环嵌套,生成52张牌,每生成一张牌,就添加到map集合中,标记就+1
        //  注意:牌面值单列集合作为外层循环,花色单列集合作为内层循环
        for (String number : numbers) {
            for (String color : colors) {
                String pai = color + number;
                map.put(flag++, pai);
            }
        }

        System.out.println(map);
        System.out.println(map.size());


        // 2.洗牌:洗索引
        // 2.1 获取map集合中所有的键(也就是所有的标记),得到Set集合
        Set<Integer> keys = map.keySet();

        // 2.2 创建一个List集合,集合中元素的类型为Integer
        ArrayList<Integer> list = new ArrayList<>();

        // 2.3 把所有键全部添加到List集合
        list.addAll(keys);

        // 2.4 使用Collections.shuffle()方法对List集合进行打乱顺序
        Collections.shuffle(list);
        System.out.println(list);
        System.out.println(list.size());


        // 3.发牌:发标记---对标记从小到大排序---根据标记去map集合中拿牌
        // 3.1 创建4个单列集合,分别用来存储玩家1,玩家2,玩家3,底牌 的牌的标记
        ArrayList<Integer> play1Flag = new ArrayList<>();
        ArrayList<Integer> play2Flag = new ArrayList<>();
        ArrayList<Integer> play3Flag = new ArrayList<>();
        ArrayList<Integer> diPaiFlag = new ArrayList<>();

        // 3.2 遍历存储所有标记的list集合
        for (int i = 0; i < list.size(); i++) {
            Integer paiFlag = list.get(i);
            // 3.3 在循环中,判断该标记到底给谁
            if (i >= 51) {
                // 3.4 如果该标记的索引>=51 就把该标记给底牌
                diPaiFlag.add(paiFlag);
            } else if (i % 3 == 0) {
                // 3.4 如果该标记的索引%3==0 就把该标记给玩家1
                play1Flag.add(paiFlag);
            } else if (i % 3 == 1) {
                // 3.4 如果该标记的索引%3==1 就把该标记给玩家2
                play2Flag.add(paiFlag);
            } else {
                // 3.4 如果该标记的索引%3==2 就把该标记给玩家3
                play3Flag.add(paiFlag);
            }
        }

        // 3.5 对玩家1,玩家2,玩家3,底牌 的标记进行从小到大排序
        Collections.sort(play1Flag);
        Collections.sort(play2Flag);
        Collections.sort(play3Flag);
        Collections.sort(diPaiFlag);

        // 3.6 创建4个单列集合,分别用来存储玩家1,玩家2,玩家3,底牌 的牌
        ArrayList<String> play1 = new ArrayList<>();
        ArrayList<String> play2 = new ArrayList<>();
        ArrayList<String> play3 = new ArrayList<>();
        ArrayList<String> diPai = new ArrayList<>();

        // 3.7 遍历玩家1的标记,根据标记去map集合中拿牌,存储到玩家1的牌的集合中
        for (Integer paiFlag : play1Flag) {
            String value = map.get(paiFlag);// 根据标记拿牌
            play1.add(value);
        }
        // 3.7 遍历玩家2的标记,根据标记去map集合中拿牌,存储到玩家2的牌的集合中
        for (Integer paiFlag : play2Flag) {
            String value = map.get(paiFlag);// 根据标记拿牌
            play2.add(value);
        }
        // 3.7 遍历玩家3的标记,根据标记去map集合中拿牌,存储到玩家3的牌的集合中
        for (Integer paiFlag : play3Flag) {
            String value = map.get(paiFlag);// 根据标记拿牌
            play3.add(value);
        }
        // 3.7 遍历底牌的标记,根据标记去map集合中拿牌,存储到底牌的牌的集合中
        for (Integer paiFlag : diPaiFlag) {
            String value = map.get(paiFlag);// 根据标记拿牌
            diPai.add(value);
        }

        System.out.println("令狐冲:"+play1+",数量:"+play1.size());
        System.out.println("石破天:"+play2+",数量:"+play2.size());
        System.out.println("鸠摩智:"+play3+",数量:"+play3.size());
        System.out.println("底牌:"+diPai+",数量:"+diPai.size());
    }
}
