package com.example.myapplication.Practical1.Models;

public class ModelClassPractical1 {

  String name,age,company,city;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAge() {
    return age;
  }

  public void setAge(String age) {
    this.age = age;
  }

  public String getCompany() {
    return company;
  }

  public void setCompany(String company) {
    this.company = company;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public ModelClassPractical1(String name, String age, String company, String city) {
    this.name = name;
    this.age = age;
    this.company = company;
    this.city = city;
  }
}
