package cn.bjsxt.plane;

import cn.bjsxt.util.Constant;
import cn.bjsxt.util.GameUtil;
import cn.bjsxt.util.MyFrame;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by BenWhite on 2017/6/14.
 */
public class PlaneGameFrame extends MyFrame{

    Image bg = GameUtil.getImage("images/bg.jpg");

    Plane p = new Plane("images/plane.png",50, 50);

    ArrayList<Bullet> bulletList = new ArrayList<>();

    Date startTime, endTime;

    @Override
    public void paint(Graphics g) {
        g.drawImage(bg, 0, 0, null);
        p.draw(g);
        for (int i = 0; i < bulletList.size(); i++) {
            Bullet b = bulletList.get(i);
            b.draw(g);

            boolean peng = b.getRect().intersects(p.getRect());
            if(peng){
                p.setLive(false); //飞机坠毁
                endTime = new Date();

            }
        }
        if(!p.isLive()){
            long period = (endTime.getTime() - startTime.getTime()) / 1000;
            printInfo(g, "时间:" + period, 20, 120,10, Color.WHITE);
            printInfo(g, "GAME OVER!",75,200,50, Color.WHITE);
        }
    }

    /*
     * 在窗口上打印信息
     * @param g
     * @param str
     * @param x
     * @param y
     * @param size
     * @param color
     */
    public void printInfo(Graphics g, String str, int x, int y,int size, Color color){
        Color c = g.getColor();
        g.setColor(color);
        Font f = new Font("宋体", Font.BOLD, size);
        g.setFont(f);
        g.drawString(str, x, y);
        g.setColor(c);
    }

    public static void main(String[] args) {
        new PlaneGameFrame().launchFrame();
    }

    @Override
    public void launchFrame() {
        super.launchFrame();
        //增加键盘的监听
        addKeyListener(new keyMonitor());

        //生成一堆子弹
        for (int i = 0; i < 5; i++) {
            Bullet b = new Bullet();
            bulletList.add(b);
        }
        startTime = new Date();
    }

    //定义为内部类，可以方便使用外部类的普通属性
    class keyMonitor extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e) {
           p.keyPressed(e);
        }
        @Override
        public void keyReleased(KeyEvent e) {
            p.keyReleased(e);
        }
    }
}
