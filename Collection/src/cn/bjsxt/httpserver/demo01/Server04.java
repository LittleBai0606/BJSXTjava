package cn.bjsxt.httpserver.demo01;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by BenWhite on 2017/7/3.
 */
public class Server04 {

    private ServerSocket server;
    public static final String CRLF = "\r\n";
    public static final String BLANK = " ";

    public static void main(String[] args) {
        Server04 server = new Server04();
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
            byte[] data = new byte[20480];
            int len = client.getInputStream().read(data);
            String requestInfo = new String(data, 0 ,len).trim();
            System.out.println(requestInfo);


            //响应
            Response response = new Response(client.getOutputStream());
            response.println("<html><head><title>HTTP响应示例</title>");
            response.println("</head><body>Hello Tomcat! </body></html>");
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
