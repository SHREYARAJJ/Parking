package com.shreya.parking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;



public class registration extends AppCompatActivity {

     EditText Name, Email, Password, Mobile_Number;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        Name = findViewById(R.id.Name);
        Email=findViewById(R.id.Email);
        Password=findViewById(R.id.Password);
        Mobile_Number=findViewById(R.id.Mobile_Number);

    }
    public void moveToLogin(View v){
        startActivity(new Intent(getApplicationContext(),login.class));
        finish();
    }


}