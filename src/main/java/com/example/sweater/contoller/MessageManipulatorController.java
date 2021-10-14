package com.example.sweater.contoller;

import com.example.sweater.domain.Message;
import com.example.sweater.repos.MessageDAO;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/messageManipulator")
public class MessageManipulatorController {
    @Autowired
    private MessageDAO messageDAO;

    @GetMapping("/getMessage/{id}")
    public Message returnJson(
            @PathVariable("id") Long messageId){

        return messageDAO.findByMessageId(messageId);
    }
}
