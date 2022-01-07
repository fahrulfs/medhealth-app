package com.example.e_medic;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.FrameLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;
public class MainScreen extends AppCompatActivity {
    FrameLayout main_frame;
    BottomNavigationView bottomNavigationView;
    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
//FIRST FRAGMENT SHOW
        selectedFragment(new Beranda());
        main_frame = findViewById(R.id.main_frame);
        bottomNavigationView = findViewById(R.id.bottomNavigationView);

        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            Fragment selectedFragment = null;
            switch (item.getItemId()) {
                case R.id.beranda:
                    selectedFragment = new Beranda();
                    break;
                case R.id.catatan:
                    selectedFragment = new Catatan();
                    break;
                case R.id.pesan:
                    selectedFragment = new Pesan();
                    break;
                case R.id.akun:
                    selectedFragment = new Akun();
                    break;
            }
            return selectedFragment(selectedFragment);
        });
    }


    private Boolean selectedFragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.main_frame, fragment)
                    .commit();
            return true;
        }
        return false;
    }
}

