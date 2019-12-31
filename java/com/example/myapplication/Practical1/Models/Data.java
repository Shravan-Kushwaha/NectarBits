package com.example.myapplication.Practical1.Models;


import com.google.gson.annotations.SerializedName;


public class Data{

  @SerializedName("image")
  private String image;

  @SerializedName("google_id")
  private String googleId;

  @SerializedName("role_type")
  private int roleType;

  @SerializedName("mobile_no")
  private String mobileNo;

  @SerializedName("created_at")
  private String createdAt;

  @SerializedName("facebook_id")
  private String facebookId;

  @SerializedName("country_code")
  private String countryCode;

  @SerializedName("updated_at")
  private String updatedAt;

  @SerializedName("name")
  private String name;

  @SerializedName("is_notification")
  private int isNotification;

  @SerializedName("id")
  private int id;

  @SerializedName("invite_code")
  private String inviteCode;

  @SerializedName("refer_point")
  private int referPoint;

  @SerializedName("email")
  private String email;

  @SerializedName("status")
  private int status;

  public void setImage(String image){
    this.image = image;
  }

  public String getImage(){
    return image;
  }

  public void setGoogleId(String googleId){
    this.googleId = googleId;
  }

  public String getGoogleId(){
    return googleId;
  }

  public void setRoleType(int roleType){
    this.roleType = roleType;
  }

  public int getRoleType(){
    return roleType;
  }

  public void setMobileNo(String mobileNo){
    this.mobileNo = mobileNo;
  }

  public String getMobileNo(){
    return mobileNo;
  }

  public void setCreatedAt(String createdAt){
    this.createdAt = createdAt;
  }

  public String getCreatedAt(){
    return createdAt;
  }

  public void setFacebookId(String facebookId){
    this.facebookId = facebookId;
  }

  public String getFacebookId(){
    return facebookId;
  }

  public void setCountryCode(String countryCode){
    this.countryCode = countryCode;
  }

  public String getCountryCode(){
    return countryCode;
  }

  public void setUpdatedAt(String updatedAt){
    this.updatedAt = updatedAt;
  }

  public String getUpdatedAt(){
    return updatedAt;
  }

  public void setName(String name){
    this.name = name;
  }

  public String getName(){
    return name;
  }

  public void setIsNotification(int isNotification){
    this.isNotification = isNotification;
  }

  public int getIsNotification(){
    return isNotification;
  }

  public void setId(int id){
    this.id = id;
  }

  public int getId(){
    return id;
  }

  public void setInviteCode(String inviteCode){
    this.inviteCode = inviteCode;
  }

  public String getInviteCode(){
    return inviteCode;
  }

  public void setReferPoint(int referPoint){
    this.referPoint = referPoint;
  }

  public int getReferPoint(){
    return referPoint;
  }

  public void setEmail(String email){
    this.email = email;
  }

  public String getEmail(){
    return email;
  }

  public void setStatus(int status){
    this.status = status;
  }

  public int getStatus(){
    return status;
  }

  @Override
  public String toString(){
    return
            "Data{" +
                    "image = '" + image + '\'' +
                    ",google_id = '" + googleId + '\'' +
                    ",role_type = '" + roleType + '\'' +
                    ",mobile_no = '" + mobileNo + '\'' +
                    ",created_at = '" + createdAt + '\'' +
                    ",facebook_id = '" + facebookId + '\'' +
                    ",country_code = '" + countryCode + '\'' +
                    ",updated_at = '" + updatedAt + '\'' +
                    ",name = '" + name + '\'' +
                    ",is_notification = '" + isNotification + '\'' +
                    ",id = '" + id + '\'' +
                    ",invite_code = '" + inviteCode + '\'' +
                    ",refer_point = '" + referPoint + '\'' +
                    ",email = '" + email + '\'' +
                    ",status = '" + status + '\'' +
                    "}";
  }
}