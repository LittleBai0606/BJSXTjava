package cn.bjsxt.util;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

/**
 * Created by BenWhite on 2017/6/13.
 */
public class GameUtil {

    private GameUtil(){}

    public static Image getImage(String path){
        BufferedImage bi = null;
        try {
            URL u = GameUtil.class.getClassLoader().getResource(path);
            bi = javax.imageio.ImageIO.read(u);
        }catch (IOException e){
            e.printStackTrace();
        }
        return bi;
    }
}
