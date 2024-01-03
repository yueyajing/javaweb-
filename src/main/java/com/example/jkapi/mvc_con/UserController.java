package com.example.jkapi.mvc_con;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {

    @PostMapping("/login1111")
    public String login(@RequestParam String username, @RequestParam String password) {
        // 处理账号密码登录逻辑
        // ...

        Map<String, String> response = new HashMap<>();
        response.put("message", "登录成功");
        return "redirect:/index.html";
    }
    @PostMapping("/login11")
    public String login1(@RequestParam String username, @RequestParam String password) {
        // 处理账号密码登录逻辑
        // ...

        return "redirect:/index.html";
    }

}
