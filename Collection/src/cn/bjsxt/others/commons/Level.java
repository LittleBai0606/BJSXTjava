package cn.bjsxt.others.commons;

/**
 * Created by BenWhite on 2017/6/24.
 */
public class Level {

    private String name;
    private String level;

    public Level() {
    }

    public Level(String name, String level) {
        this.name = name;
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "（码农：" + this.getName() + "，水平：" + this.getLevel() + "）\n";
    }
}
