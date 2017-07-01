package cn.bjsxt.others.guava;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

import java.util.Map;
import java.util.Set;

/**
 * Created by BenWhite on 2017/6/23.
 */
public class Demo07 {

    public static void main(String[] args) {
        Table<String, String, Integer> tables = HashBasedTable.create();
        //测试数据
        tables.put("a", "javaSE", 80);
        tables.put("b", "javaSE", 90);
        tables.put("a", "oracle", 100);
        tables.put("c", "oracle", 95);

        //所有行数据
        Set<Table.Cell<String, String, Integer>> cells = tables.cellSet();
        for (Table.Cell<String, String, Integer> temp : cells){
            System.out.println(temp.getRowKey() + "-->" + temp.getColumnKey() + "-->" + temp.getValue());
        }
        System.out.println("-----------------------------------------");
        System.out.print("学生\t");
        //所有的课程
        Set<String> cours = tables.columnKeySet();
        for (String temp : cours){
            System.out.print(temp + "\t");
        }
        System.out.println();
        //所有的学生
        Set<String> stus = tables.rowKeySet();
        for (String temp : stus){
            System.out.print(temp + "\t");
            Map<String, Integer> scores = tables.row(temp);
            for (String c : cours){
                System.out.print(scores.get(c) + "\t");
            }
            System.out.println();
        }

    }
}
