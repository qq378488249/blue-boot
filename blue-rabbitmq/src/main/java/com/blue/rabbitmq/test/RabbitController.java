package com.blue.rabbitmq.test;

import com.blue.rabbitmq.config.RabbitMQConfig;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * Created by light blue on 2017/12/20
 */
@RestController
public class RabbitController {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    //发送消息
    @RequestMapping(value = "/send1", method = RequestMethod.GET)
    public void test() {
        for (int i = 0; i < 10; i++) {
            String str="消费队列one"+i;
            System.out.println("发送消费队列 : " + str);
            this.rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE,RabbitMQConfig.ROUTINGKEY1, str);
        }
    }
    //发送消息
    @RequestMapping(value = "/send2", method = RequestMethod.GET)
    public void tes2() {
        String context = "消费队列two " + new Date();
        System.out.println("Sender : " + context);
        this.rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE,RabbitMQConfig.ROUTINGKEY2, context);
    }
}
