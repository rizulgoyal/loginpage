package com.example.loginpage;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FirstActivity extends AppCompatActivity {

    private EditText username;

    private EditText password;
    private Button login;
    private String usernamestore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        username = findViewById(R.id.editUserName);
        password = findViewById(R.id.editPassword);
        login = findViewById(R.id.buttonlogin);



        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

         //        if (view.getId() == R.id.buttonlogin)

                if(username.getText().toString().equals("Rizul") && password.getText().toString().equals("8029"))
                {
                    usernamestore = username.getText().toString();
                    Intent intent = new Intent(FirstActivity.this, HomeActivity.class);
                    intent.putExtra("username",usernamestore);
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


