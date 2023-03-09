package com.github.ygyin.controller;

import com.github.ygyin.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

// 2.1 定义 controller (bean)
@Controller
@RequestMapping("/user")
public class UserController {
    //  2.2 设置当前响应操作的访问路径
    @RequestMapping("/save")
//  2.3 设置当前操作的返回值类型，将返回值作为响应体的内容返回给请求方
    @ResponseBody
    public String save(String name) {
        System.out.println("User's save module is running...");
        System.out.println(name);
        return "{'module' : 'SpringMVC'}";
    }

    @RequestMapping("/pojo")
    @ResponseBody
    public String pojo(User user) {
        System.out.println("User's save module is running...");
        System.out.println(user);
        return "{'module' : 'SpringMVC_pojo'}";
    }

    // 由于 json 数据存在与请求体中
    // 所以用 @RequestBody 获取请求体中的数据传递给请求参数
    // 通过 pojo 获取 json 同理
    @RequestMapping("/listForJson")
    @ResponseBody
    public String listForJson(@RequestBody List<String> list) {
        System.out.println("User's save module is running...");
        System.out.println(list);
        return "{'module' : 'SpringMVC_listForJson'}";
    }
}
