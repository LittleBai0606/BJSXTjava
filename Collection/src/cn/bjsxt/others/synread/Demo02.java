package cn.bjsxt.others.synread;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by BenWhite on 2017/6/22.
 */
public class Demo02 {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("test", "test");
        map.put("bjsxt", "bjsxt");

        //只读控制
        Map<String, String> map1 = Collections.unmodifiableMap(map);
        //map1.put("a", "a");
        System.out.println(map1.size());

        //一个元素的容器测试
        List<String> list = Collections.singletonList(new String());
        list.add("test");
        list.add("bjsxt");
    }
}
