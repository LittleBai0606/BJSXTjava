package cn.bjsxt.Thread;

/**
 * Created by BenWhite on 2017/6/28.
 */
public class Web12306 implements Runnable{

    private int num = 10;

    private boolean flag = true;

    @Override
    public void run() {
        while (flag) {
            test4();
        }
    }

    public static void main(String[] args) {
        Web12306 web = new Web12306();
        //代理
        Thread t1 = new Thread(web, "路人甲");
        Thread t2 = new Thread(web, "黄牛己");
        Thread t3 = new Thread(web, "攻城狮");

        t1.start();
        t2.start();
        t3.start();
    }
    //线程不安全
    public void test1() {
        if(num <= 1) {
            flag = false;
            return;
        }
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "抢到了" + num--);
    }

    public synchronized void test2() {
        if(num <= 1) {
            flag = false;
            return;
        }
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "抢到了" + num--);
    }

    public void test3() {
        synchronized(this) {
            if (num <= 0) {
                flag = false;
                return;
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "抢到了" + num--);
        }
    }


    public void test4() {
        synchronized((Integer)num) {
            if (num <= 0) {
                flag = false;
                return;
             }
        }
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "抢到了" + num--);

    }

}
