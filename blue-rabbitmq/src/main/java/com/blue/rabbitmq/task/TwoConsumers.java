//package com.blue.rabbitmq.task;
//
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
//import org.springframework.stereotype.Component;
//
///**
// * Created by light blue on 2017/12/20
// */
//@Component
//public class TwoConsumers {
//
//    @RabbitListener(queues = "queue_two")
//    public void handQeues(String obj) {
//        System.out.println("消费者two接受:"+obj);
//    }
//
//}
