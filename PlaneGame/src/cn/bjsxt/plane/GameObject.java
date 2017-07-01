package cn.bjsxt.plane;

import java.awt.*;

/**
 * Created by BenWhite on 2017/6/14.
 */
public class GameObject {

    protected Image img;
    protected double x, y;
    protected double width, height;
    protected int speed = 10;

    public Rectangle getRect(){
        return new Rectangle((int)x, (int)y, (int)width, (int)height);
    }

    public GameObject(Image img, double x, double y,
                      double width, double height, int speed) {
        this.img = img;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.speed = speed;
    }

    public GameObject() {
    }
}
