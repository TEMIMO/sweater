package com.example.sweater.contoller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@EnableRabbit
@Component
public class RabbitMqListener {

    Logger logger = LoggerFactory.getLogger(RabbitMqListener.class);

    @RabbitListener(queues = "myQueue1")
    public void processMyQueue1(String message) {
        logger.info("Received from Queue1: " + message);
    }

    @RabbitListener(queues = "myQueue2")
    public void processMyQueue2(String message){
        logger.info("Received from Queue2: " + message);
    }
}
