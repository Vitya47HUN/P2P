package com.greenfox.model;

import com.fasterxml.jackson.annotation.JsonProperty;
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

  @JsonProperty(value = "username")
  String Username;
  @JsonProperty(value = "text")
  String Text;
  Timestamp timestamp;

  public Message(){
    this.timestamp = new Timestamp(System.currentTimeMillis());
  }

  public Message(long id, String username, String text, Timestamp timestamp) {
    this.id = id;
    Username = username;
    Text = text;
    this.timestamp = timestamp;
  }

  public Message(String username, String text) {
    //this(something) calls the other constructor with the same parameter
    // method overloading, constructor chain
    this(username);
    Text = text;
  }

  public Message(String name){
    this.timestamp = new Timestamp(System.currentTimeMillis());
    Username = name;
    Random r = new Random();
    id = 1000000 + (long)(r.nextDouble()*(9999999-1000000));
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

  public String getText() {
    return Text;
  }

  public void setText(String text) {
    Text = text;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }
}
