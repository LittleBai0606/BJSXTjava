package cn.bjsxt.others.guava;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

import java.util.*;

/**
 * Created by BenWhite on 2017/6/23.
 * 分析查看 教师 教授的每门课程
 */
public class Demo06 {

    public static void main(String[] args) {
        Map<String, String> cours = new HashMap<>();
        //加入测试数据
        cours.put("改革开放", "邓小平");
        cours.put("三个代表", " 江泽民");
        cours.put("科学发展观", "胡锦涛");
        cours.put("八荣八耻", "胡锦涛");
        cours.put("...", "习近平");

        //Multmap
        Multimap<String, String> teacher = ArrayListMultimap.create();
        //迭代器
        Iterator<Map.Entry<String, String>> it = cours.entrySet().iterator();
        while (it.hasNext()){
            Map.Entry<String, String> entry = it.next();
            String key = entry.getKey();
            String value = entry.getValue();
            //教师 --> 课程
            teacher.put(value, key);
        }
        Set<String> keyset = teacher.keySet();
        for(String key : keyset){
            Collection<String> col = teacher.get(key);

            System.out.println(key + "-->" + col);
        }
    }
}
