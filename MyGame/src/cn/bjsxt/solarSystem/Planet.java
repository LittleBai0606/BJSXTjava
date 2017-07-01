package cn.bjsxt.solarSystem;

import cn.bjsxt.cn.bjsxt.util.GameUtil;

import java.awt.*;

/**
 * Created by BenWhite on 2017/6/13.
 */
public class Planet extends Star {
    //行星绕着某个Star椭圆飞行，每个行星长轴，短轴，角度，速度都不同。
    private double longAxis;
    private double shortAxis;
    private double speed;
    private double degree;
    private Star center;
    private boolean satellite;

    public Planet(Image img, double x, double y) {
        super(img, x, y);
    }

    public Planet(String imgPath, double x, double y) {
        super(imgPath, x, y);
    }

    public Planet(Star center,String imgPath, double longAxis,
                  double shortAxis, double speed)
    {
        super(GameUtil.getImage(imgPath));

        this.center = center;
        this.x = center.x + longAxis;
        this.y = center.y;
        this.longAxis = longAxis;
        this.shortAxis = shortAxis;
        this.speed = speed;
    }

    public Planet(Star center,String imgPath, double longAxis,
                  double shortAxis, double speed, boolean isSatellite)
    {
        this(center, imgPath, longAxis, shortAxis, speed);
        this.satellite = isSatellite;
    }

    public void draw(Graphics g)
    {
        super.draw(g);
        move();
        if(!satellite)
        {
            drawTrace(g);
        }
    }

    public void move(){
        //沿着椭圆轨迹飞行
        x = (center.x + center.width/2)+longAxis * Math.cos(degree);
        y = (center.y + center.height/2) + shortAxis * Math.sin(degree);

        degree += speed;
    }

    public void drawTrace(Graphics g){
        double ovalX, ovalY, ovalWidth, ovalHeight;
        ovalWidth= longAxis * 2;
        ovalHeight = shortAxis * 2;
        ovalX = (center.x +center.width / 2)- longAxis;
        ovalY = (center.y + center.height / 2) - shortAxis;

        Color c = g.getColor();
        g.setColor(Color.BLUE);
        g.drawOval((int)ovalX, (int)ovalY, (int)ovalWidth, (int)ovalHeight);
        g.setColor(c);
    }
}
