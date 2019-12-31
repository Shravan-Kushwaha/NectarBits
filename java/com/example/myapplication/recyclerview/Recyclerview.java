package com.example.myapplication.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class Recyclerview extends AppCompatActivity {

  List<Model> dataList = new ArrayList<>();
  RecyclerView recyclerView;
  MyAdapter myAdapter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_recycler_view);
    recyclerView = findViewById(R.id.recycler_view);

    myAdapter = new MyAdapter(dataList);
    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
    recyclerView.setLayoutManager(layoutManager);
    recyclerView.setItemAnimator(new DefaultItemAnimator());
    recyclerView.setAdapter(myAdapter);
    prepareData();
  }

  void prepareData() {
    Model model;
//        Model model = new Model("Shravan", "Male", "Kadi");
//        dataList.add(model);

    model = new Model("Nitesh", "Male", "Kadi");
    dataList.add(model);
    model = new Model("Nitesh", "Male", "Kadi");
    dataList.add(model);
  }
}
