package cn.bjsxt.map;

/**
 * Created by BenWhite on 2017/6/21.
 */
public class Student {

    private String name;//名字
    private String no;//班级
    private double score;//成绩

    public Student() {
    }

    public Student(String name, String no, double score) {
        this.name = name;
        this.no = no;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}
