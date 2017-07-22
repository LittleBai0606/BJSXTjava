package cn.bjsxt.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class Demo03 {

    public static void main(String[] args) {
        try {
            Class clazz = Class.forName("cn.bjsxt.annotation.SxtStudent");
            //获得类的所有的注解
            Annotation[] annotations = clazz.getAnnotations();
            for (Annotation a: annotations) {
                System.out.println(a);
            }
            //获得类的指定的注解
            SxtTable st = (SxtTable) clazz.getAnnotation(SxtTable.class);
            System.out.println(st.value());
            //获得类的属性的注解
            Field f = clazz.getDeclaredField("studentName");
            SxtFiled sf = f.getAnnotation(SxtFiled.class);
            System.out.println(sf.columnName() + "--" + sf.type() + "--" + sf.length());

            //根据获得的表名、字段的信息，拼出DDL语句，使用JDBC执行这个SQL，在数据库中生成相关的表
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}
