package com.greenfox.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;
import java.util.Random;

@Entity
@Table(name = "Messages")
public class Message {

  @Id
  long id;
  String Username;
  String Text;
  Timestamp timestamp;

  public Message(){
    this.timestamp = new Timestamp(System.currentTimeMillis() / 1000);
  }

  public Message(String name){
    this.timestamp = new Timestamp(System.currentTimeMillis() / 1000);
    Username = name;
    Random r = new Random();
    id = 1000000+ (long)(r.nextDouble()*(9999999-1000000));
  }

  public String getUsername() {
    return Username;
  }

  public void setUsername(String username) {
    Username = username;
  }

  public Timestamp getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(Timestamp timestamp) {
    this.timestamp = timestamp;
  }

  public String getText() {
    return Text;
  }

  public void setText(String text) {
    Text = text;
  }
}
