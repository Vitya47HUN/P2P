package com.greenfox.repository;


import com.greenfox.model.ChatMessage;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface ChatRepository extends CrudRepository<ChatMessage,Long> {

}
