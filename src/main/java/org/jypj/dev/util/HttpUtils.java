package org.jypj.dev.util;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpUtils {

    /**
     * 通过HttpURLConnection模拟post表单提交
     *
     * @param path
     * @param params 例如"name=zhangsan&age=21"
     * @return 数据结果字符串 可以是xml json html 等
     * @throws Exception
     */
    public static String sendPostRequestByForm(String path, String params) throws Exception {
        URL url = new URL(path);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("POST");// 提交模式
        conn.setRequestProperty("token", "");
        conn.setConnectTimeout(5000);//连接超时 单位毫秒
        // conn.setReadTimeout(2000);//读取超时 单位毫秒
        conn.setDoOutput(true);// 是否输入参数
        byte[] bypes = params.toString().getBytes("UTF-8");
        conn.getOutputStream().write(bypes);// 输入参数
        InputStream inStream = conn.getInputStream();
        byte[] data = StreamTool.readInputStream(inStream);
        String text = new String(data, "UTF-8");
        return text;
    }

    /**
     * 通过HttpURlConnection模拟get请求
     *
     * @param path
     * @return 数据结果字符串 可以是xml json html 等
     * @throws Exception
     */
    public static String sendGetRequestForService(String path) throws Exception {
        URL url = new URL(path);
        System.out.println(url.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setConnectTimeout(5 * 1000);
        conn.setRequestProperty("Authorization", "Bearer YWMtCfz9Fh3LEee-flHV999EdgAAAAAAAAAAAAAAAAAAAAF0F3KQEooR55VGOyVYV8aOAgMAAAFbVxCMywBPGgAXlouuHrOfzhSp2mlA7UB5GjEGAKVStW4nm_4U6cxelQ");
        conn.setRequestMethod("GET");
        InputStream inStream = conn.getInputStream();
        byte[] data = StreamTool.readInputStream(inStream);
        String text = new String(data, "UTF-8");
        return text;
    }

}