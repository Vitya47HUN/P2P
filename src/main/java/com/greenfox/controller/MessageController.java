package com.greenfox.controller;

import com.greenfox.model.ErrorMessage;
import com.greenfox.model.Message;
import com.greenfox.model.Reciever;
import com.greenfox.model.Response;
import com.greenfox.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
public class MessageController {

  public static final String receiveLink = "/api/message/receive";
  RestTemplate restTemplate = new RestTemplate();
  @Autowired
  MessageRepository messRepo;

  @ExceptionHandler(MissingServletRequestParameterException.class)
  public ErrorMessage someException(MissingServletRequestParameterException e) {
    String error = e.getParameterName();
    return new ErrorMessage("This is an error");
  }

  @CrossOrigin("*")
  @RequestMapping(path = receiveLink, method = RequestMethod.POST)
  public Response getMessageGroot(@RequestBody Reciever newReciever) {
    Response myResponse;
    if (newReciever.getMessage().getUsername() == null) {
      myResponse = new Response("Error", "Missing field(s): message.username");
    } else {
      myResponse = new Response("OK", null);
      messRepo.save(newReciever.getMessage());
      restTemplate.postForObject(receiveLink, newReciever.getMessage(),Response.class);
    }
    return myResponse;
  }
}
