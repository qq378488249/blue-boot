package com.blue.rabbitmq.task;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by light blue on 2017/12/20
 */
@Component
public class Consumers1 {

    @RabbitListener(queues = "queue_one")
    public void handQeues(String obj) {
        System.out.println("消费者1接受:"+obj);
    }

}
