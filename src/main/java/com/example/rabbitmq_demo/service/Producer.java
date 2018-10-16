package com.example.rabbitmq_demo.service;
import com.alibaba.fastjson.JSONObject;
import com.example.rabbitmq_demo.entity.Msg;
import com.fasterxml.jackson.databind.util.JSONPObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author fengyuluo
 * @createTime 17:17 2018/10/16
 */
@Service
@Slf4j
public class Producer implements RabbitTemplate.ReturnCallback, RabbitTemplate.ConfirmCallback {

    @Autowired
    RabbitTemplate rabbitTemplate;

    public void sendMessge(String sendmsg){
        String exchange = "order_info_exchange";
        String routingKey = "orderInfo.type.normal";
        Msg msg = new Msg(exchange,routingKey,sendmsg);
        String json = JSONObject.toJSONString(msg);
        log.info("produce : " + json);
        rabbitTemplate.convertAndSend(exchange,routingKey,json);
    }

    @Override
    public void confirm(CorrelationData correlationData, boolean b, String s) {

    }

    @Override
    public void returnedMessage(Message message, int i, String s, String s1, String s2) {

    }
}
