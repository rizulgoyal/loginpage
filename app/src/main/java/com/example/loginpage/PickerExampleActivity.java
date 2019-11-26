package com.example.loginpage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class PickerExampleActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Spinner spcountries;
    ArrayList<String>countryList;

    Integer[] imageArray = {R.drawable.canada,R.drawable.china,R.drawable.india,R.drawable.usa};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picker_example);

        spcountries = findViewById(R.id.spCountryList);
        countryList = new ArrayList<>();


        //countryList = (ArrayList<String>) Arrays.asList(getResources().getStringArray(R.array.array_country));


        ArrayAdapter<CharSequence> maarayadapter = ArrayAdapter.createFromResource(this,R.array.array_country, android.R.layout.simple_spinner_item);
        maarayadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        spcountries.setAdapter(maarayadapter);
        spcountries.setOnItemSelectedListener(this);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this,parent.getItemAtPosition(position).toString(),Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
