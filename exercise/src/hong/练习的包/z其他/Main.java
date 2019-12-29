package hong.练习的包.z其他;

import hong.utils.Utils;

import java.util.*;

/**
 * Created by zhangyuhong
 * Date:2019/12/22
 */
public class Main implements Runnable{
    public static void main(String[] args) {
        Thread thread = new Thread(new Main());
        thread.start();
    }

    @Override
    public void run() {

    }
}
