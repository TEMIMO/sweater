package com.example.sweater.contoller;


import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/rabbit")
public class RabbitController  {

    Logger logger = LoggerFactory.getLogger(RabbitController.class);

    private final RabbitTemplate template;

    @Autowired
    public RabbitController(RabbitTemplate template){
        this.template = template;
    }

    @PostMapping
    public ResponseEntity<String> checkRabbit(@RequestBody Map<String, String> message){
        logger.info("Emit to myQueue");
        Gson gson = new Gson();//can delete
        String json = gson.toJson(message);//
        template.setExchange("direct-exchange");
        template.convertAndSend(message.get("key"), json);
        return ResponseEntity.ok("Success emit to myQueue");
    }
}
