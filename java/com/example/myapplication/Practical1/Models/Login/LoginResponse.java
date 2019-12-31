package com.example.myapplication.Practical1.Models.Login;


import com.example.myapplication.Practical1.Models.Data;
import com.google.gson.annotations.SerializedName;


public class LoginResponse{

  @SerializedName("data")
  private Data data;

  @SerializedName("success")
  private boolean success;

  @SerializedName("message")
  private String message;

  @SerializedName("token")
  private String token;

  public void setData(Data data){
    this.data = data;
  }

  public Data getData(){
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
            "LoginResponse{" +
                    "data = '" + data + '\'' +
                    ",success = '" + success + '\'' +
                    ",message = '" + message + '\'' +
                    ",token = '" + token + '\'' +
                    "}";
  }
}