package com.example.e_medic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Toast;


public class LoginScreen extends AppCompatActivity {
    databaseHelper db;
    EditText username, password;
    Button login;
    TextView toRegistrasiScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);

        db = new databaseHelper(this);
        username = findViewById(R.id.log_username);
        password = findViewById(R.id.log_password);
        login = findViewById(R.id.toMainScreen);
        toRegistrasiScreen = findViewById(R.id.textView7);



        //login
        login.setOnClickListener(view -> {
            String strUsername = username.getText().toString();
            String strPassword = password.getText().toString();
            boolean _login = db.checkLogin(strUsername, strPassword);
            if (_login) {
                boolean updateSession = db.upgradeSession("true", 1);
                if (updateSession) {
                    Toast.makeText(getApplicationContext(), "Berhasil Masuk", Toast.LENGTH_SHORT).show();
                    Intent mainIntent = new Intent(LoginScreen.this, MainScreen.class);
                    startActivity(mainIntent);
                    finish();
                }
            } else {
                Toast.makeText(getApplicationContext(), "Masuk Gagal", Toast.LENGTH_SHORT).show();
            }
        });




        toRegistrasiScreen.setOnClickListener(view -> {
            Intent intent = new Intent(LoginScreen.this, RegistrasiScreen.class);
            startActivity(intent);
        });
    }
}
