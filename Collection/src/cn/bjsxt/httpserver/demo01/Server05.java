package cn.bjsxt.httpserver.demo01;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by BenWhite on 2017/7/3.
 */
public class Server05 {

    private ServerSocket server;
    public static final String CRLF = "\r\n";
    public static final String BLANK = " ";

    public static void main(String[] args) {
        Server05 server = new Server05();
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
        try {
            Socket client = server.accept();
           Request req = new Request(client.getInputStream());

            //响应
            Response response = new Response(client.getOutputStream());
            response.println("<html><head><title>HTTP响应示例</title>");
            response.println("</head><body>");
            response.println("欢迎").println(req.getParameter("userName")).println("回来");
            response.println(" </body></html>");
            response.pushToClient(200);
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
