package com.greenfox.model;

import javax.persistence.*;

@Entity
@Table(name = "UserLogin")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  private String name;

  public User(long id, String name){
    this.id = id;
    this.name = name;
  }


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