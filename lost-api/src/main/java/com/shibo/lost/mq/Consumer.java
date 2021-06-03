package com.shibo.lost.mq;

import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author by Administrator on 2021/6/3.
 */
@Component
@RocketMQMessageListener(consumerGroup = "${xc.rocketmq2.string-consumer-group}", topic = "${xc.rocketmq2.topic-string}")
public class Consumer implements RocketMQListener<String> {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public void onMessage(String message) {
        log.info("消费字符串消息{}", message);
    }
}