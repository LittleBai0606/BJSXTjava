package cn.bjsxt.net.tcp.chat.demo04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * 1、创建客户端:发送数据+接收数据
 * 2、写出数据 输出流
 * 3、读取数据 输入流
 * Created by BenWhite on 2017/7/1.
 */
public class Client {

    public static void main(String[] args) throws IOException {


        System.out.println("请输入用户名:");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();
        if(name.equals("") || name.length() <= 2) {
            return;
        }

        Socket client = new Socket("localhost", 9999);
        //控制台输入流
        new Thread(new Send(client, name)).start();
        new Thread(new Recevie(client)).start();

    }
}
