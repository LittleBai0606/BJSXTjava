package cn.bjsxt.others.synread;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 使用Collection管理同步容器
 * Created by BenWhite on 2017/6/22.
 */
public class Demo01 {

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        //list可以同步
        List<String> synList = Collections.synchronizedList(list);
        System.out.println("线程安全的list制作完毕");
    }
}
