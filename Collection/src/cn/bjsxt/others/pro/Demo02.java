package cn.bjsxt.others.pro;

import java.io.*;
import java.util.Properties;

/**
 * Created by BenWhite on 2017/6/22.
 * 使用Properties输出到文件
 * 资源配置文件
 */
public class Demo02 {

    public static void main(String[] args) throws IOException {
        //创建对象
        Properties pro = new Properties();
        //存储
        pro.setProperty("driver", "oracle.jdbc.driver.OracleDriver");
        pro.setProperty("url", "jdbc:oracle:thin:@localhost:1581");
        pro.setProperty("user", "Benwhite");
        pro.setProperty("password", "zxc958255724");

        //存储到D盘根目录 绝对路径
        //pro.store(new FileOutputStream(new File("D:/db.properties")), "db配置");
        //pro.storeToXML(new FileOutputStream(new File("D:/db.xml")), "db配置");
        //相对路径
        //pro.storeToXML(new FileOutputStream(new File("db.properties")), "db配置");

        //读取绝对路径
//        pro.load(new FileReader("D:/db.properties"));
//        String s1 = pro.getProperty("user", "test");
//        System.out.println(s1);

//        读取相对路径
        pro.load(new FileReader("db.properties"));
        String s2 = pro.getProperty("user", "test");
        System.out.println(s2);
    }
}
