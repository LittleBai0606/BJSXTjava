package cn.bjsxt.IO.byteIO;

import java.io.*;

/**
 * Created by BenWhite on 2017/6/24.
 */
public class Demo02 {

    public static void main(String[] args) {

        File test = new File("D:/test.txt");
        OutputStream os = null;
        try {
            os = new FileOutputStream(test, true);
            String str = "bjsxt is very good \r\n";
            //字符串转字节数组
            byte[] data = str.getBytes();
            os.write(data, 0 , data.length);
            os.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("文件未找到...");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("文件写出失败...");
        }finally {
            if(null != os){
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
