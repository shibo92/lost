package com.shibo.lost.controller;

import com.alibaba.fastjson.JSON;
import com.shibo.lost.entity.User;
import com.shibo.lost.fiegn.client.ContentClient;
import com.shibo.lost.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author by shibo on 2020/8/20.
 */
@Controller
public class HelloWorldController {
    @Autowired
    private ContentClient contentClient;
    @Autowired
    private UserService userService;

    @RequestMapping("/hw")
    @ResponseBody
    public String helloWorld() {
        User user = userService.getUserById(1L);
        return JSON.toJSONString(user);
    }

    @RequestMapping("/content/hw")
    @ResponseBody
    public String contentHelloWorld() {
        return contentClient.helloWorld() + "connnnn";
    }
}
