package cn.bjsxt.solarSystem;

import cn.bjsxt.cn.bjsxt.util.Constant;
import cn.bjsxt.cn.bjsxt.util.GameUtil;
import cn.bjsxt.cn.bjsxt.util.MyFrame;

import java.awt.*;

/**
 * Created by BenWhite on 2017/6/13.
 * 太阳系的主窗口
 */
public class SolarFrame extends MyFrame{
    Image bg = GameUtil.getImage("images/background.jpg");
    Star sun = new Star("images/Sun.jpg", Constant.GAME_WIDTH /2,Constant.GAME_HEIGHT / 2);
    Planet Earth = new Planet(sun, "images/Earth.jpg",150, 100, 0.1);
    Planet Mars = new Planet(sun, "images/Mars.jpg",200,130,0.2);
    Planet moon = new Planet(Earth, "images/moon.jpg", 20, 30, 0.3,true);
    @Override
    public void paint(Graphics g) {
        g.drawImage(bg, 0, 0, null);
        sun.draw(g);
        Earth.draw(g);
        moon.draw(g);
        Mars.draw(g);
    }

    public static void main(String[] args) {
        SolarFrame sf = new SolarFrame();
        sf.launchFrame();
    }
}
