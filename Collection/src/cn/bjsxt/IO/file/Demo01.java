package cn.bjsxt.IO.file;

import java.io.File;

/**
 * Created by BenWhite on 2017/6/24.
 */
public class Demo01 {

    public static void main(String[] args) {

        String path = "D:/BaiduYunDownload";
        File parent = new File(path);
        printName(parent);
    }

    public static void  printName(File src){
        if(src == null || !src.exists()){
            return;
        }
        System.out.println(src.getAbsolutePath());
        if(src.isDirectory()){
            for (File sub : src.listFiles()){
                printName(sub);
            }
        }
    }
}
