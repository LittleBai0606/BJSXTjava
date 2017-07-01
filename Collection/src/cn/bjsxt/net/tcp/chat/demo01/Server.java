package cn.bjsxt.net.tcp.chat.demo01;

import sun.misc.Cleaner;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 1、创建服务器
 * 2、写出数据 输出流
 * 3、读取数据 输入流
 * Created by BenWhite on 2017/7/1.
 */
public class Server {

    public static void main(String[] args) throws IOException {

        ServerSocket server = new ServerSocket(9999);
        Socket client = server.accept();

        DataInputStream dis = new DataInputStream(client.getInputStream());
        String msg = dis.readUTF();
        System.out.println("收到的数据为:" + msg);

        DataOutputStream dos = new DataOutputStream(client.getOutputStream());
        dos.writeUTF("服务器-->" + msg);
        dos.flush();

    }
}
