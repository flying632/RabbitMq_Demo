package com.example.rabbitmq_demo.listener;

import com.alibaba.fastjson.JSONObject;
import com.example.rabbitmq_demo.entity.Msg;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;
import org.springframework.stereotype.Component;

/**
 * @author fengyuluo
 * @createTime 17:32 2018/10/16
 */
@Slf4j
@Component
public class ConsumerListener implements ChannelAwareMessageListener {

    @Override
    @RabbitListener(queues = "order_info_normal_queue", returnExceptions="true")
    public void onMessage(Message message, Channel channel) throws Exception {
        Msg msg = JSONObject.parseObject(new String(message.getBody()),Msg.class);
        log.info("consume : " + msg.getSendMsg());
    }
}
