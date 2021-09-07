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
 *
 * 生产者发送半消息到 MQ Server，暂时不能投递，不会被消费
 * 半消息发送成功后，生产者这边执行本地事务
 * 生产者根据本地事务执行结果，向 MQ Server 发送 commit 或 rollback 消息进行二次确认
 * 如果 MQ Server 接收到的 commit，则将半消息标记为可投递状态，此时消费者就能进行消费；如果收到的是 rollback，则将半消息直接丢弃，不会进行消费
 * 如果 MQ Server 未收到二次确认消息，MQ Server 则会定时（默认1分钟）向生产者发送回查消息，检查本地事务状态，然后生产者根据本地事务回查结果再次向 MQ Server 发送 commit 或 rollback消息
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
