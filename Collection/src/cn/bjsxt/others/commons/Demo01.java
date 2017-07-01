package cn.bjsxt.others.commons;

import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.PredicateUtils;
import org.apache.commons.collections4.functors.EqualPredicate;
import org.apache.commons.collections4.functors.NotNullPredicate;
import org.apache.commons.collections4.functors.UniquePredicate;
import org.apache.commons.collections4.list.PredicatedList;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by BenWhite on 2017/6/23.
 * 函数式编程 predicate 断言
 */
public class Demo01 {

    public static void main(String[] args) {
        System.out.println("==========自定义判断=======");
        Predicate<String> selfPre = new Predicate<String>() {
            @Override
            public boolean evaluate(String object) {
                return object.length() >= 5 && object.length() <= 20;
            }
        };
        Predicate notNull = NotNullPredicate.notNullPredicate();
        Predicate all = PredicateUtils.allPredicate(selfPre, notNull);
        List<String> list = PredicatedList.predicatedList(new ArrayList<>(),all);
        list.add("bjsx");

    }

    public static void unique(){
        System.out.println("==========唯一性判断========");
        Predicate<Long> uniquePre = UniquePredicate.uniquePredicate();
        List<Long> list = PredicatedList.predicatedList(new ArrayList<>(), uniquePre);
        list.add(100L);
        list.add(200L);
        list.add(300L);
        list.add(100L);
    }

    public static void notNull(){
        System.out.println("==========非空判断=========");
        Predicate notNull = NotNullPredicate.notNullPredicate();
        String str = "bjsxt";
        System.out.println(notNull.evaluate(str));

        //添加容器值的判断
        List<Long> list = PredicatedList.predicatedList(new ArrayList<>(), notNull);
        list.add(1000L);
        list.add(null);
    }
    public static void equal() {
        System.out.println("==========相等判断=========");
        Predicate<String> pre = EqualPredicate.equalPredicate("bjsxt");
        boolean flag = pre.evaluate("bj");
        System.out.println(flag);
    }
}
