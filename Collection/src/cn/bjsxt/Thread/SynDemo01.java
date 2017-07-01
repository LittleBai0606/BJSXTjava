package cn.bjsxt.Thread;

/**
 * Created by BenWhite on 2017/6/29.
 * 单例设计模式:确保一个类只有一个对象
 */
public class SynDemo01 {

    public static void main(String[] args) {

        JVMThread thread1 = new JVMThread(100);
        JVMThread thread2 = new JVMThread(500);
        thread1.start();
        thread2.start();
    }
}

class JVMThread extends Thread {
    private long time;

    public JVMThread() {

    }

    public JVMThread(long time){
        this.time = time;
    }
    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + "-->" + JVM.getInstance(time));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class JVM {

    //声明一个私有的静态变量
    private static JVM instance = null;
    //构造器私有化，避免外部直接创建对象
    private JVM() {
    }

    public static synchronized JVM getInstance(long time) throws InterruptedException {
        if(instance == null) {
            Thread.sleep(time);
            instance = new JVM();
        }
        return instance;
    }
}
