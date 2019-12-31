package com.example.myapplication.Practical1.Models;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Message {



  @SerializedName("token")
  @Expose
  private String token;
  @SerializedName("data")
  @Expose
  private String data;
  @SerializedName("message")
  @Expose
  private String message;
  @SerializedName("success")
  @Expose
  private Boolean success;

  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }

  public String getData() {
    return data;
  }

  public void setData(String data) {
    this.data = data;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public Boolean getSuccess() {
    return success;
  }

  public void setSuccess(Boolean success) {
    this.success = success;
  }


}
