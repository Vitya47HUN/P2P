package com.greenfox.model;


public class Reciever {
Message message;
User user;

public Reciever(){
}

  public Message getMessage() {
    return message;
  }

  public void setMessage(Message message) {
    this.message = message;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }
}
