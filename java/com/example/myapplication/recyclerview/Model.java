package com.example.myapplication.recyclerview;

public class Model {

  String name,gender,city;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public Model(String name, String gender, String city) {
    this.name = name;
    this.gender = gender;
    this.city = city;
  }
}
