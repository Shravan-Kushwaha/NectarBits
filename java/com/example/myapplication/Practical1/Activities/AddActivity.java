package com.example.myapplication.Practical1.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.Practical1.Adapters.MyAdapterPractical1;
import com.example.myapplication.R;

public class AddActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    EditText EditTextName, EditTextAge, EditTextCompany;
    Button ButtonAdd;
    TextView TextForSpinner;
    Spinner SpinnerCity;
    MyAdapterPractical1 myAdapterPractical1;
    private static final String TAG = AddActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        EditTextName = findViewById(R.id.edtName);
        EditTextAge = findViewById(R.id.edtAge);
        EditTextCompany = findViewById(R.id.edtCompany);
//      EditTextCity = findViewById(R.id.edtCity);
        ButtonAdd = findViewById(R.id.btnAdd);

        SpinnerCity = findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> arrayAdapter = ArrayAdapter.createFromResource(this, R.array.City,
                android.R.layout.simple_spinner_dropdown_item);

        SpinnerCity.setAdapter(arrayAdapter);
    }


    // code for add icon Onclick
    public void Add(View view) {
        String stringName, stringAge, stringCompany, stringCity;
        stringName = EditTextName.getText().toString();
        stringAge = EditTextAge.getText().toString();
        stringCompany = EditTextCompany.getText().toString();
        stringCity = SpinnerCity.getSelectedItem().toString();

        Intent intent = new Intent();
        intent.putExtra("Name", stringName);
        intent.putExtra("Age", stringAge);
        intent.putExtra("Company", stringCompany);
        intent.putExtra("City", stringCity);
        setResult(RESULT_OK, intent);
        myAdapterPractical1.notifyDataSetChanged();
        finish();

    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
