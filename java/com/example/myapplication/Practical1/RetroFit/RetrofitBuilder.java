package com.example.myapplication.Practical1.RetroFit;


import android.app.Activity;
import android.content.Context;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;

/**
 * Created by nectabits on 1/16/2017.
 * Retrofit REST Client
 * <p>
 * you can use the builder to set some general options for all requests,
 * i.e. the base URL or the converter.
 */
@SuppressWarnings("unused")
public class RetrofitBuilder {
  String BASEURL = "http://ec2-13-234-164-40.ap-south-1.compute.amazonaws.com/api/";
  private static final String TAG = RetrofitBuilder.class.getSimpleName();
  private static RetrofitBuilder retrofitBuilder = new RetrofitBuilder();
  public Context activity;

  public RetrofitBuilder() {

  }

  /**
   * Get instance id RetrofitBuilder
   *
   * @return retrofitBuilder
   */
  public static RetrofitBuilder getInstance() {

    return retrofitBuilder;
  }


  /**
   * Retrofit client with custom request setting.
   * i.e. request time out, json converter factory.
   *
   * @return retrofit client.
   */
  public ApiEndpointInterface getRetrofit() {



    HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
    logging.setLevel(HttpLoggingInterceptor.Level.BODY);
    OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
    httpClient.connectTimeout(10, TimeUnit.MINUTES);
    httpClient.readTimeout(10, TimeUnit.MINUTES);
    httpClient.writeTimeout(10, TimeUnit.MINUTES);
    httpClient.addInterceptor(logging);

    Gson gson = new GsonBuilder()
            .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
            .create();

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASEURL)
            .client(httpClient.build())
            // .addCallAdapterFactory(retryableCalls.getFactory())
            .addConverterFactory(GsonConverterFactory.create())

            .build();

        /*ConnectivityAutoRetryer autoRetryer = new ConnectivityAutoRetryer(retryableCalls, activity1);
        autoRetryer.register();*/


    return retrofit.create(ApiEndpointInterface.class);
  }


}


