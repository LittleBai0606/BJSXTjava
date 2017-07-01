package cn.bjsxt.others.commons;

import org.apache.commons.collections4.CollectionUtils;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by BenWhite on 2017/6/24.
 */
public class Demo04 {

    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);

        Set<Integer> set2 = new HashSet<>();
        set2.add(2);
        set2.add(3);
        set2.add(4);

        Collection<Integer> col1 = CollectionUtils.union(set1, set2);
        System.out.println("==============并集===============");
        for (Integer temp : col1){
            System.out.println(temp);
        }
        System.out.println("===============交集==============");
        Collection<Integer> col2 = CollectionUtils.intersection(set1, set2);
        for (Integer temp : col2){
            System.out.println(temp);
        }
        System.out.println("===============差集==============");
        Collection<Integer> col3 = CollectionUtils.subtract(set1, set2);
        for(Integer temp : col3){
            System.out.println(temp);
        }
    }
}
