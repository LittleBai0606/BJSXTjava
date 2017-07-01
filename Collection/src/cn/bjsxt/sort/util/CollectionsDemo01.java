package cn.bjsxt.sort.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by BenWhite on 2017/6/22.
 */
public class CollectionsDemo01 {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(list);
        Collections.reverse(list);
        System.out.println("反转之后:\n" + list);
    }
}
