package cn.bjsxt.IO.charIO;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * Created by BenWhite on 2017/6/25.
 */
public class Demo02 {

    public static void main(String[] args) {

        File dest = null;
        dest = new File("D:/char.txt");
        Writer writer = null;
        try {
            writer = new FileWriter(dest);
            //写出
            String msg = "锄禾日当午\r\n汗滴禾下土\r\n谁知盘中餐\r\n粒粒皆辛苦\r\n";
            writer.write(msg);
            writer.append("这首诗很出名!");
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(null != writer){
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
