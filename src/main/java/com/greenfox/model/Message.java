package com.greenfox.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Random;

@Entity
@Table(name = "Messages")
public class Message {

  @Id
  long id;
  String Username;
  String Text;

  public Message(){
  }

  public Message(String name){
    Username = name;
    Random r = new Random();
    id = 10000 + (long)(r.nextDouble()*(99999-10000));
  }

  public String getUsername() {
    return Username;
  }

  public void setUsername(String username) {
    Username = username;
  }

  public String getText() {
    return Text;
  }

  public void setText(String text) {
    Text = text;
  }
}
