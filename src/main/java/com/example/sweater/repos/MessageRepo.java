package com.example.sweater.repos;

import com.example.sweater.domain.Message;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;


@Transactional
public interface MessageRepo extends JpaRepository<Message, Long>{
    Page<Message> findByTag(String tag, Pageable pageable);

    Page<Message> findAllByAuthorId(Long id, Pageable pageable);

    Page <Message> findAll(Pageable pageable);

}
