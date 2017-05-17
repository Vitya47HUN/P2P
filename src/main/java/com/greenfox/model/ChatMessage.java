package com.greenfox.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ChatMessage {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  long id;

  public ChatMessage(){
  }

  public ChatMessage(long id){
    this.id = id;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }
}
