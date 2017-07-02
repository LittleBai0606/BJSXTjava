package cn.bjsxt.net.tcp.chat.demo03;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * 接受线程
 * Created by BenWhite on 2017/7/1.
 */
public class Recevie implements Runnable{

    private DataInputStream dis;

    private boolean isRunning = true;

    public Recevie() {
    }

    public Recevie(Socket client) {
        try {
            dis = new DataInputStream(client.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
            isRunning = false;
            CloseUtil.closeAll(dis);
        }
    }
/*
* 接收数据
* */
    public String receive() {
        String msg = "";
        try {
            msg = dis.readUTF();
            return msg;
        } catch (IOException e) {
            e.printStackTrace();
            isRunning = false;
            CloseUtil.closeAll(dis);
        }
        return msg;
    }

    @Override
    public void run() {
        //线程体
        while (isRunning){
            System.out.println(receive());
        }
    }
}
