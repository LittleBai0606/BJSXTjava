package cn.bjsxt.others.pro;

import java.util.Properties;

/**
 * Created by BenWhite on 2017/6/22.
 * Properties 资源配置文件的读写
 * 1、key与value只能为字符串
 * 2、存储与读取
 */
public class Demo1 {

    public static void main(String[] args) {
        //创建对象
        Properties pro = new Properties();
        //存储
        pro.setProperty("driver", "oracle.jdbc.driver.OracleDriver");
        pro.setProperty("url", "jdbc:oracle:thin:@localhost:1581");
        pro.setProperty("user", "Benwhite");
        pro.setProperty("password", "zxc958255724");

        //获取
        String url = pro.getProperty("url", "test");
        System.out.println(url);
    }
}
