package cn.bjsxt.map;

import java.util.*;

/**
 * Created by BenWhite on 2017/6/21.
 */
public class MapDemo03 {

    public static void main(String[] args) {
        //考试
        List<Student> stuList = exam();
        //分析成绩
        Map<String, ClassRoom> map = count(stuList);
        //查看成绩
        view(map);
    }

    /*
     *统计分析
     */
    public static Map<String, ClassRoom> count(List<Student> list){
        Map<String, ClassRoom> map = new HashMap<String, ClassRoom>();
        //遍历List
        for (Student stu : list){
            //分拣 查看是否存在该编号的班级
            String no = stu.getNo();//班级编号
            double score = stu.getScore();//成绩
            //如果不存在，创建班级
            ClassRoom room = map.get(stu.getNo());
            if(null == room){
                room = new ClassRoom(no);
                map.put(no, room);
            }
            //存在则放入学生
            room.getStuList().add(stu);
            room.setTotal(room.getTotal() + score);

        }
        return map;
    }
    /*
     * 查看每个班的总分和平均分 --> 遍历map
     */
    public static void view(Map<String, ClassRoom> map){
        Set<String> keys = map.keySet();
        //获取迭代器对象
        Iterator<String> keysIt = keys.iterator();
        while (keysIt.hasNext()){
            String no = keysIt.next();
            ClassRoom room = map.get(no);
            //查看总分，计算平均分
            double total = room.getTotal();
            double avg = total / room.getStuList().size();
            System.out.println(no + "-->" + total + "-->" + avg);
        }
    }
    public static List<Student> exam(){
        List<Student> list = new ArrayList<Student>();
        list.add(new Student("student1", "a", 80));
        list.add(new Student("student2", "b", 70));
        list.add(new Student("student3", "a", 90));
        list.add(new Student("student4", "b", 67));
        list.add(new Student("student5", "a", 85));
        list.add(new Student("student6", "b", 73));
        return list;
    }

}
