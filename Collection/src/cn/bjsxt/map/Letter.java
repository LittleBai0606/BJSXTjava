package cn.bjsxt.map;

/**
 * Created by BenWhite on 2017/6/20.
 */
public class Letter {

    private String name;//单词
    private int count;//次数

    public Letter() {
    }

    public Letter(String name){
        super();
        this.name = name;
    }

    public Letter(String name, int count) {
        super();
        this.name = name;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
