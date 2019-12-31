package com.example.myapplication.Practical1.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.example.myapplication.Practical1.Models.Login.LoginResponse;
import com.example.myapplication.Practical1.Models.LoginError.LoginErrorResponse;
import com.example.myapplication.Practical1.RetroFit.RetrofitBuilder;
import com.example.myapplication.R;
import com.google.gson.Gson;

import java.util.regex.Pattern;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class LoginActivity extends AppCompatActivity {
    private ProgressBar progressBar;
    private TextView txtProgress;
    private int progressStatus = 0;
    private Handler handler = new Handler();


    private final static int EXIT_CODE = 100;
    private final static int REGISTER_REQUEST_CODE = 1001;
    private static final Pattern PASSWORD_PATTERN =
            Pattern.compile("^" +
                    //"(?=.*[0-9])" +         //at least 1 digit
                    //"(?=.*[a-z])" +         //at least 1 lower case letter
                    //"(?=.*[A-Z])" +         //at least 1 upper case letter
                    "(?=.*[a-zA-Z])" +      //any letter
                    //"(?=.*[@#$%^&+=])" +    //at least 1 special character
                    "(?=\\S+$)" +           //no white spaces
                    ".{4,}" +               //at least 4 characters
                    "$");
    private static final Pattern PASSWORD_WEAk =
            Pattern.compile("^" +
                    //"(?=.*[0-9])" +         //at least 1 digit
                    //"(?=.*[a-z])" +         //at least 1 lower case letter
                    //"(?=.*[A-Z])" +         //at least 1 upper case letter
                    // "(?=.*[a-zA-Z])" +      //any letter
                    //"(?=.*[@#$%^&+=])" +    //at least 1 special character
                    //"(?=\\S+$)" +           //no white spaces
                    ".{8,}" +               //at least 4 characters
                    "$");
    private static final String TAG = LoginActivity.class.getSimpleName();

    //defining AwesomeValidation object
    private AwesomeValidation awesomeValidation;
    SharedPreferences pref;
    Retrofit retrofit;
    EditText editTextEmail, editTextPass;
    Button Save;
    TextView TextViewErrorLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);
        editTextEmail = findViewById(R.id.edtEmailLogin);
        editTextPass = findViewById(R.id.edtPassWordLogin);
        Save = findViewById(R.id.btnLogin);
        txtProgress = (TextView) findViewById(R.id.txtProgress);
        TextViewErrorLogin = findViewById(R.id.txtViewerrorLogin);

        //library for form Validation
        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);

        // Session ManageMent using Shared Preference
        pref = getSharedPreferences("user_details", MODE_PRIVATE);


        //awesomeValidation.addValidation(this, R.id.edtPassWord,"[a-zA-Z0-9]{6,20}" , R.string.passworderror);

    }


    private boolean validatePassword() {
        String passwordInput = editTextPass.getText().toString();
        //adding validation to editText
        awesomeValidation.addValidation(this, R.id.edtEmailLogin, Patterns.EMAIL_ADDRESS, R.string.emailerror);
        if (passwordInput.isEmpty()) {
            editTextPass.setError("Field can't be empty");
            return false;
        } else {
            return true;

        }
    }

    public void validateEmail() {
        //  if this becomes true that means validation is successfull
        if (awesomeValidation.validate()) {

            //adding validation to editText
            awesomeValidation.addValidation(this, R.id.edtEmailLogin, Patterns.EMAIL_ADDRESS, R.string.emailerror);
        }
    }

    public void Login(View view) {


        validatePassword();
        validateEmail();
        LoginCallResponce();

    }

    private void LoginCallResponce() {


        String Email = editTextEmail.getText().toString();
        String Pass = editTextPass.getText().toString();

        Call<LoginResponse> call = RetrofitBuilder.getInstance().getRetrofit()
                .SignIn(Email, Pass, "asd", "android");

        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if (response.isSuccessful()) {
                    if (response.body().isSuccess()) {
                        Progress();
                        Toast.makeText(LoginActivity.this, "Login Successfully", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                        String email = editTextEmail.getText().toString();
                        String password = editTextPass.getText().toString();
                        SharedPreferences.Editor editor = pref.edit();
                        editor.putString("emailLogin", email);
                        editor.putString("passwordLogin", password);
                        editor.commit();

                        startActivityForResult(intent, EXIT_CODE);
                        finish();
                    } else {
                        Toast.makeText(LoginActivity.this, "", Toast.LENGTH_SHORT).show();
                    }

                    Toast.makeText(LoginActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(LoginActivity.this, "You have entered wrong email or password!", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                t.printStackTrace();
                Gson gson = new Gson();
                Toast.makeText(LoginActivity.this, "Oops:  " + ((LoginErrorResponse) gson.fromJson(call.request().body().toString(), LoginErrorResponse.class)).getMessage(), Toast.LENGTH_SHORT).show();
            }
        });


    }

    private void Progress() {
        progressBar = (ProgressBar) findViewById(R.id.progressBar_cyclic);
        progressBar.setVisibility(View.VISIBLE);
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                while (progressStatus <= 100) {
//                    handler.post(new Runnable() {
//                        @Override
//                        public void run() {
//                            progressBar.setProgress(progressStatus);
//                            txtProgress.setText(progressStatus + " %");
//                        }
//                    });
//                    try {
//                        Thread.sleep(100);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    progressStatus++;
//                }
          //  }
        //}).start();
    }

    public void RegisterButton(View view) {
        Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
        startActivityForResult(intent,REGISTER_REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REGISTER_REQUEST_CODE && resultCode == RESULT_OK) {
                if (data.getBooleanExtra("REGISTER", true)) {
                    Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                    startActivity(intent);
                    finish();
                }

        }
    }
}

