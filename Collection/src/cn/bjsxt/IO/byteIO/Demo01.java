package cn.bjsxt.IO.byteIO;

import java.io.*;

/**
 * Created by BenWhite on 2017/6/24.
 */
public class Demo01 {

    public static void main(String[] args) {
        //1、建立联系，File对象
        File src = new File("D:/db.xml");
        //2、选择流
        InputStream is = null;
        try {
            is = new FileInputStream(src);
            //3、操作，不断读取， 缓冲数组
            byte[] car = new byte[10];
            int len = 0;//接受实际读取的大小
            while (-1 != (len = is.read(car))){
                //输出 字节数组转字符串
                String info = new String(car, 0 ,len);
                System.out.println(info);
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(null != is){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
