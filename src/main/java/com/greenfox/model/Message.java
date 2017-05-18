package com.greenfox.model;

import javax.persistence.*;

@Entity
@Table(name = "Messages")
public class Message {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  long id;
  User Username;
  String Text;

  public Message(){
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
