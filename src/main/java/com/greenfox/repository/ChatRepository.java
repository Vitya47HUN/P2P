package com.greenfox.repository;

import com.greenfox.model.Log;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface ChatRepository extends CrudRepository<Log,Long> {

}
