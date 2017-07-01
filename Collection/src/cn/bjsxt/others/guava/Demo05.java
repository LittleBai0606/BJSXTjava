package cn.bjsxt.others.guava;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;

import java.util.Set;

/**
 * Created by BenWhite on 2017/6/23.
 */
public class Demo05 {

    public static void main(String[] args) {
        String str = "this is a cat and that is a mice so where is the food";
        //分割字符串
        String[] strArray = str.split(" ");
        //存储到MultSet中
        Multiset<String> set = HashMultiset.create();
        for (String strTemp : strArray){
            set.add(strTemp);
        }

        //获取所有的单词Set
        Set<String> letters = set.elementSet();
        for (String temp : letters){
            System.out.println(temp + "-->" + set.count(temp));
        }
    }
}
