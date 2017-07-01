package cn.bjsxt.Thread;

/**
 * Created by BenWhite on 2017/6/29.
 */
public class SynDemo03 {

    public static void main(String[] args) {
        Object g = new Object();
        Object m = new Object();
        Test t1 = new Test(g, m);
        Test2 t2 = new Test2(g, m);
        Thread proxy1 = new Thread(t1);
        Thread proxy2 = new Thread(t2);
        proxy1.start();
        proxy2.start();
    }
}

class Test implements Runnable{

    Object goods = null;
    Object money = null;

    public Test(Object goods, Object money) {
        this.goods = goods;
        this.money = money;
    }

    @Override
    public void run() {
        while (true) {
            test();
        }
    }

    public void test() {
        synchronized (goods) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (money) {

            }
        }
        System.out.println("一手给钱");
    }
}

class Test2 implements Runnable{

    Object goods = null;
    Object money = null;

    public Test2(Object goods, Object money) {
        this.goods = goods;
        this.money = money;
    }

    @Override
    public void run() {
        while (true) {
            test();
        }
    }

    public void test() {
        synchronized (money) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (goods) {

            }
        }
        System.out.println("一手给钱");
    }
}
