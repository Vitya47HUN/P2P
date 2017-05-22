package com.greenfox.controller;

import com.greenfox.model.*;
import com.greenfox.repository.ChatRepository;
import com.greenfox.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

@Controller
public class MainController {

  public static final String receiveLink = System.getenv("CHAT_APP_PEER_ADDRESSS") + "/api/message/receive";
  RestTemplate restTemplate = new RestTemplate();

  @Autowired
  ChatRepository chatRepo;

  @Autowired
  MessageRepository messRepo;
  String error;

  @ExceptionHandler(MissingServletRequestParameterException.class)
  public ErrorMessage someException(MissingServletRequestParameterException e) {
    System.err.print(e.getMessage());
    return new ErrorMessage("ERROR");
  }

  @RequestMapping("/")
  public String index(Model model) {
    if (chatRepo.count() == 0) {
      Log log = new Log();
      log.printLog("/", "GET", "");
      return "redirect:/enter";
    } else {
      model.addAttribute("messRepo", messRepo.count());
      model.addAttribute("messRepoList",messRepo.findAll());
      model.addAttribute("error", error);
      model.addAttribute("userName", chatRepo.findOne((long) 1).getName());
      Log log = new Log();
      log.printLog("/", "GET", "");
      return "index";
    }
  }

  @RequestMapping("/update")
  public String update(Model model, @RequestParam("name") String name) {
    if (name.isEmpty()) {
      error = "The username field is empty.";
      Log log = new Log();
      log.printLog("/update", "PUT", "name=" + name);
      return "redirect:/";
    } else {
      Log log = new Log();
      log.printLog("/update", "PUT", "name=" + name);
      error = "";
      User user = chatRepo.findOne((long) 1);
      user.setName(name);
      chatRepo.save(user);
      return "redirect:/";
    }
  }

  @RequestMapping("/message")
  public String sendMessage(Model model, @RequestParam("message") String message) {
    Message newMessage = new Message(chatRepo.findOne((long)1).getName());
    newMessage.setText(message);
    messRepo.save(newMessage);
    Reciever newReciever = new Reciever();
    Client client = new Client();
    newReciever.setClient(client);
    newReciever.setMessage(newMessage);
    restTemplate.postForObject(receiveLink,newReciever,ResponseOk.class);
    return "redirect:/";
  }
}




