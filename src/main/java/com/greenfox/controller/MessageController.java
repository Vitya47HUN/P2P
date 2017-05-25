package com.greenfox.controller;

import com.greenfox.model.ErrorMessage;
import com.greenfox.model.Reciever;
import com.greenfox.model.ResponseNotOk;
import com.greenfox.model.ResponseOk;
import com.greenfox.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MessageController {

  public static final String receiveLink = System.getenv("CHAT_APP_PEER_ADDRESSS") + "/api/message/receive";
  public static final String myClient = System.getenv("CHAT_APP_UNIQUE_ID");
  ResponseNotOk responseNot = new ResponseNotOk();
  ResponseOk responseOk = new ResponseOk();
  RestTemplate restTemplate = new RestTemplate();

  @Autowired
  MessageRepository messRepo;

  @ExceptionHandler(MissingServletRequestParameterException.class)
  public ErrorMessage someException(MissingServletRequestParameterException e) {
    String error = e.getParameterName();
    return new ErrorMessage("This is an error");
  }

  @CrossOrigin("*")
  @RequestMapping(path = "/api/message/receive" , method = RequestMethod.POST)
  public Object getMessage(@RequestBody Reciever newReciever) {
    List<String> errorList = new ArrayList<>();
    if (newReciever.getMessage().getUsername() == null) {
      errorList.add("message.username");
    }if(newReciever.getMessage().getText() == null) {
      errorList.add("message.text");
    }if(newReciever.getMessage().getTimestamp() == null) {
      errorList.add("message.timestamp");
    }if(newReciever.getMessage().getId() == 0) {
      errorList.add("message.id");
    }if(newReciever.getClient().getId() == null){
      errorList.add("client.id");
      return responseNot;
    } else if (!newReciever.getClient().getId().equals(myClient)){
      messRepo.save(newReciever.getMessage());
      restTemplate.postForObject(receiveLink, newReciever,ResponseOk.class);
    }
    return responseOk;
  }
}
