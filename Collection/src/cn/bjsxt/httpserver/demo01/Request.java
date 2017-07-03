package cn.bjsxt.httpserver.demo01;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * Created by BenWhite on 2017/7/3.
 */
public class Request {
    //请求方式
    private String method;
    //请求资源
    private String url;
    //请求参数
    private Map<String, List<String>> parameterMapValues;

    //内部
    public static final String CRLF = "\r\n";
    public static final String BLANK = " ";
    private InputStream is = null;
    private String requestInfo;

    public Request() {
        method = "";
        url = "";
        parameterMapValues = new HashMap<>();
        requestInfo = "";
    }

    public Request(InputStream is) {
        this();
        this.is = is;
        byte[] data = new byte[20480];
        try {
            int len = is.read(data);
            requestInfo = new String(data, 0, len);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        //分析头信息
        parseRequestInfo();
    }

    private void parseRequestInfo() {
        if( requestInfo == null || (requestInfo = requestInfo.trim()).equals("")) {
            return;
        }

        /*
         *从信息的首行分解出:请求方式、请求路径、请求参数(get可能存在)
         * 如：GET /index.html?name=123&pwd=456 HTTP/1.1
         * 如果为post方式，请求参数可能在最后正文中
         *
         *  */
        String paramString = "";//接收请求参数
        String firstLine = requestInfo.substring(0, requestInfo.indexOf(CRLF));
        int idx = requestInfo.indexOf("/");
        this.method = firstLine.substring(0, idx).trim();
        String urlStr = firstLine.substring(idx, firstLine.indexOf("HTTP/")).trim();
        if(this.method.equalsIgnoreCase("post")) {
            this.url = urlStr;
            paramString = requestInfo.substring(requestInfo.lastIndexOf(CRLF)).trim();
        }else if(this.method.equalsIgnoreCase("get")) {
            if(urlStr.contains("?")) {//是否存在参数
                String[] urlArray = urlStr.split("\\?");
                this.url = urlArray[0];
                paramString = urlArray[1];
            }else {
                this.url = urlStr;
            }
        }

        //不存在请求参数
        if(paramString.equals("")) {
            return;
        }
        //存在，将请求参数封装到Map中
        parseParams(paramString);
    }

    private void parseParams(String paramString) {
        //分割，将字符串转成数组
        StringTokenizer token = new StringTokenizer(paramString, "&");
        while (token.hasMoreElements()) {
            String keyValue = token.nextToken();
            String[] keyValues = keyValue.split("=");
            if(keyValues.length == 1) {
                keyValues = Arrays.copyOf(keyValues, 2);
                keyValues[1] = null;
            }
            //转换成Map
            String key = keyValues[0].trim();
            String value = null == keyValues[1]?null:keyValues[1].trim();
            if(parameterMapValues.containsKey(key)) {
                parameterMapValues.put(key, new ArrayList<String>());
            }
            List<String> values = parameterMapValues.get(key);
            values.add(value);
        }
    }
    /*
    *根据页面的name 获取对应的多个值
    * */
    public String[] getParameterValues(String name) {
        List<String> values = null;
        if((values =parameterMapValues.get(name)) == null) {
            return null;
        }else {
            return values.toArray(new String[0]);
        }
    }
    /*
     *根据页面的name 获取对应的值
     * */
    public String getParameter(String name) {
        String[] values = getParameterValues(name);
        if(values == null) {
            return null;
        }
        return values[0];
    }
}
