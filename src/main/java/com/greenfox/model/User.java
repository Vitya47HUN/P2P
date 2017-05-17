package com.greenfox.model;

import javax.persistence.*;

@Entity
@Table(name = "UserLogin")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  long id;
  String name;

  public User() {
  }

  public User(String newUser){
    this.name = newUser;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}