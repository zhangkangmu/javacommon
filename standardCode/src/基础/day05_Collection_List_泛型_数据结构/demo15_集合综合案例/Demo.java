package 基础.day05_Collection_List_泛型_数据结构.demo15_集合综合案例;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author 彭智林
 * @date 2017/12/21 16:19
 */
public class Demo {
    public static void main(String[] args) {
        // 1.造牌
        // 1.1 创建一个扑克盒集合,用来存储54张牌
        ArrayList<String> pokerBox = new ArrayList<>();
        // 1.2 创建一个花色集合,用来存储4个花色
        ArrayList<String> colors = new ArrayList<>();
        // 1.3 创建一个牌面值集合,用来存储13个牌面值
        ArrayList<String> numbers = new ArrayList<>();
        // 1.4 往花色集合中,添加4个花色
        colors.add("♥");
        colors.add("♠");
        colors.add("♣");
        colors.add("♦");

        // 1.5 往牌面值集合中,添加13个牌面值
        numbers.add("A");
        numbers.add("K");
        numbers.add("Q");
        numbers.add("J");

        for (int i = 2; i <= 10; i++) {
            numbers.add(i + "");
        }

        // 1.6 循环嵌套,生成52张牌,并添加到扑克盒的集合中
        for (String color : colors) {
            for (String number : numbers) {
                String pai = color + number;
                pokerBox.add(pai);
            }
        }
        // 1.7 往扑克盒集合中,添加大小王
        pokerBox.add("小王");
        pokerBox.add("大王");
        System.out.println("牌:" + pokerBox);
        System.out.println("牌数:" + pokerBox.size());

        /*洗牌:
        Collections工具类静态方法:public static void shuffle(List<?> list)
        打乱集合中元素的顺序

        Collections.shuffle(需要打乱元素顺序的集合);*/
        Collections.shuffle(pokerBox);
        System.out.println("打乱顺序后的牌:" + pokerBox);
        System.out.println("打乱顺序后的牌数:" + pokerBox.size());

        // 3.发牌:
        // 3.1 创建4个集合,分别用来存储玩家1,玩家2,玩家3,底牌 的牌
        ArrayList<String> player1 = new ArrayList<>();
        ArrayList<String> player2 = new ArrayList<>();
        ArrayList<String> player3 = new ArrayList<>();
        ArrayList<String> diPai = new ArrayList<>();

        // 3.2 循环遍历扑克盒集合
        for (int i = 0; i < pokerBox.size(); i++) {
            // 3.3 在循环中,获取遍历出来的牌
            String pai = pokerBox.get(i);
            // 3.4 判断该牌,到底给谁
            if (i >= 51) {
                // 3.4.1 如果牌的索引 >= 51 ,就把该牌给底牌
                diPai.add(pai);
            } else if (i % 3 == 0) {
                // 3.4.2 如果牌的索引%3==0 ,就把该牌给玩家1
                player1.add(pai);
            } else if (i % 3 == 1) {
                // 3.4.3 如果牌的索引%3==1 ,就把该牌给玩家2
                player2.add(pai);
            } else {
                // 3.4.3 如果牌的索引%3==2 ,就把该牌给玩家3
                player3.add(pai);
            }
        }
        // 3.5 展示牌
        System.out.println("玩家1:"+player1+" 数量:"+player1.size());
        System.out.println("玩家2:"+player2+" 数量:"+player2.size());
        System.out.println("玩家3:"+player3+" 数量:"+player3.size());
        System.out.println("底牌:"+diPai);
    }
}
