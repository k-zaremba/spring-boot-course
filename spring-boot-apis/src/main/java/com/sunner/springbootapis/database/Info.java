package com.sunner.springbootapis.database;


import java.sql.Date;

public class Info {

  private String city;
  private double minTemp;
  private double maxTemp;
  private java.sql.Date date;

  public Info() {
  }

  public Info(String city, double minTemp, double maxTemp, Date date) {
    this.city = city;
    this.minTemp = minTemp;
    this.maxTemp = maxTemp;
    this.date = date;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }


  public double getMinTemp() {
    return minTemp;
  }

  public void setMinTemp(double minTemp) {
    this.minTemp = minTemp;
  }


  public double getMaxTemp() {
    return maxTemp;
  }

  public void setMaxTemp(double maxTemp) {
    this.maxTemp = maxTemp;
  }


  public java.sql.Date getDate() {
    return date;
  }

  public void setDate(java.sql.Date date) {
    this.date = date;
  }

  @Override
  public String toString() {
    return "Info{" +
            "city='" + city + '\'' +
            ", minTemp=" + minTemp +
            ", maxTemp=" + maxTemp +
            ", date=" + date +
            '}';
  }

}
