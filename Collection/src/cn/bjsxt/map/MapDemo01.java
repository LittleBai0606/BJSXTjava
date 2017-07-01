package cn.bjsxt.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by BenWhite on 2017/6/20.
 */
public class MapDemo01 {
    public static void main(String[] args) {
        String[] arr = "this is a cat and that is a mice and where is the food?".split(" ");
        Map<String, Letter> map = new HashMap<String, Letter>();
        for (String key : arr){
            //第一次查看是否存在袋子
            if(!map.containsKey(key)){
                map.put(key, new Letter(key));
            }
            //获取具体的袋子
            Letter value = map.get(key);
            value.setCount(value.getCount() + 1);
        }
        //查看每个单词出现的次数
        for (String key: map.keySet()){
            Letter value = map.get(key);
            System.out.println(key + "-->" + value.getCount());
        }

    }
}
