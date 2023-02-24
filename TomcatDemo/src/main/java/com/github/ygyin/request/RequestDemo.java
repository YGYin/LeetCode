package com.github.ygyin.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;


@WebServlet("/req")
public class RequestDemo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 解决乱码：POST getReader()，设置输入流的编码
        req.setCharacterEncoding("UTF-8");


        // System.out.println("Get...");
        // 1. 获取所有参数的 map 集合
        Map<String, String[]> map = req.getParameterMap();
        for (String key : map.keySet()) {
            // e.g username: YG, YYG
            System.out.print(key + ":");
            // values
            String[] values = map.get(key);
            for (String value : values) {
                System.out.print(value + " ");
            }
            System.out.println();
        }

        System.out.println("-------------");
        // 2. 根据 key 获取参数值，数组
        String[] hobbies = req.getParameterValues("hobby");
        for (String hobby : hobbies) {
            System.out.println(hobby);
        }

        // 3. 根据 key 获取单个参数值
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println(username + " " + password);

        // GET 获取参数的方式 getQueryString()
        // 乱码原因：tomcat 进行 URL 解码时，默认字符集为 ISO-8859-1
        String s = new String(username.getBytes("ISO-8859-1"), "utf-8");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // POST: 底层通过 getReader 获取字符输入流读取数据
        doGet(req, resp);
    }
}
