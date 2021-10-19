package com.example.sweater.service;

import com.example.sweater.domain.Message;
import com.example.sweater.domain.User;
import com.example.sweater.domain.dto.MessageDto;
import com.example.sweater.repos.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;

@Service
public class MessageService {
    @Autowired
    MessageRepo messageRepo;

    @Autowired
    private EntityManager em;

    public Page<MessageDto> messageList(Pageable pageable, String filter, User user){
        if (filter != null && !filter.isEmpty()) {
            return messageRepo.findByTag(filter, pageable, user);
        }
        else {
            return messageRepo.findAll(pageable, user);
        }
    }

//    Using HQL
    public Page<MessageDto> messageListForUser(Pageable pageable, User user, User author){
        return messageRepo.findAllByAuthor(pageable, author, user);
    }

//    public Page<Message> messageListForUser(User user,  Pageable pageable){
//        return messageRepo.findAllByAuthorId(user.getId(), pageable);
//    }

}
