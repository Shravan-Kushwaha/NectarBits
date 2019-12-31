package com.example.myapplication.Practical1.RetroFit;


import com.example.myapplication.Practical1.Models.Login.LoginResponse;
import com.example.myapplication.Practical1.Models.Login.RegisterResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by nectabits on 1/16/2018.
 * An Interface which defines the HTTP operations (Functions or methods)
 */
@SuppressWarnings("unused")
public interface ApiEndpointInterface {

  @FormUrlEncoded
  @POST("signupcm")
  Call<RegisterResponse> SignUp(
          @Field("name") String name,
          @Field("email") String email,
          @Field("password") String password,
          @Field("mobile_no") String mobile_no,
          @Field("device_token") String device_token,
          @Field("device_type") String device_type,
          @Field("address") String address
  );

  @FormUrlEncoded
  @POST("signincm")
  Call<LoginResponse> SignIn(
          @Field("email") String email,
          @Field("password") String password,
          @Field("device_token") String device_token,
          @Field("device_type") String device_type
  );


}
