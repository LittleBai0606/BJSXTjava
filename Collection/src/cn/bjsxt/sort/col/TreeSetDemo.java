package cn.bjsxt.sort.col;

import java.util.TreeSet;

/**
 * Created by BenWhite on 2017/6/22.
 */
public class TreeSetDemo {

    public static void main(String[] args) {
        Person p1 = new Person("小白", 100);
        Person p2 = new Person("刘德华", 1000);
        Person p3 = new Person("吴彦祖", 1500);
        Person p4 = new Person("小黑", 50);
        //一次存放到TreeSet容器中

        TreeSet<Person> persons = new TreeSet<Person>(
                new java.util.Comparator<Person>(){

                    @Override
                    public int compare(Person o1, Person o2) {
                        return o1.getHandsome() - o2.getHandsome();
                    }
                }
        );
        persons.add(p1);
        persons.add(p2);
        persons.add(p3);
        persons.add(p4);

        System.out.println(persons);
    }
}
