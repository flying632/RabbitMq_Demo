package com.example.rabbitmq_demo.entity;

/**
 * @author fengyuluo
 * @createTime 17:21 2018/10/16
 */
public class Msg {
    String exchange;
    String routingkey;
    String sendMsg;

    public Msg(String exchange, String routingkey, String sendMsg) {
        this.exchange = exchange;
        this.routingkey = routingkey;
        this.sendMsg = sendMsg;
    }

    public String getExchange() {
        return exchange;
    }

    public void setExchange(String exchange) {
        this.exchange = exchange;
    }

    public String getRoutingkey() {
        return routingkey;
    }

    public void setRoutingkey(String routingkey) {
        this.routingkey = routingkey;
    }

    public String getSendMsg() {
        return sendMsg;
    }

    public void setSendMsg(String sendMsg) {
        this.sendMsg = sendMsg;
    }
}
