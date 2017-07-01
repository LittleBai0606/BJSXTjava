package cn.bjsxt.cn.bjsxt.util;

import java.awt.*;

/**
 * Created by BenWhite on 2017/6/13.
 */
public class GameUtil {

    private GameUtil(){}

    public static Image getImage(String path){
        return Toolkit.getDefaultToolkit().getImage(GameUtil.class
        .getClassLoader().getResource(path));
    }
}
