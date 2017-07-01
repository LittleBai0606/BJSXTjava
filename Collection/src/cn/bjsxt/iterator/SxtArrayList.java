package cn.bjsxt.iterator;

import java.util.Arrays;
import java.util.Iterator;

/**
 * Created by BenWhite on 2017/6/20.
 * 目标：使用泛型，可以操纵多个类型
 */
public class SxtArrayList<E> implements java.lang.Iterable<E>{

    private Object[] elem = new Object[5];

    private int size = 0;

    public int size(){
        return this.size;
    }

    public void add(E ele){
        if(this.size == elem.length){
            elem = Arrays.copyOf(elem, elem.length + 5);
        }
        elem[size] = ele;
        size++;
    }

    public Iterator<E> iterator(){
        return new Iterator<E>() {
            //计数器-->指针 游标
            private int cursor = -1;
            //判断是否存在下一个
            public boolean hasNext(){
                return cursor + 1 < size;
            }

            //获取下一个
            public E next(){
                cursor++;
                return (E)elem[cursor];
            }

            //删除下一个
            public void remove(){
                //移动数组的元素
                System.arraycopy(elem, cursor+1, elem, cursor, size-(cursor+1));
                size--;
                this.cursor--;
            }
        };
    }
    public static void main(String[] args) {
        SxtArrayList<Integer> list = new SxtArrayList<Integer>();
        list.add(1);
        list.add(2);
        for(Integer e : list){
            System.out.println(e);
        }
        System.out.println("---------------------------");
        SxtArrayList<String> list2 = new SxtArrayList<String>();
        list2.add("马云");
        list2.add("刘强东");
        for(String e : list2){
            System.out.println(e);
        }
    }
}
