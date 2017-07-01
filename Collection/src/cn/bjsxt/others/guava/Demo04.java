package cn.bjsxt.others.guava;

import com.google.common.collect.Sets;

import java.util.Set;

/**
 * Created by BenWhite on 2017/6/23.
 */
public class Demo04 {

    public static void main(String[] args) {
        Set<Integer> sets = Sets.newHashSet(0, 1, 2, 3, 4, 5);
        Set<Integer> sets2 = Sets.newHashSet(3, 4, 5, 6, 7, 8, 9);

        //交集
        System.out.println("交集为:");
        Sets.SetView<Integer> intersection = Sets.intersection(sets, sets2);
        for (Integer temp : intersection) {
            System.out.println(temp);
        }
        //差集
        System.out.println("差集为:");
        Sets.SetView<Integer> difference = Sets.difference(sets, sets2);
        for (Integer temp : difference) {
            System.out.println(temp);
        }
        //合集
        System.out.println("合集为:");
        Sets.SetView<Integer> union =  Sets.union(sets, sets2);
        for (Integer temp : union) {
            System.out.println(temp);
        }
    }
}
