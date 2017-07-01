package cn.bjsxt.others.commons;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.Transformer;
import org.apache.commons.collections4.functors.SwitchTransformer;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * Created by BenWhite on 2017/6/24.
 */
public class Demo02 {

    public static void main(String[] args) {
        System.out.println("自定义类型转换");
        //判别式
        Predicate<Employee> isLow = new Predicate<Employee>() {
            @Override
            public boolean evaluate(Employee emp) {
                return emp.getSalary() < 10000;
            }
        };
        Predicate<Employee> isHigh = new Predicate<Employee>() {
            @Override
            public boolean evaluate(Employee emp) {
                return emp.getSalary() >= 10000;
            }
        };

        Predicate[] pres= {isLow, isHigh};

        //转换
        Transformer<Employee, Level> lowLeveltrans = new Transformer<Employee, Level>() {
            @Override
            public Level transform(Employee input) {
                return new Level(input.getName(), "卖身中");
            }
        };

        Transformer<Employee, Level> highleveltrans = new Transformer<Employee, Level>() {
            @Override
            public Level transform(Employee input) {
                return new Level(input.getName(), "养身中");
            }
        };
        Transformer[] trans = {lowLeveltrans, highleveltrans};

        Transformer switchTrans = new SwitchTransformer(pres, trans, null);

        List<Employee> list = new ArrayList<>();
        list.add(new Employee("小白", 7000));
        list.add(new Employee("小黑", 150000));

        Collection<Level> levelList = CollectionUtils.collect(list, switchTrans);

        Iterator<Level> levelIT = levelList.iterator();
        while (levelIT.hasNext()){
            System.out.println(levelIT.next());
        }

    }
    /*
    * 内置类型的转换*/
    public static void inner(){

        System.out.println("内置类转换长整型时间日期， 转成指定格式字符串");

        Transformer<Long, String> trans = new Transformer<Long, String>() {
            @Override
            public String transform(Long input) {
                return new SimpleDateFormat("yyyy年MM月dd日").format(input);
            }
        };
        List<Long> list = new ArrayList<>();
        list.add(99999999999L);
        list.add(999999999999L);

        Collection<String> result = CollectionUtils.collect(list, trans);
        for (String time : result){
            System.out.println(time);
        }
    }
}
