package cn.bjsxt.IO.charIO;

import java.io.*;

/**
 * Created by BenWhite on 2017/6/25.
 */
public class Demo01 {

    public static void main(String[] args) {

        //创建源， 建立联系
        File src = new File("D:/data.txt");
        //选择流
        Reader reader = null;
        try {
            reader = new FileReader(src);
            char[] flush = new char[1024];
            int len = 0;
            while (-1 != (len = reader.read(flush))){

                String str = new String(flush, 0, len);
                System.out.println(str);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("源文件不存在");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("文件读取失败");
        }finally {
            if(null != reader){
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    System.out.println("关闭失败");
                }
            }
        }
    }
}
