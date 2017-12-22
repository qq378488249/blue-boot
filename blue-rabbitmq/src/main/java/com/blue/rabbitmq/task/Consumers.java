package com.blue.rabbitmq.task;

import com.blue.rabbitmq.config.RabbitMQConfig;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * Created by light blue on 2017/12/20
 */
@Component
public class Consumers {

    @RabbitListener(queues = "queue_one")
    public void handQeues(String obj) {
        System.out.println("消费者0接受:"+obj);
    }

}
