package com.greenfox.model;

public class ResponseOk {

  private String status;

  public ResponseOk(){
    this.status = "ok";
  }

  public ResponseOk(String status) {
    this.status = status;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }
}
