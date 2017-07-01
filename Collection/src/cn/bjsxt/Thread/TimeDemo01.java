package cn.bjsxt.Thread;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by BenWhite on 2017/6/29.
 */
public class TimeDemo01 {

    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("So easy...");
            }
        }, new Date(System.currentTimeMillis() + 1000), 1000);
    }
}
