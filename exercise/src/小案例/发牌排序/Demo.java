package 小案例.发牌排序;

import java.util.*;

/**
 * Created by zhangyuhong
 * Date:2017/12/22
 */
public class Demo {
    public static void main(String[] args) {


        //准备牌
        ArrayList<String> colors = new ArrayList<>();
        Collections.addAll(colors, "♠", "♥", "♣", "♦");
        ArrayList<String> number = new ArrayList<>();
        Collections.addAll(number, "2", "A", "K", "Q", "J", "10", "9", "8", "7", "6", "5", "4", "3");
        Integer index = 0;
        HashMap<Integer, String> paiMap = new HashMap<>();
        paiMap.put(index++, "大王");
        paiMap.put(index++, "小王");
        for (String str : number) {
            for (String c : colors) {
                paiMap.put(index++, c + str);
            }
        }
        //洗牌
        Set<Integer> integers = paiMap.keySet();
        ArrayList<Integer> suoyin = new ArrayList<>();
        suoyin.addAll(integers);
        Collections.shuffle(suoyin);
        //发牌，索引
        ArrayList<Integer> play1Index1 = new ArrayList<>();
        ArrayList<Integer> play1Index2 = new ArrayList<>();
        ArrayList<Integer> play1Index3 = new ArrayList<>();
        ArrayList<Integer> dipaiIndex = new ArrayList<>();

        for (int i = 0; i < suoyin.size(); i++) {
            Integer integer = suoyin.get(i);
            if (i >= 51) {
                dipaiIndex.add(integer);
            } else if (i % 3 == 0) {
                play1Index1.add(i);
            } else if (i % 3 == 1) {
                play1Index2.add(i);
            } else if (i % 3 == 2) {
                play1Index3.add(i);
            }
        }

        Collections.sort(play1Index1);
        Collections.sort(play1Index2);
        Collections.sort(play1Index3);
        Collections.sort(dipaiIndex);

        //用户取牌
        ArrayList<String> play1 = new ArrayList<>();
        ArrayList<String> play2 = new ArrayList<>();
        ArrayList<String> play3 = new ArrayList<>();
        ArrayList<String> dipai = new ArrayList<>();

        for (Integer integer : play1Index1) {
            play1.add(paiMap.get(integer));
        }
        for (Integer integer : play1Index2) {
            play2.add(paiMap.get(integer));
        }
        for (Integer integer : play1Index3) {
            play3.add(paiMap.get(integer));
        }
        for (Integer integer : dipaiIndex) {
            dipai.add(paiMap.get(integer));
        }

        System.out.println(play1+"大小"+play1.size());
        System.out.println(play2+"大小"+play2.size());
        System.out.println(play3+"大小"+play3.size());
        System.out.println(dipai+"大小"+dipaiIndex.size());
    }
}
