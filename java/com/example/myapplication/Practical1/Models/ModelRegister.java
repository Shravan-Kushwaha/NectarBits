package com.example.myapplication.Practical1.Models;

public class ModelRegister {
  public String getname() {
    return name;
  }

  public void setname(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getDevice_token() {
    return device_token;
  }

  public void setDevice_token(String device_token) {
    this.device_token = device_token;
  }

  public String getDevice_type() {
    return device_type;
  }

  public void setDevice_type(String device_type) {
    this.device_type = device_type;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public int getMobile_no() {
    return mobile_no;
  }

  public void setMobile_no(int mobile_no) {
    this.mobile_no = mobile_no;
  }



  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }
  private String name;
  private String email;
  private String password;
  private String device_token;
  private String device_type;
  private String address;
  private String message;
  private int mobile_no;

  public ModelRegister(String name, String email, String password, int mobile_no, String device_token, String device_type, String address, String message) {
    this.name = name;
    this.email = email;
    this.password = password;
    this.mobile_no = mobile_no;
    this.device_token = device_token;
    this.device_type = device_type;
    this.address = address;
    this.message = message;
  }
}
