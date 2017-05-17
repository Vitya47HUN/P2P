package com.greenfox.controller;

import com.greenfox.model.ErrorMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

  @ExceptionHandler(MissingServletRequestParameterException.class)
  public ErrorMessage someException(MissingServletRequestParameterException e) {
    System.err.print(e.getMessage());
    return new ErrorMessage("Error message");
  }

  @RequestMapping("/")
  public String index() {
    System.out.println(System.getenv("CHAT_APP_LOGLEVEL"));
    return "index";
  }

}



