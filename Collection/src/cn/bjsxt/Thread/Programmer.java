package cn.bjsxt.Thread;

/**
 * Created by BenWhite on 2017/6/28.
 */
public class Programmer implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("一边敲代码HelloWorld...");
        }
    }
}
