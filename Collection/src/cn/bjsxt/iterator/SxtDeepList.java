package cn.bjsxt.iterator;

import java.util.Arrays;
import java.util.Iterator;

/**
 * Created by BenWhite on 2017/6/20.
 * 目标：深入迭代器的原理-->一个容器可以创建多个迭代器对象
 */
public class SxtDeepList {

    private String[] elem = new String[5];

    private int size = 0;

    public int size(){
        return this.size;
    }

    public void add(String ele){
        if(this.size == elem.length){
            elem = Arrays.copyOf(elem, elem.length + 5);
        }
        elem[size] = ele;
        size++;
    }

    public Iterator iterator(){
        return new Iterator() {
            //计数器-->指针 游标
            private int cursor = -1;
            //判断是否存在下一个
            public boolean hasNext(){
                return cursor + 1 < size;
            }

            //获取下一个
            public String next(){
                cursor++;
                return elem[cursor];
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
        SxtDeepList list = new SxtDeepList();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        list.add("f");
        list.add("g");
        Iterator it = list.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
        System.out.println(list.size());
    }
}
