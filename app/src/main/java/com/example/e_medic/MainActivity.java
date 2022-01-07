package com.example.e_medic;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
Button toLoginScreen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      toLoginScreen = findViewById(R.id.main_button);
      toLoginScreen.setOnClickListener(view ->  {
              Intent intent=new Intent(MainActivity.this,LoginScreen.class);
              startActivity(intent);
      });
    }
    }
