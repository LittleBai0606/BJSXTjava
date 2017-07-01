package cn.bjsxt.plane;

import cn.bjsxt.util.Constant;

import java.awt.*;

/**
 * Created by BenWhite on 2017/6/14.
 */
public class Bullet extends GameObject{
     double degree;

    public Bullet() {
        degree = Math.random() * Math.PI * 2;
        x = Constant.GAME_WIDTH / 2;
        y = Constant.GAME_HEIGHT / 2;
        width = 10;
        height = 10;
    }

    public void draw(Graphics g){
        super.speed = 3;
        Color c = g.getColor();
        g.setColor(Color.YELLOW);
        g.fillOval((int)x, (int)y, 10, 10);
        x += speed * Math.cos(degree);
        y += speed * Math.sin(degree);
        if(x > Constant.GAME_WIDTH - width || x < 5){
            degree = Math.PI - degree;
        }
        if(y > Constant.GAME_HEIGHT - height || y < 35){
            degree = -degree;
        }
        g.setColor(c);
    }

}
