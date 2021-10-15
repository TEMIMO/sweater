package com.example.sweater.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfiguration {

    Logger logger = LoggerFactory.getLogger(RabbitConfiguration.class);

    @Bean
    public CachingConnectionFactory connectionFactory(){
        return new CachingConnectionFactory("localhost");
    }

    @Bean
    public RabbitAdmin rabbitAdmin(){
        return new RabbitAdmin(connectionFactory());
    }

    @Bean
    public RabbitTemplate rabbitTemplate(){
        return new RabbitTemplate(connectionFactory());
    }

    @Bean
    public Queue myQueue1() {
        return new Queue("myQueue1");
    }

    @Bean
    public Queue myQueue2() {
        return new Queue("myQueue2");
    }

    @Bean
    public DirectExchange directExchange(){
        return new DirectExchange("direct-exchange");
    }

    @Bean
    public Binding binding1(){
        return BindingBuilder.bind(myQueue1()).to(directExchange()).with("key1");
    }

    @Bean
    public Binding binding2(){
        return BindingBuilder.bind(myQueue2()).to(directExchange()).with("key2");
    }
}
