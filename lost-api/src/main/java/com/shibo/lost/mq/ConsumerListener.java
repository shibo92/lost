/*
package com.shibo.lost.mq;

import com.alibaba.fastjson.JSON;
import com.shibo.lost.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.apache.rocketmq.spring.core.RocketMQPushConsumerLifecycleListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;

*/
/**
 * @author by Administrator on 2021/6/23.
 *//*

@Slf4j
@Component
@RocketMQMessageListener(topic = "topic_string", consumerGroup = "transaction_consumer_group")
public class ConsumerListener implements RocketMQListener<MessageExt>, RocketMQPushConsumerLifecycleListener {

    @Autowired
    UserService userService;

    @Override
    public void prepareStart(DefaultMQPushConsumer defaultMQPushConsumer) {
        defaultMQPushConsumer.registerMessageListener((MessageListenerConcurrently)(exts, context) ->{
            try {
                log.info("【获取消息】exts:{}", JSON.toJSONString(exts));
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            } catch (Exception e) {
                e.printStackTrace();
                log.error("【消费消息失败】，message：{}", e.getMessage());
                return ConsumeConcurrentlyStatus.RECONSUME_LATER;
            }
        });
    }

    @Override
    public void onMessage(MessageExt messageExt) {
        String msg = null;
        try {
            msg = new String(messageExt.getBody(),"utf-8");
            log.info("MsgConsumer >>> {}, msgId:{}", msg, messageExt.getMsgId());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            log.error("【消费异常】：{}", e.getMessage());
        }
    }
}
*/
