package cn.bjsxt.Thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by BenWhite on 2017/6/28.
 */
public class Call {

    public static void main(String[] args) {
        //创建线程
        ExecutorService ser = Executors.newFixedThreadPool(2);
        //获取值
    }
}

class Race implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        return 1000;
    }
}
