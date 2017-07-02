package cn.bjsxt.net.tcp.chat.demo03;

import java.io.IOException;
import java.net.Socket;

/**
 * 1、创建客户端:发送数据+接收数据
 * 2、写出数据 输出流
 * 3、读取数据 输入流
 * Created by BenWhite on 2017/7/1.
 */
public class Client {

    public static void main(String[] args) throws IOException {


        Socket client = new Socket("localhost", 9999);
        //控制台输入流
        new Thread(new Send(client)).start();
        new Thread(new Recevie(client)).start();

    }
}
