package com.github.ygyin.request;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class URLDemo {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String username = "面包";
        // 1. URL 编码
        String encode = URLEncoder.encode(username, "utf-8");
        System.out.println(encode);

        // 2. URL 解码
//        String decode = URLDecoder.decode(encode, "utf-8");
        // Tomcat 使用 ISO-8859-1 解码
        String decode = URLDecoder.decode(encode, "ISO-8859-1");
        System.out.println(decode);

        // 3. 将其转换为直接数据
        byte[] bytes = decode.getBytes("ISO-8859-1");

        // 4. 将字节数组转为字符串
        String s = new String(bytes, "utf-8");
        System.out.println(s);

    }
}
