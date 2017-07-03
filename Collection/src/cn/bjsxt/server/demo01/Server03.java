package cn.bjsxt.server.demo01;

import com.sun.xml.internal.ws.client.ResponseContext;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.cert.CRL;
import java.util.Date;

/**
 * Created by BenWhite on 2017/7/3.
 */
public class Server03 {

    private ServerSocket server;
    public static final String CRLF = "\r\n";
    public static final String BLANK = " ";

    public static void main(String[] args) {
        Server03 server = new Server03();
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


            //相应
            StringBuilder responseContext = new StringBuilder();
            responseContext.append("<html><head><title>HTTP响应示例</title>" + "</head><body>Hello Tomcat! </body></html>");

            StringBuilder response = new StringBuilder();
            //1) HTTP协议版本、状态代码、描述
            response.append("HTTP/1.1").append(BLANK).append("200").append(BLANK).append("OK").append(CRLF);
            //2) 响应头
            response.append("Server:bjsxt").append(BLANK).append("Server/0.0.1").append(CRLF);
            response.append("Date:").append(new Date()).append(CRLF);
            response.append("Content-type:text/html;charset=GBK").append(CRLF);
            //正文长度
            response.append("Content-Length").append(responseContext.toString().getBytes().length).append(CRLF);
            //3）正文
            response.append(CRLF);
            response.append(responseContext);

            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
            bw.write(response.toString());
            bw.flush();
            bw.close();

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
