package cn.bjsxt.plane;

import cn.bjsxt.util.GameUtil;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by BenWhite on 2017/6/14.
 */
public class Plane extends GameObject{

    private boolean left, up, right, down;

    private boolean isLive = true;

    public void draw(Graphics g){
        if(isLive){
            g.drawImage(img, (int)x, (int)y, null);
            move();
        }
    }

    public void move(){
       if(left) {
           x-= speed;
       }
       else if(right){
           x+= speed;
       }
       if(up) {
           y -= speed;
       }
       else if(down){
           y += speed;
       }
    }

    public Plane(){}

    public Plane(String imgPath, double x, double y) {
        this.img = GameUtil.getImage(imgPath);
        this.width = img.getWidth(null);
        this.height = img.getHeight(null);
        this.x = x;
        this.y = y;
    }

    public void keyPressed(KeyEvent e){
        switch (e.getKeyCode()){
            case KeyEvent.VK_LEFT:
                left = true;
                break;
            case KeyEvent.VK_UP:
                up = true;
                break;
            case KeyEvent.VK_RIGHT:
                right = true;
                break;
            case KeyEvent.VK_DOWN:
                down = true;
                break;
        }
    }

    public void keyReleased(KeyEvent e){
        switch (e.getKeyCode()){
            case KeyEvent.VK_LEFT:
                left = false;
                break;
            case KeyEvent.VK_UP:
                up = false;
                break;
            case KeyEvent.VK_RIGHT:
                right = false;
                break;
            case KeyEvent.VK_DOWN:
                down = false;
                break;
        }
    }

    public boolean isLive() {
        return isLive;
    }

    public void setLive(boolean live) {
        isLive = live;
    }
}
