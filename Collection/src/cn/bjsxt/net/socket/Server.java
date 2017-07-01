package cn.bjsxt.net.socket;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by BenWhite on 2017/7/1.
 * 1、创建服务器+端口
 * 2、接受客户端连接（阻R塞式）
 * 3、发送数据+接收数据
 */
public class Server {

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8888);
        Socket socket = server.accept();
        System.out.println("一个客户端客户端连接");

        String msg = "欢迎使用";

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
                socket.getOutputStream()
        ));
        bw.write(msg);
        bw.flush();
        //不要关bw.close()

    }
}
