package cn.bjsxt.net.tcp.chat.demo01;

import javax.xml.crypto.Data;
import java.io.DataInputStream;
import java.io.DataOutputStream;
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
        //输出流
        DataOutputStream dos = new DataOutputStream(client.getOutputStream());
        dos.writeUTF("数据");
        dos.flush();

        DataInputStream dis = new DataInputStream(client.getInputStream());
        String msg = dis.readUTF();
        System.out.println("收到的数据为:" + msg);
    }
}
