package com.greenfox.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Log {
  String env = System.getenv("CHAT_APP_LOGLEVEL");
  DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
  Date date;

  public Log(){
    this.date = new Date();
  }

  public void printLog(String endpoint,String mapping,String input){
    System.out.println(dateFormat.format(date) + " " + env + " " + endpoint + " " + mapping + " " + input);
  }

}
