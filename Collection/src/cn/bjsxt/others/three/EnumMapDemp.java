package cn.bjsxt.others.three;

import java.util.EnumMap;

/**
 * Created by BenWhite on 2017/6/22.
 */
public class EnumMapDemp {

    public static void main(String[] args) {

        EnumMap<Season, String> map = new EnumMap<Season, String>(Season.class);
        //存放值
        map.put(Season.SPRING, "春困");
        map.put(Season.SUMMER, "夏疲");
        map.put(Season.AUTUMN, "秋乏");
        map.put(Season.WINTER, "冬眠");

        System.out.println(map.size());
    }
}

enum Season{
    SPRING,
    SUMMER,
    AUTUMN,
    WINTER
}