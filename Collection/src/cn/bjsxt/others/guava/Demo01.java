package cn.bjsxt.others.guava;

import com.google.common.collect.ImmutableList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.google.common.collect.ImmutableList.of;

/**
 * Created by BenWhite on 2017/6/23.
 */
public class Demo01 {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        //对原有的list进行包装，相对于原有list的一个视图
        List<String> onlyReadList = Collections.unmodifiableList(list);
        list.add("d");
        System.out.println(onlyReadList.size());
        //输出为4，说明改变原有list，视图也跟着一起改变

        //对比查看 初始化List
        List<String> immutableList = ImmutableList.of("a", "b", "c");

    }
}
