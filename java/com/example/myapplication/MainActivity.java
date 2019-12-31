package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

  RadioGroup radioGroupHobbies;
  TextView TvHobbies;
  RadioButton Cric,chess,volly,cards,football;
  Button save;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    radioGroupHobbies = findViewById(R.id.RgHobbies);
    TvHobbies = findViewById(R.id.hobbies);
    Cric = findViewById(R.id.Cricket);
    cards = findViewById(R.id.Cards);
    chess = findViewById(R.id.Chess);
    volly = findViewById(R.id.VolleyBall);
    football = findViewById(R.id.Football);
    save = findViewById(R.id.button);


    save.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        int selectedId = radioGroupHobbies.getCheckedRadioButtonId();
        save = findViewById(selectedId);
        TvHobbies.setText(save.getText());
      }
    });

//        Cric.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                int selectedId = radioGroupHobbies.getCheckedRadioButtonId();
//                Cric = findViewById(selectedId);
//                TvHobbies.setText(Cric.getText());
//            }
//        });

//        cards.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                int selectedId = radioGroupHobbies.getCheckedRadioButtonId();
//                cards = findViewById(selectedId);
//                TvHobbies.setText(cards.getText());
//
//            }
//        });
//
//        chess.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                int selectedId = radioGroupHobbies.getCheckedRadioButtonId();
//                chess = findViewById(selectedId);
//                TvHobbies.setText(chess.getText());
//            }
//        });
//        volly.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                int selectedId = radioGroupHobbies.getCheckedRadioButtonId();
//                volly = findViewById(selectedId);
//                TvHobbies.setText(volly.getText());
//            }
//        });
//        football.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                int selectedId = radioGroupHobbies.getCheckedRadioButtonId();
//                football = findViewById(selectedId);
//                TvHobbies.setText(football.getText());
//            }
//        });

  }
}
