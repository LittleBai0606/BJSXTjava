package cn.bjsxt.iterator;

/**
 * Created by BenWhite on 2017/6/20.
 * 目标：理解迭代器的原理
 */
public class SxtSimpleList {

    private String[] elem = {"a", "b", "c", "d"};

    private int size = elem.length;

    public int size(){
        return this.size;
    }
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
        System.arraycopy(elem, cursor+1, elem, cursor, this.size-(cursor+1));
        this.size--;
    }

    public static void main(String[] args) {
        SxtSimpleList list = new SxtSimpleList();
        if(list.hasNext())
        {
            System.out.println(list.next());

        }
        if(list.hasNext())
        {
            System.out.println(list.next());

        }
        if(list.hasNext())
        {
            System.out.println(list.next());

        }
        if(list.hasNext())
        {
            System.out.println(list.next());

        }
        if(list.hasNext())
        {
            System.out.println(list.next());

        }

    }
}
