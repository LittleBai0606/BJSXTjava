package cn.bjsxt.others.commons;

import org.apache.commons.collections4.Closure;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.functors.IfClosure;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by BenWhite on 2017/6/24.
 * Closure 闭包封装特定的业务功能
 */
public class Demo03 {

    public static void main(String[] args) {
        ifClosure();
    }

    /*
     *二选一操作
     * 如果是进行打折商品，打九折
     * 否者满百减20
     */

    public static void ifClosure(){
        List<Goods> goodsList = new ArrayList<>();
        goodsList.add(new Goods("JavaSE视频", 120, true));
        goodsList.add(new Goods("JavaEE视频", 100, false));
        goodsList.add(new Goods("python玩蛇视频", 80, true));

        //满百减
        Closure<Goods> subtract = new Closure<Goods>() {
            @Override
            public void execute(Goods goods) {
                if(goods.getPrice() >= 100 && !goods.isDiscount()){
                    goods.setPrice(goods.getPrice() - 20);
                }

            }
        };

        //打折
        Closure<Goods> discount = new Closure<Goods>() {
            @Override
            public void execute(Goods goods) {
                if(goods.isDiscount()){
                    goods.setPrice(goods.getPrice() * 0.9);
                }
            }
        };

        //判断
        Predicate<Goods> pre = new Predicate<Goods>() {
            @Override
            public boolean evaluate(Goods goods) {
                return goods.isDiscount();
            }
        };

        //二选一
        Closure<Goods> ifClo = IfClosure.ifClosure(pre, discount, subtract);
        CollectionUtils.forAllDo(goodsList, ifClo);

        //遍历
        for (Goods temp : goodsList){
            System.out.println(temp);
        }

    }
    /*基本操作
    * */
    public static void basic(){
        List<Employee> emplist = new ArrayList<>();
        emplist.add(new Employee("小白", 10000));
        emplist.add(new Employee("小黑", 20000));
        emplist.add(new Employee("小灰", 5000));

        //闭包业务功能
        Closure<Employee> cols = new Closure<Employee>() {
            @Override
            public void execute(Employee emp) {
                emp.setSalary(emp.getSalary() * 1.2);
            }
        };

//        借助工具类
        CollectionUtils.forAllDo(emplist, cols);

        //操作后的数据
        Iterator<Employee> empIT = emplist.iterator();
        while (empIT.hasNext()){
            System.out.println(empIT.next());
        }
    }
}
