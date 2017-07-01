package cn.bjsxt.others.que;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by BenWhite on 2017/6/22.
 */
public class Demo01 {

    public static void main(String[] args) {
        Queue<Request> que = new ArrayDeque<Request>();
        for(int i = 0; i < 10; i++){
            final int num = i;
            que.offer(new Request() {
                @Override
                public void deposit() {
                    System.out.println("第" + num + "个人办理存款业务，存款额度为:" + (Math.random() * 10000));
                }
            });
            dealWith(que);
        }
    }

    public static void dealWith(Queue<Request> que){
        Request req = null;
        while (null != (req = que.poll())){
            req.deposit();
        }
    }

    interface Request{
        //存款
        void deposit();
    }
}
