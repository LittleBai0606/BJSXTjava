package cn.bjsxt.IO.byteIO;

import javax.xml.transform.Templates;
import java.io.*;

/**
 * Created by BenWhite on 2017/6/25.
 */
public class CopyFileDemo {

    public static void main(String[] args) {
        String src = "D:/test.txt";
        String dest = "D:/test2.txt";
        copyFile(src, dest);

    }

    public static void copyFile(String srcPath, String destPath){

        //建立联系,源(存在且为文件), 目的地(文件可以不存在)
        File src = new File(srcPath);
        File dest = new File(destPath);
        if(!src.isFile()){
            System.out.println("只能拷贝文件");
            return;
        }
        //选择流
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(src);
            os = new FileOutputStream(dest);
            //文件拷贝，循环读取+写出
            byte[] flush = new byte[1024];
            int len = 0;
            while (-1 != (len = is.read(flush))){
                os.write(flush, 0, len);
            }
            os.flush();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {

            try {
                os.close();
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
