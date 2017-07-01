package cn.bjsxt.iterator;

import java.util.*;

/**
 * Created by BenWhite on 2017/6/18.
 */
public class Test01 {

    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        Set set = new HashSet();
        set.add("高1");
        set.add("高2");
        set.add("高3");

        Iterator iter = set.iterator();
        while (iter.hasNext()){
            String str = (String)iter.next();
            System.out.println(str);
        }
    }
}
