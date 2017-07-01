package cn.bjsxt.others.guava;

import com.google.common.base.Function;
import com.google.common.base.Functions;
import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import javax.annotation.Nullable;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * Created by BenWhite on 2017/6/23.
 */
public class Demo02 {

    public static void main(String[] args) {
//        组合是函数编程
//        确保容器中的字符串长度不超过s，超过进行截取，后全部大写
        List<String> list = Lists.newArrayList("bjsxt", "good", "happiness", "hello", "boring", "yesterday");
        Function<String, String> f1 = new Function<String, String>() {
            @Nullable
            @Override
            public String apply(@Nullable String input) {
                return input.length() > 5 ? input.substring(0,5) : input;
            }
        };

        //转成大写
        Function<String, String> f2 = new Function<String, String>() {
            @Nullable
            @Override
            public String apply(@Nullable String input) {
                return input.toUpperCase();
            }
        };
        Function<String, String> f = Functions.compose(f1, f2);
        Collection<String> resultCol = Collections2.transform(list, f);

        for (String temp : resultCol){
            System.out.println(temp);
        }
    }
    /*
    * 过滤器
    **/
    public static void test1(){
        List<String> list = Lists.newArrayList("mom", "sun", "dad", "bjsxt","refer");
        //找出回文 mirrorword
        Collection<String> palindromeList = Collections2.filter(list, new Predicate<String>() {
            @Override
            public boolean apply(@Nullable String input) {

                return new StringBuilder(input).reverse().toString().equals(input);
            }
        });

        for (String temp: palindromeList){
            System.out.println(temp);
        }
    }
    /*类型转换*/
    public static void test2(){
        //        类型转换
        Set<Long> timeSet = Sets.newHashSet();
        timeSet.add(1000000000L);
        timeSet.add(200000000000L);
        timeSet.add(999999999999L);

        Collection<String> timeStrCol = Collections2.transform(timeSet, new Function<Long, String>() {
            @Nullable
            @Override
            public String apply(@Nullable Long input) {
                return new SimpleDateFormat("yyyy-MM-dd").format(input);
            }
        });

        for (String temp : timeStrCol){
            System.out.println(temp);
        }
    }
}
