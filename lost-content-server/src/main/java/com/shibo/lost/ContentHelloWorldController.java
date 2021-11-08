package com.shibo.lost;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author by shibo on 2020/8/20.
 */
@Controller
public class ContentHelloWorldController {

    @GetMapping("/content/api/hw")
    @ResponseBody
    public String contentHelloWorld() throws InterruptedException {
        return "content hello world";
    }

    @GetMapping("/sentinel/content/api/hw")
    @ResponseBody
    public String sentinelContentHelloWorld() {
        // int a = new Random().nextInt(5) + 1;
        // int ma = a * 1000 + 5000;
        // System.out.println("请求延迟:" + ma + "s");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "sentinel content hello world";
    }
}
