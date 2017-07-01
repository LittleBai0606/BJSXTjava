package cn.bjsxt.Thread.pro;

/**
 * Created by BenWhite on 2017/6/29.
 */
public class Movie {

    private String pic;

    //信号灯 true：生产者生产，消费者等待 flase：消费者消费，生产者等待
    //生产完后通知消费，消费完后通知生产
    private boolean flag = true;

    public static void main(String[] args) {

    }

    public synchronized void play(String pic) {
        if(!flag) {
            try {
                this.wait();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.pic = pic;
        this.notify();
        this.flag = false;
    }

    public synchronized void watch() {
        if(flag) {
            try {
                this.wait();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(pic);
        this.notifyAll();
        this.flag = true;

    }
}
