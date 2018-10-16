package com.example.rabbitmq_demo.controller;

import com.example.rabbitmq_demo.service.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author fengyuluo
 * @createTime 17:14 2018/10/16
 */
@RestController
public class RabbitMQController {

    @Autowired
    Producer producer;

    @RequestMapping("/send")
    public void send(@RequestParam("body") String body){
        producer.sendMessge("hhhhh");
    }
}
