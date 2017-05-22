package com.greenfox.model;

public class Client {

  String client;

  public Client() {
    this.client = System.getenv("CHAT_APP_UNIQUE_ID");
  }

  public String getClient() {
    return client;
  }

  public void setClient(String client) {
    this.client = client;
  }
}
