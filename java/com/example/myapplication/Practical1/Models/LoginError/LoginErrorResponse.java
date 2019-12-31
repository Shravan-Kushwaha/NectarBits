package com.example.myapplication.Practical1.Models.LoginError;


import com.google.gson.annotations.SerializedName;


public class LoginErrorResponse{

  @SerializedName("data")
  private String data;

  @SerializedName("success")
  private boolean success;

  @SerializedName("message")
  private String message;

  @SerializedName("token")
  private String token;

  public void setData(String data){
    this.data = data;
  }

  public String getData(){
    return data;
  }

  public void setSuccess(boolean success){
    this.success = success;
  }

  public boolean isSuccess(){
    return success;
  }

  public void setMessage(String message){
    this.message = message;
  }

  public String getMessage(){
    return message;
  }

  public void setToken(String token){
    this.token = token;
  }

  public String getToken(){
    return token;
  }

  @Override
  public String toString(){
    return
            "LoginErrorResponse{" +
                    "data = '" + data + '\'' +
                    ",success = '" + success + '\'' +
                    ",message = '" + message + '\'' +
                    ",token = '" + token + '\'' +
                    "}";
  }
}