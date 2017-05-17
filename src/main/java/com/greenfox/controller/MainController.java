package com.greenfox.controller;

import com.greenfox.model.ErrorMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.logging.Logger;

@Controller
public class MainController {

  private final static Logger LOGGER = Logger.getLogger(MainController.class.getName());

  @ExceptionHandler(MissingServletRequestParameterException.class)
  public ErrorMessage someException(MissingServletRequestParameterException e) {
    System.err.print(e.getMessage());
    return new ErrorMessage("Error message");
  }

  @RequestMapping("/")
  public String index() {
    return "index";
  }

  @GetMapping("/")
  public String logging(){
    System.out.println(LOGGER.getName());
    return "index";
  }
}



