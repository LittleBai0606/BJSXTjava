package cn.bjsxt.sort.col;

/**
 * Created by BenWhite on 2017/6/22.
 */
public class Person {
    private final String name;//名称
    private final int handsome;//帅气指数

    public Person() {
        name = null;
        handsome = 0;
    }

    public Person(String name, int handsome) {
        this.name = name;
        this.handsome = handsome;
    }

    public String getName() {
        return name;
    }

    public int getHandsome() {
        return handsome;
    }

    @Override
    public String toString() {
        return "姓名" + this.getName() + ", 帅气指数:" + this.getHandsome() + "\n";
    }
}
