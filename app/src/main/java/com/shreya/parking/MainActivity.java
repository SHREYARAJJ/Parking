package com.shreya.parking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
     Button btn,btn2;

     //Intent login;
     //Intent registration;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Transparent ActionBar
        /*getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        );
          getSupportActionBar().hide();*/

        btn =  findViewById(R.id.button);
        //btn2 = findViewById(R.id.button2);
        btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {

                Toast.makeText(MainActivity.this, "Login has been clicked", Toast.LENGTH_SHORT).show();
                 Intent intent = new Intent(MainActivity.this ,login.class);
                 startActivity(intent);
            }
        });

        btn2 = findViewById(R.id.button2);
        btn2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Register has been clicked", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this ,registration.class);
                startActivity(intent);
             }
        });

    }
}
