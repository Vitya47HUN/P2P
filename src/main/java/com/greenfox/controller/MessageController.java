package com.greenfox.controller;

import com.greenfox.model.ErrorMessage;
import com.greenfox.model.Reciever;
import com.greenfox.model.Response;
import com.greenfox.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
public class MessageController {

  public static final String receiveLink = System.getenv("CHAT_APP_PEER_ADDRESSS") + "/api/message/receive";
  public static final String myClient = System.getenv("CHAT_APP_UNIQUE_ID");
  RestTemplate restTemplate = new RestTemplate();
  @Autowired
  MessageRepository messRepo;

  @ExceptionHandler(MissingServletRequestParameterException.class)
  public ErrorMessage someException(MissingServletRequestParameterException e) {
    String error = e.getParameterName();
    return new ErrorMessage("This is an error");
  }

  @RequestMapping(path = "/api/message/receive" , method = RequestMethod.POST)
  public Response getMessageGroot(@RequestBody Reciever newReciever) {
    Response myResponse = new Response("f","f");
    if (newReciever.getMessage().getUsername() == null) {
      myResponse.setMessage("Missing field(s): message.username");
      myResponse.setStatus("Error");
      return myResponse;
    } else if (!newReciever.getClient().getId().equals(myClient)){
      myResponse = new Response("OK", null);
      messRepo.save(newReciever.getMessage());
      restTemplate.postForObject(receiveLink, newReciever,Response.class);
    }
    return myResponse;
  }
}
