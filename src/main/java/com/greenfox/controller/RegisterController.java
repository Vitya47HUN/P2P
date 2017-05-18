package com.greenfox.controller;

import com.greenfox.model.Log;
import com.greenfox.model.User;
import com.greenfox.repository.ChatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegisterController {

  @Autowired
  ChatRepository chatRepo;
  String error;

  @RequestMapping("/enter")
  public String enter(Model model) {
    if (chatRepo.count() > 0){
      Log log = new Log();
      log.printLog("/enter","GET","");
      return "redirect:/";
    }else{
      Log log = new Log();
      log.printLog("/enter","GET","");
      model.addAttribute("error", error);
      return "enter";
    }
  }

  @RequestMapping("/enter/add")
  public String enterNew(@RequestParam("name") String name,Model model) {
    if (name.isEmpty()){
      Log log = new Log();
      log.printLog("/enter/add","POST","name=" + name);
      error = "The username field is empty.";
      model.addAttribute("error",error);
      return "redirect:/enter";
    }
    else{
      Log log = new Log();
      log.printLog("/enter/add","POST","name=" + name);
      error = "";
      chatRepo.save(new User(name));
      model.addAttribute("error",error);
      return "redirect:/enter";
    }
  }
}
