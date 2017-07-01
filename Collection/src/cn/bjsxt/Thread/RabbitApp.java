package cn.bjsxt.Thread;

/**
 * Created by BenWhite on 2017/6/28.
 */
public class RabbitApp {

    public static void main(String[] args) {

        Rabbit rab = new Rabbit();
        Tortoise tor = new Tortoise();
        rab.start();
        tor.start();

        for (int i = 0; i < 100; i++) {
            System.out.println("main-->" + i);
        }
    }
}
