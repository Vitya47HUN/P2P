package com.greenfox.model;

import javax.persistence.*;
import java.util.Random;

@Entity
@Table(name = "Messages")
public class Message {

  @Id
  long id;
  User Username;
  String Text;

  public Message(){
    Random r = new Random();
    id = 10000 + (long)(r.nextDouble()*(99999-10000));
  }

  public User getUsername() {
    return Username;
  }

  public void setUsername(User username) {
    Username = username;
  }

  public String getText() {
    return Text;
  }

  public void setText(String text) {
    Text = text;
  }
}
