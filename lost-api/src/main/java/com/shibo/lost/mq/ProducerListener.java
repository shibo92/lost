package com.shibo.lost.mq;

import com.shibo.lost.entity.User;
import com.shibo.lost.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.LocalTransactionState;
import org.apache.rocketmq.spring.annotation.RocketMQTransactionListener;
import org.apache.rocketmq.spring.core.RocketMQLocalTransactionListener;
import org.apache.rocketmq.spring.core.RocketMQLocalTransactionState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author by walle on 2021/6/23.
 */
@Slf4j
@Component
@RocketMQTransactionListener()
public class ProducerListener implements RocketMQLocalTransactionListener {
    private ConcurrentHashMap<String, Object> localTrans = new ConcurrentHashMap<>();

    @Autowired
    private UserService userService;

    @Override
    public RocketMQLocalTransactionState executeLocalTransaction(Message message, Object o) {
        try {
            log.info("事务消息本地事务开始，msg:{}, Object:{}", message, o);
            GenericMessage genericMessage = (GenericMessage) o;
            String s = (String) genericMessage.getPayload();
            boolean result =  Integer.parseInt(s) % 2 == 0;
            if (result) {
                localTrans.put(message.getHeaders().getId() + "", message.getPayload());
                log.info("【本地业务执行完毕】 msg:{}, Object:{}", message, o);
            } else {
                log.info("【本地业务执行异常】 msg:{}, Object:{}", message, o);
            }
            return result ? RocketMQLocalTransactionState.COMMIT : RocketMQLocalTransactionState.UNKNOWN;
        } catch (Exception e) {
            e.printStackTrace();
            log.error("【执行本地业务异常】 exception message:{}", e.getMessage());
            return RocketMQLocalTransactionState.ROLLBACK;
        }
    }

    @Override
    public RocketMQLocalTransactionState checkLocalTransaction(Message message) {
        log.info("【执行检查任务】localTrans.size():{}", localTrans.size());
        if (localTrans.size() == 0) {
            return RocketMQLocalTransactionState.ROLLBACK;
        }
        return RocketMQLocalTransactionState.COMMIT;
    }
}
