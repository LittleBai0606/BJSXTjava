package cn.bjsxt.others.en;

import java.util.Enumeration;
import java.util.Vector;

/**
 * Created by BenWhite on 2017/6/22.
 * 1、判断hasMoreElements()
 * 2、获取nextElement()
 */
public class Demo01 {

    public static void main(String[] args) {
        Vector<String> vector = new Vector<String>();
        vector.add("javaSE");
        vector.add("html");
        vector.add("oracle");

        //遍历该vector
        Enumeration<String> en = vector.elements();
        while (en.hasMoreElements()){
            System.out.println(en.nextElement());
        }
    }
}
