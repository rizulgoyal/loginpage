package com.example.loginpage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView display;
    private Button uppercase;
    private Button lowercase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        display = findViewById(R.id.textViewdisplay);
        lowercase = findViewById(R.id.lowercase);
        uppercase = findViewById(R.id.uppercase);

        uppercase.setOnClickListener(this);
        lowercase.setOnClickListener(this);




        Bundle extras = getIntent().getExtras();
        if (extras != null) {

            String value = extras.getString("username");





            display.setText(value);
        }
        else
        {
            display.setText("Nothing");

        }





    }


    @Override
    public void onClick(View view) {

        

    }
}
