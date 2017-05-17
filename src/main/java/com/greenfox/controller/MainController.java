package com.greenfox.controller;

import com.greenfox.model.ErrorMessage;
import com.greenfox.model.User;
import com.greenfox.repository.ChatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

  @Autowired
  ChatRepository chatRepo;
  String error;

  @ExceptionHandler(MissingServletRequestParameterException.class)
  public ErrorMessage someException(MissingServletRequestParameterException e) {
    System.err.print(e.getMessage());
    return new ErrorMessage("Error message");
  }

  @RequestMapping("/")
  public String index(Model model) {
    if (chatRepo.count() == 0) {
      return "redirect:/enter";
    } else {
      model.addAttribute("error", error);
//      System.out.println(System.getenv("CHAT_APP_LOGLEVEL"));
//      System.out.println(chatRepo.findOne((long)1).getName());
      return "index";
    }
  }

  @RequestMapping("/update")
  public String update(Model model,@RequestParam("name") String name) {
    if (name.isEmpty()){
      error = "The username field is empty.";
      return "redirect:/";
    } else {
      error = "";
      User user = chatRepo.findOne((long)1);
      user.setName(name);
      chatRepo.save(user);
//    System.out.println(name);
      return "redirect:/";
    }
  }
  }




