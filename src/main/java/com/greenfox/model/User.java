package com.greenfox.model;

import javax.persistence.*;

@Entity
@Table(name = "UserLogin")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  long id;

  public User(){
  }

  public User(long id){
    this.id = id;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }
}