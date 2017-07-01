package cn.bjsxt.Thread;

/**
 * Created by BenWhite on 2017/6/28.
 */
public class Rabbit extends Thread{

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("兔子跑了" + i + "步");
        }
    }
}

class Tortoise extends Thread{

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("乌龟爬了" + i + "步");
        }
    }
}
