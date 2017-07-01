package cn.bjsxt.solarSystem;

import cn.bjsxt.cn.bjsxt.util.GameUtil;

import javax.swing.*;
import java.awt.*;

/**
 * Created by BenWhite on 2017/6/13.
 */
public class Star {
    Image img;
    double x, y;
    int width, height;

    public void draw(Graphics g){
        g.drawImage(img, (int)x, (int)y, null);
    }

    public Star() {
    }

    public Star(Image img){
        this.img = img;
        Image g = new ImageIcon(img).getImage();
        this.width = g.getWidth(null);
        this.height = g.getHeight(null);
    }

    public Star(Image img, double x, double y) {
        this(img);
        this.x = x;
        this.y = y;

    }

    public Star(String imgPath, double x, double y){
        this(GameUtil.getImage(imgPath), x, y);

    }
}
