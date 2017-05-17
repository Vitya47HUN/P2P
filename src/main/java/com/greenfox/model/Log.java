package com.greenfox.model;

import java.sql.Timestamp;

public class Log {
  String path;
  String method;
  Timestamp currentTime;
  String logLevel;
  String requestDate;

public Log(){
  currentTime = new Timestamp(System.currentTimeMillis() / 1000);
}
}