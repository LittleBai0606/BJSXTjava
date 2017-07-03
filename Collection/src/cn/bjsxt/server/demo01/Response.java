package cn.bjsxt.server.demo01;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.security.cert.CRL;
import java.util.Date;


/**
 * Created by BenWhite on 2017/7/3.
 */
public class Response {

    private StringBuilder headInfo;

    private static final String CRLF = "\r\n";
    private static final String BLANK = " ";
    //流
    private BufferedWriter bw = null;

    private int len = 0;
    //正文
    private StringBuilder content;

    public Response() {
        headInfo = new StringBuilder();
        content = new StringBuilder();
        len = 0;
    }

    public Response(OutputStream os) {
        this();
        bw = new BufferedWriter(new OutputStreamWriter(os));
    }

    public Response(Socket client) {
        this();
        try {
            bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
        } catch (IOException e) {
            e.printStackTrace();
            headInfo = null;
        }
    }

    /*构建正文*/
    public Response print(String info){
        content.append(info);
        len += info.getBytes().length;
        return this;
    }

    public Response println(String info){
        content.append(info).append(CRLF);
        len += (info + CRLF).getBytes().length;
        return this;
    }

    private void createHeadInfo(int code) {
        //1) HTTP协议版本、状态代码、描述
        headInfo.append("HTTP/1.1").append(BLANK).append(code).append(BLANK);
        switch (code) {
            case 200:
                headInfo.append("OK");
                break;
            case 404:
                headInfo.append("NOT FOUND");
                break;
            case 500:
                headInfo.append("SERVER ERROR");
                break;
        }
        headInfo.append(CRLF);
        //2) 响应头
        headInfo.append("Server:bjsxt").append(BLANK).append("Server/0.0.1").append(CRLF);
        headInfo.append("Date:").append(new Date()).append(CRLF);
        headInfo.append("Content-type:text/html;charset=GBK").append(CRLF);
        //正文长度
        headInfo.append("Content-Length").append(len).append(CRLF);
        headInfo.append(CRLF);
    }
    //推送到客户端
    void pushToClient(int code) throws IOException {
        if(headInfo == null) {
            code = 500;
        }
        createHeadInfo(code);
        //头信息+分隔符
        bw.append(headInfo.toString());
        //正文
        bw.append(content.toString());
        bw.flush();
    }

    public void close() {
        CloseUtil.closeAll(bw);
    }
}
