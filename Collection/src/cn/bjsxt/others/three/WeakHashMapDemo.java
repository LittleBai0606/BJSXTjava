package cn.bjsxt.others.three;

import java.util.WeakHashMap;

/**
 * Created by BenWhite on 2017/6/22.
 * WeakHashMap 键为弱类型，gc运行立即回收
 */
public class WeakHashMapDemo {

    public static void main(String[] args) {
        WeakHashMap<String, String> map = new WeakHashMap<String, String>();
        //测试数据
        map.put("abc", "a");
        map.put("d","test");
        map.put(new String("bjsxt"), "c");
        map.put(new String("dsf"), "d");

        //通知回收
        System.gc();
        System.runFinalization();

        System.out.println(map.size());

    }
}
