package com.example.myapplication.Practical1.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import com.example.myapplication.R;

public class SplashActivity extends AppCompatActivity {

    SharedPreferences pref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screens);
        pref = getSharedPreferences("user_details",MODE_PRIVATE);

        if (((pref.contains("emailLogin") && pref.contains("passwordLogin")) ||( (pref.contains("emailRegister") && pref.contains("passwordRegister"))))){
            new Handler().postDelayed(new Runnable() {


                @Override
                public void run() {

                    // This method will be executed once the timer is over
                    Intent intent = new Intent(SplashActivity.this, HomeActivity.class);
                    startActivity(intent);
                    finish();
                }
            }, 2000);

        }
        else {
            new Handler().postDelayed(new Runnable() {

                @Override
                public void run() {


                    // This method will be executed once the timer is over
                    Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
                    startActivity(intent);
                    finish();
                }
            }, 3000);
        }

    }
//        SystemClock.sleep(3000);
}