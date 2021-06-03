package com.shibo.lost.controller;

import com.alibaba.fastjson.JSON;
import com.shibo.lost.entity.User;
import com.shibo.lost.fiegn.client.ContentClient;
import com.shibo.lost.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author by shibo on 2020/8/20.
 */
@Slf4j
@Controller
public class HelloWorldController {
    @Autowired
    private ContentClient contentClient;
    @Autowired
    private UserService userService;
    @Autowired
    private RocketMQTemplate rocketMQTemplate;


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

    /**
     * 同步发送
     * 页面访问http://localhost:8080/rocketmq/sync
     *
     * @throws Exception
     */
    @GetMapping("mq/test/sync")
    public void sync() {
        SendResult sendResult = rocketMQTemplate.syncSend("topic_string", "Hello world!");
        log.info("同步发送字符串{}, 发送结果{}", "topic_string", sendResult);
    }
}
