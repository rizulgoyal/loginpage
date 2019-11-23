package com.example.loginpage;

import androidx.annotation.ColorInt;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class FirstActivity extends AppCompatActivity {

    private EditText username;

    private EditText password;
    private Button login;
    private String usernamestore;
    private String passwordstore;
    private ToggleButton newtoggle;
    private TextView colortext;
    private Switch rememberme;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        username = findViewById(R.id.editUserName);
        password = findViewById(R.id.editPassword);
        login = findViewById(R.id.buttonlogin);
        newtoggle = findViewById(R.id.toggleButton);
        colortext =  findViewById(R.id.txtColor);
        rememberme = findViewById(R.id.switch1);

        rememberme.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if(rememberme.isChecked())
                {
                    colortext.setText("I am Female");
                    colortext.setBackgroundColor(Color.YELLOW);
                    colortext.setTextColor(Color.BLUE);
                }
                else
                {
                    colortext.setText("I am Male");

                    colortext.setBackgroundColor(Color.LTGRAY);

                    colortext.setTextColor(Color.RED);
                }

            }
        });

        newtoggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if(newtoggle.isChecked())
                {
                    colortext.setText("I am Female");
                    colortext.setBackgroundColor(Color.YELLOW);
                    colortext.setTextColor(Color.BLUE);
                }
                else
                {
                    colortext.setText("I am Male");

                    colortext.setBackgroundColor(Color.LTGRAY);

                    colortext.setTextColor(Color.RED);
                }

            }
        });




        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

         //        if (view.getId() == R.id.buttonlogin)

                if(username.getText().toString().equals("Rizul") && password.getText().toString().equals("8029"))
                {
                    usernamestore = username.getText().toString();
                    passwordstore = password.getText().toString();
                    Intent intent = new Intent(FirstActivity.this, HomeActivity.class);
                    intent.putExtra("username",usernamestore);
                    intent.putExtra("password",passwordstore);

                    if (usernamestore.isEmpty())
                    {
                     Toast.makeText(FirstActivity.this,"jhcbydfhvhi",Toast.LENGTH_SHORT).show();
                    }
                    startActivity(intent);
                }
                else
                {
                    setalert();


                    //username.setError("Please add name");
                    Toast.makeText(FirstActivity.this,"Not correct",Toast.LENGTH_SHORT).show();
                }




            }


        });



    }


    private void setalert ()
    {
        AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
        builder1.setIcon(R.drawable.ic_action_name);
        builder1.setTitle("Login Error");
        builder1.setMessage("Please input correct values ");
        builder1.setCancelable(true);

        builder1.setPositiveButton(
                "Yes",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.dismiss();
                    }
                });

        builder1.setPositiveButtonIcon(getResources().getDrawable(R.drawable.ic_action_username));

        builder1.setNegativeButton(
                "No",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.dismiss();
                    }
                });

        AlertDialog alert11 = builder1.create();
        alert11.show();
    }
}


