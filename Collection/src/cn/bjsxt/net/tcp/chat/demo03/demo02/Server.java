package cn.bjsxt.net.tcp.chat.demo03.demo02;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * 1、创建服务器
 * 2、写出数据 输出流
 * 3、读取数据 输入流
 * Created by BenWhite on 2017/7/1.
 */
public class Server {

    private List<MyChannel> all = new ArrayList<MyChannel>();

    public static void main(String[] args) throws IOException {
        new Server().start();
    }

    public void start() throws IOException {
        ServerSocket server = new ServerSocket(9999);
        while (true){
            Socket client = server.accept();
            MyChannel channel = new MyChannel(client);
            all.add(channel);
            new Thread(channel).start();
        }
    }
/*
*   一个客户端一条通路
*   输入流
*   输出流
* */
 class MyChannel implements Runnable{

        private DataInputStream dis = null;
        private DataOutputStream dos = null;
        private boolean isRunning = true;

        public MyChannel(Socket client) {
            try {
                dis = new DataInputStream(client.getInputStream());
                dos = new DataOutputStream(client.getOutputStream());
            } catch (IOException e) {
                e.printStackTrace();
                isRunning = false;
                CloseUtil.closeAll(dos, dis);
                all.remove(this);
            }
        }
        private  String receive() {
            String msg = "";
            try {
                msg = dis.readUTF();
            } catch (IOException e) {
                e.printStackTrace();
                CloseUtil.closeAll(dis, dos);
                isRunning = false;
                all.remove(this);
            }
            return msg;
        }

        private void send(String msg) {
            if(msg == null || msg.equals("")) {
                return;
            }
            try {
                dos.writeUTF(msg);
                dos.flush();
            } catch (IOException e) {
                e.printStackTrace();
                CloseUtil.closeAll(dis, dos);
                isRunning = false;
                all.remove(this);
            }
        }

        /*
        * 发送给其他客户端
        * */

        private void  sendOthers() {
            String msg = this.receive();
            //便利容器
            for (MyChannel other:all) {
                if(other == this) {
                    continue;
                }
                other.send(msg);
            }
        }
        @Override
        public void run() {
            while (isRunning) {
                sendOthers();
            }
        }
    }
}
