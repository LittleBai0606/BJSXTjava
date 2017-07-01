package cn.bjsxt.sort.col;

import java.util.TreeSet;

/**
 * Created by BenWhite on 2017/6/22.
 */
public class TreeSetDemo2 {

    public static void main(String[] args) {

        Worker w1 = new Worker("垃圾回收员", 12000);
        Worker w2 = new Worker("农民工", 8000);
        Worker w3 = new Worker("程序猿", 6000);

        TreeSet<Worker> employees = new TreeSet<Worker>();
        employees.add(w1);
        employees.add(w2);
        employees.add(w3);

        System.out.println(employees);
    }
}
