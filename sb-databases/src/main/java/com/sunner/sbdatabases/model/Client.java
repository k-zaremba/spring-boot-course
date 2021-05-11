package com.sunner.sbdatabases.model;


public class Client {

  private long id;
  private String name;
  private String surename;
  private long age;


  public Client() {
  }

  public Client(long id) {
    this.id = id;
  }

  public Client(long id, String name, String surename, long age) {
    this.id = id;
    this.name = name;
    this.surename = surename;
    this.age = age;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public String getSurename() {
    return surename;
  }

  public void setSurename(String surename) {
    this.surename = surename;
  }


  public long getAge() {
    return age;
  }

  public void setAge(long age) {
    this.age = age;
  }

  @Override
  public String toString() {
    return "Client{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", surename='" + surename + '\'' +
            ", age=" + age +
            '}';
  }
}
