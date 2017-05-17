package com.greenfox.controller;

import com.greenfox.model.User;
import com.greenfox.repository.ChatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegisterController {

  @Autowired
  ChatRepository chatRepo;

  @RequestMapping("/register")
  public String register() {
    return "register";
  }

  @RequestMapping("/register/add")
  public String register(@RequestParam("name") String name) {
    User newUser = new User();
    chatRepo.save(newUser);
    return "redirect:/register";
  }


}
