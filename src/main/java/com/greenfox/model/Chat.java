package com.greenfox.model;

import java.sql.Timestamp;

public class Chat {
  String message;
  Timestamp currentTime;

public Chat(){
  currentTime = new Timestamp(System.currentTimeMillis() / 1000);
}
}
