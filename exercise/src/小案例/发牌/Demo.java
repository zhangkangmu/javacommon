package 小案例.发牌;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by zhangyuhong
 * Date:2019/12/21
 */
public class Demo {

    private static ArrayList<String> colors;
    private static ArrayList<String> number;
    private static ArrayList<String> box;

    public static void main(String[] args) {
        //准备牌
        prepare();
        //打乱牌
        Collections.shuffle(box);
        //发牌
        faPai();
    }

    private static void faPai() {
        ArrayList<String> player1 = new ArrayList<>();
        ArrayList<String> player2 = new ArrayList<>();
        ArrayList<String> player3 = new ArrayList<>();
        ArrayList<String> dipai = new ArrayList<>();
        for (int i = 0; i < box.size(); i++) {
            if (i>=51){
                dipai.add(box.get(i));
            }
            else if (i%3==0){
                player1.add(box.get(i));
            }
            else if (i%3==1){
                player2.add(box.get(i));
            }
            else {
                player3.add(box.get(i));
            }
        }
        System.out.println(player1+"---"+player1.size());
        System.out.println(player2+"---"+player2.size());
        System.out.println(player3+"---"+player3.size());
        System.out.println(dipai);
    }

    private static void prepare() {
        colors = new ArrayList<>();
        colors.add("♠");
        colors.add("♥");
        colors.add("♣");
        colors.add("♦");
        number = new ArrayList<>();
        number.add("A");
        number.add("J");
        number.add("Q");
        number.add("K");
        for (int i = 2; i <= 10; i++) {
            number.add(i+"");
        }
        box = new ArrayList<>();
        for (String color : colors) {
            for (String num : number) {
                box.add(color+num);
            }
        }
        box.add("大王");
        box.add("小王");
        System.out.println(box);
        System.out.println("牌的数量："+ box.size());
    }
}
