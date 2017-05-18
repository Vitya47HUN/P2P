package com.greenfox.controller;

import com.greenfox.model.ErrorMessage;
import com.greenfox.model.Reciever;
import com.greenfox.model.Service;
import com.greenfox.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


public class RestController {

  @Autowired
  MessageRepository messRepo;
  Service myService = new Service();

  @ExceptionHandler(MissingServletRequestParameterException.class)
  public ErrorMessage someException(MissingServletRequestParameterException e) {
    String error = e.getParameterName();
    return new ErrorMessage("This is an error");
  }

  @RequestMapping(value = "/api/message/receive", method = RequestMethod.GET)
  public Service getMessageGroot(@RequestBody Reciever newReciever) {
    if (newReciever.getMessage().getUsername().equals("")) {
      myService.setStatus("Error");
      myService.setMessage("Missing field(s): message.username");
    } else {
      myService.setStatus("OK");
      messRepo.save(newReciever.getMessage());
    }
    return myService;
  }
}
