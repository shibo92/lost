package com.shibo.lost.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author by shibo on 2020/8/20.
 */
@Controller
public class HelloworldController {
    @RequestMapping("/hw")
    @ResponseBody
    public String helloWorld(){
        return "hello World";
    }
}
