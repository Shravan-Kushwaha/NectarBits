package com.example.myapplication.Practical1.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.myapplication.Practical1.Adapters.MyAdapterPractical1;
import com.example.myapplication.Practical1.Models.ModelClassPractical1;
import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    private static final String TAG = HomeActivity.class.getSimpleName();
    Intent intent;
    String fetchedName, fetchedAge, fetchedCompany, fetchedCity;
    RecyclerView recyclerView;
    MyAdapterPractical1 myAdapterPractical1;
    List<ModelClassPractical1> modelClassPractical1List = new ArrayList<>();

    public static int REQUEST_FOR_DATA = 123;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        myAdapterPractical1 = new MyAdapterPractical1(modelClassPractical1List);

        recyclerView = findViewById(R.id.recycler_view_practical_1);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(myAdapterPractical1);
    }

    public void prepareData() {
        ModelClassPractical1 modelClassPractical1 = new ModelClassPractical1(
                "1. " + fetchedName, "2. " + fetchedAge,
                "3. " + fetchedCompany, "4. " + fetchedCity);

        modelClassPractical1List.add(modelClassPractical1);

    }

    public void NextActivity(MenuItem item) {
        intent = new Intent(HomeActivity.this, AddActivity.class);
        startActivityForResult(intent, REQUEST_FOR_DATA);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

            if (requestCode == REQUEST_FOR_DATA && resultCode == RESULT_OK) {

                fetchedName = data.getStringExtra("Name");
                fetchedAge = data.getStringExtra("Age");
                fetchedCompany = data.getStringExtra("Company");
                fetchedCity = data.getStringExtra("City");
                Log.e(TAG, "Name: " + fetchedName);
                prepareData();
                myAdapterPractical1.notifyDataSetChanged();
        }
    }
    public void Logout(MenuItem item) {
        Intent intent = new Intent(HomeActivity.this, SplashActivity.class);
        startActivity(intent);
        SharedPreferences sharedpreferences = getSharedPreferences("user_details", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.clear();
        editor.apply();
        finish();

    }

    @Override

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.add_activity_back, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override

    public void onBackPressed() {
        super.onBackPressed();

    }
}
