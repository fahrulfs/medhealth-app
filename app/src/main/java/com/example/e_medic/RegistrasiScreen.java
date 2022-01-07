package com.example.e_medic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class RegistrasiScreen extends AppCompatActivity {
    databaseHelper db;
    ImageView toLogin;
    EditText email, username, password, repassword;
    Button daftar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrasi_screen);

        db = new databaseHelper(this);
        email = findViewById(R.id.email);
        username = findViewById(R.id.nama);
        password = findViewById(R.id.password);
        repassword = findViewById(R.id.repassword);
        daftar = findViewById(R.id.daftar);
        //register

        daftar.setOnClickListener(view -> {
            String strUsername = username.getText().toString();
            String strPassword = password.getText().toString();
            String strRepassword = repassword.getText().toString();
            if (strPassword.equals(strRepassword)) {
                Boolean daftar = db.insertUser(strUsername, strPassword);
                if (daftar) {
                    Toast.makeText(getApplicationContext(), "Daftar Berhasil", Toast.LENGTH_SHORT).show();
                    Intent toLogin = new Intent(RegistrasiScreen.this, LoginScreen.class);
                    startActivity(toLogin);
                    finish();
                } else {
                    Toast.makeText(getApplicationContext(), "Daftar Gagal", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(getApplicationContext(), "Password Tidak Cocok", Toast.LENGTH_SHORT).show();
            }

        });
        //        BACK TO login SCREEN
        toLogin = findViewById(R.id.backToLogin);
        toLogin.setOnClickListener(view -> {
            Intent intent = new Intent(RegistrasiScreen.this, LoginScreen.class);
            startActivity(intent);
        });

    }
}


