package com.example.myapplication.Practical1.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.example.myapplication.Practical1.Models.Login.LoginResponse;
import com.example.myapplication.Practical1.Models.Login.RegisterResponse;
import com.example.myapplication.Practical1.Models.LoginError.LoginErrorResponse;
import com.example.myapplication.Practical1.RetroFit.RetrofitBuilder;
import com.example.myapplication.R;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.regex.Pattern;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {

    EditText EditTextName, EditTextEmail, EditTextNumber, EditTextPassWord, EditTextConfirmPassWord;
    Button ButtonRegister;
    private static final String TAG = RegisterActivity.class.getSimpleName();
    private ProgressBar progressBar;
    TextView TextViewLogin, TextViewError;

    private static final Pattern PASSWORD_PATTERN =
            Pattern.compile("^" +
                    "(?=.*[0-9])" +         //at least 1 digit
                    "(?=.*[a-z])" +         //at least 1 lower case letter
                    "(?=.*[A-Z])" +         //at least 1 upper case letter
                    //"(?=.*[a-zA-Z])" +      //any letter
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
    public static final Pattern EMAIL_ADDRESS
            = Pattern.compile(
            "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                    "\\@" +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                    "(" +
                    "\\." +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                    ")+"
    );
    private static final Pattern PHONE_WEAk =
            Pattern.compile("^" +
                    //"(?=.*[0-9])" +         //at least 1 digit
                    //"(?=.*[a-z])" +         //at least 1 lower case letter
                    //"(?=.*[A-Z])" +         //at least 1 upper case letter
                    // "(?=.*[a-zA-Z])" +      //any letter
                    //"(?=.*[@#$%^&+=])" +    //at least 1 special character
                    //"(?=\\S+$)" +           //no white spaces
                    ".{10,}" +               //at least 4 characters
                    "$");

    SharedPreferences pref;
    //defining AwesomeValidation object
    private AwesomeValidation awesomeValidation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        EditTextName = findViewById(R.id.edtName);
        EditTextEmail = findViewById(R.id.edtEmailSignUp);
        EditTextNumber = findViewById(R.id.edtPhoneNumber);
        EditTextPassWord = findViewById(R.id.edtPassWordSignUp);
        EditTextConfirmPassWord = findViewById(R.id.edtPassConfirmWord);
        ButtonRegister = findViewById(R.id.btnRegister);
        TextViewLogin = findViewById(R.id.txtRegister);
        TextViewError = findViewById(R.id.txtRegister1);
        pref = getSharedPreferences("user_details", MODE_PRIVATE);
    }

    private void RegisterCallResponce() {
        String name = EditTextName.getText().toString();
        String email = EditTextEmail.getText().toString();
        String phone = EditTextNumber.getText().toString();
        String pass = EditTextPassWord.getText().toString();


        Call<RegisterResponse> call = RetrofitBuilder.getInstance().getRetrofit()
                .SignUp(name, email, phone, pass, "qwe", "android", "asds");

        call.enqueue(new Callback<RegisterResponse>() {
            @Override
            public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {
                if (response.isSuccessful()) {
                    ProgressRegister();
                    String email = EditTextEmail.getText().toString();
                    String pass = EditTextPassWord.getText().toString();
                    Log.e(TAG, "onActivityResult: " + response.isSuccessful());
                   /* Intent intent = new Intent(RegisterActivity.this, HomeActivity.class);
                    startActivity(intent);
                    finishAffinity();*/

                    SharedPreferences.Editor editor = pref.edit();
                    editor.putString("emailRegister", email);
                    editor.putString("passwordRegister", pass);
                    editor.commit();

                    Intent intent = new Intent();
                    intent.putExtra("REGISTER", true);
                    setResult(RESULT_OK, intent);
                    finish();

                    Toast.makeText(RegisterActivity.this, "Registered Successfully!", Toast.LENGTH_SHORT).show();
                } else {
                    Log.e(TAG, "onActivityResult: " + response);
                    Toast.makeText(RegisterActivity.this, "Email Id Already Exists!", Toast.LENGTH_SHORT).show();
                }
                //Toast.makeText(RegisterActivity.this, response.body().getStatus(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<RegisterResponse> call, Throwable t) {
                t.printStackTrace();
                Gson gson = new Gson();

                Toast.makeText(RegisterActivity.this, "Oops:  " + ((LoginErrorResponse) gson.fromJson(call.request().body().toString(), LoginErrorResponse.class)).getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }


    public void Register(View view) {
        RegisterFormValidation();

    }

    private boolean RegisterFormValidation() {
        String Name = EditTextName.getText().toString();
        String Email = EditTextEmail.getText().toString();
        String Phone = EditTextNumber.getText().toString();
        String Pass = EditTextPassWord.getText().toString();
        String ConfirmPass = EditTextConfirmPassWord.getText().toString();

        if (ConfirmPass.isEmpty()) {
            if (Pass.isEmpty()) {
                if (Phone.isEmpty()) {
                    if (Email.isEmpty()) {
                        if (Name.isEmpty()) {
                            EditTextName.setError("Field can't be empty");
                            EditTextEmail.setError("Field can't be empty");
                            EditTextNumber.setError("Field can't be empty");
                            EditTextPassWord.setError("Field can't be empty");
                            EditTextConfirmPassWord.setError("Field can't be empty");
                            return false;
                        } else
                            EditTextEmail.setError("Field can't be empty");
                        EditTextNumber.setError("Field can't be empty");
                        EditTextPassWord.setError("Field can't be empty");
                        EditTextConfirmPassWord.setError("Field can't be empty");
                        return false;
                    } else {
                        if (!EMAIL_ADDRESS.matcher(Email).matches()) {
                            EditTextEmail.setError("Enter Valid Email ID");
                            return false;
                        }
                        EditTextNumber.setError("Field can't be empty");
                        EditTextPassWord.setError("Field can't be empty");
                        EditTextConfirmPassWord.setError("Field can't be empty");
                        return false;
                    }

                } else {
                    if (!PHONE_WEAk.matcher(Phone).matches()) {
                        EditTextNumber.setError("Please Enter 10 Digit Mobile Number Only");
                        return false;
                    }
                }
                EditTextPassWord.setError("Field can't be empty");
                EditTextConfirmPassWord.setError("Field can't be empty");
                return false;
            }
            EditTextConfirmPassWord.setError("Field can't be empty");
            return false;

        } else {
            if (!PASSWORD_PATTERN.matcher(Pass).matches()) {
                if (!PASSWORD_WEAk.matcher(Pass).matches()) {
                    EditTextPassWord.setError("Set PassWord 8 to 20 letters");
                    return false;

                } else {
                    EditTextPassWord.setError("Must Contain atleast 1 Cap, 1 Small letter ,1 digit");
                    return false;

                }
            } else {
                if (Pass.equals(ConfirmPass)) {
                    RegisterCallResponce();
                    return true;
                } else {
                    Toast.makeText(this, "PassWord doesn't Match", Toast.LENGTH_LONG).show();
                    return false;
                }


            }
        }
    }

    public void RegisterActivity(View view) {

        finish();



    }
    private void ProgressRegister() {
        progressBar = (ProgressBar) findViewById(R.id.progressBar_cyclicReg);
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
}
