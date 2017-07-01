package cn.bjsxt.net.socket;

import java.io.*;
import java.net.Socket;

/**
 * Created by BenWhite on 2017/7/1.
 * 1、创建客户端 指定端口
 *
 */
public class Client {

    public static void main(String[] args) throws IOException {

        Socket client = new Socket("localhost", 8888);
        //接受数据
        /*
        BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));

        String echo = br.readLine();//“欢迎使用"没有行结束符，不会读取(阻塞式)

        System.out.println(echo);
        */
        DataInputStream dis = new DataInputStream(client.getInputStream());
        String msg = dis.readUTF();
        System.out.println(msg);
    }


}
