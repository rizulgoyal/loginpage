package com.example.loginpage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;


public class HomeActivity extends AppCompatActivity implements View.OnClickListener, PopupMenu.OnMenuItemClickListener {

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
        registerForContextMenu(lowercase);

        uppercase.setOnClickListener(this);
        lowercase.setOnClickListener(this);
// please add one commnt



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
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_home, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_home, menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.action_add:
                Toast.makeText(HomeActivity.this,"Added",Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_delete:
                Toast.makeText(HomeActivity.this,"Deleted",Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);

    }



    @Override
    public void onClick(View view) {

        Bundle extras = getIntent().getExtras();
        String value = extras.getString("username");



        if (view.getId() == R.id.lowercase) {

            display.setText(value.toLowerCase());
            //Intent intent = new Intent(FirstActivity.this, HomeActivity.class);

            //Toast.makeText(FirstActivity.this,"jhcbydfhvhi",Toast.LENGTH_SHORT).show();

            //startActivity(intent);
        }
        else if (view.getId() == R.id.uppercase) {

           showmenu(view);

            display.setText(value.toUpperCase());
            //Intent intent = new Intent(FirstActivity.this, HomeActivity.class);

            //Toast.makeText(FirstActivity.this,"jhcbydfhvhi",Toast.LENGTH_SHORT).show();

            //startActivity(intent);

        }


    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.action_add:
                Toast.makeText(HomeActivity.this,"Added",Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_delete:
                Toast.makeText(HomeActivity.this,"Deleted",Toast.LENGTH_SHORT).show();
                break;
        }

        return false;
    }

    public  void showmenu(View v)
    {
        PopupMenu popupMenu = new PopupMenu(this,v);
        popupMenu.setOnMenuItemClickListener(this);
        popupMenu.inflate(R.menu.menu_home);
        popupMenu.show();
    }

}
