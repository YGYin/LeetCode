package com.github.ygyin.response;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/resp1")
public class ResponseDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Resp 1 tries to redirect");

//        // 重定向
//        // 1. 设置响应状态码 302
//        response.setStatus(302);
//        // 2. 设置响应头 Location，需要再 resq2 前加虚拟路径
//        response.setHeader("Location","/TomcatDemo_war/resp2");

        // 简化方式完成重定向，动态获取虚拟目录
        String contextPath = request.getContextPath();
        response.sendRedirect(contextPath + "/TomcatDemo_war/resp2");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
