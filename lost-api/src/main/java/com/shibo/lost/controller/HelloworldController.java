package com.shibo.lost.controller;

import com.shibo.lost.fiegn.client.ContentClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author by shibo on 2020/8/20.
 */
@Controller
public class HelloworldController {
    @Autowired
    private ContentClient contentClient;


    @RequestMapping("/hw")
    @ResponseBody
    public String helloWorld() {
        return "hello World";
    }

    @RequestMapping("/content/hw")
    @ResponseBody
    public String contentHelloWorld() {
        return contentClient.helloWorld() + "connnnn";
    }
}
