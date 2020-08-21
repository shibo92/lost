package com.shibo.lost;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author by shibo on 2020/8/20.
 */
@Controller
public class HelloWorldController {

    @GetMapping("/content/hw")
    @ResponseBody
    public String contentHelloWorld() {
        return "content hello world";
    }
}
