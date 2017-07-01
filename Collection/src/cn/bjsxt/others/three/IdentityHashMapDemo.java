package cn.bjsxt.others.three;

import java.util.IdentityHashMap;

/**
 * Created by BenWhite on 2017/6/22.
 */
public class IdentityHashMapDemo {

    public static void main(String[] args) {
        IdentityHashMap<String, String> map = new IdentityHashMap<>();
        //常量池
        map.put("a", "a1");
        map.put("a", "a2");
        System.out.println(map.size());
        map.put(new String("a"), "a3");
        map.put(new String("a"), "a4");
        System.out.println(map.size());
    }
}
