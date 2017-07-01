package cn.bjsxt.IO.byteIO;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 * Created by BenWhite on 2017/6/25.
 */
public class CopyDirDemo {

    public static void main(String[] args) {
        //源目录
        String srcPath = "D:/w3school";
        //目标目录
        String destPath = "D:/English";
        File src = new File(srcPath);
        File dest = null;
        if(src.isDirectory()){//文件夹
            dest = new File(destPath, src.getName());
        }
        copyDir(src, dest);
    }

    public static void copyDir(File src, File dest){
        if(src.isFile()){
            try {
                FileUtils.copyFile(src, dest);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else if (src.isDirectory()){
            //确保目标文件夹存在
            dest.mkdirs();
            //获取下一级目录|文件
            for (File sub:src.listFiles()){
                copyDir(sub, new File(dest, sub.getName()));
            }
        }
    }
}
