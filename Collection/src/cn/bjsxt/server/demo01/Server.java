package cn.bjsxt.server.demo01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by BenWhite on 2017/7/3.
 */
public class Server {

    private ServerSocket server;

    public static void main(String[] args) {
        Server server = new Server();
        server.start();
        server.receive();
        server.stop();
    }

    public void start() {
        try {
            server = new ServerSocket(8888);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void receive() {
        String msg = "";
        BufferedReader br = null;
        StringBuilder sb = new StringBuilder();
        try {
            Socket client = server.accept();
            br = new BufferedReader(new InputStreamReader(client.getInputStream()));
            while ((msg = br.readLine()).length() > 0 ) {
                sb.append(msg);
                sb.append("\r\n");
                if(msg == null) {
                    break;
                }
            }
            String requestInfo = sb.toString().trim();
            System.out.println(requestInfo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void stop() {
        if(server != null) {
            try {
                server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
