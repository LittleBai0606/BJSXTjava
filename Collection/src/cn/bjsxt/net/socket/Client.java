package cn.bjsxt.net.socket;

import java.io.BufferedWriter;
import java.io.IOException;
import java.net.Socket;

/**
 * Created by BenWhite on 2017/7/1.
 * 1、创建客户端 指定端口
 *
 */
public class Client {

    public static void main(String[] args) throws IOException {

        Socket client = new Socket("localhost", 8888);


    }
}
