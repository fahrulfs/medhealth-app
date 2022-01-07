package com.example.e_medic;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

public class pesan_screen extends AppCompatActivity {
    CheckBox obat_a, obat_b;
    Button ubah;
    TextView total;
    TextView produk;
    ImageView produk_img;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pesan_screen);

        //        BACK TO beranda
        ImageView toBeranda = findViewById(R.id.backToBeranda);
        toBeranda.setOnClickListener(view -> {
            Intent intent = new Intent(pesan_screen.this, MainScreen.class);
            startActivity(intent);
        });
//        CHECKING OTHER MENU
        obat_a = findViewById(R.id.obat1);
        obat_b = findViewById(R.id.obat2);
        ubah = findViewById(R.id.ubah);
        total = findViewById(R.id.total);
        produk = findViewById(R.id.textView14);
        produk_img = findViewById(R.id.imageView4);
        ubah.setOnClickListener(view -> {

            // Kondisi Jika Tidak Ada Salah Satupun Yang Dipilih
            String a = "";
            if (obat_a.isChecked()) {
                a += 17000;
                total.setText(a);
                produk.setText("Imboost anak sirup");
                produk_img.setImageResource(R.drawable.img_obatanak);
            }
            String b = "";
            if (obat_b.isChecked()) {
                b += 18000;
                total.setText(b);
                produk.setText("Imboost dewasa dewasa");
                produk_img.setImageResource(R.drawable.img_obatsirup);
            }
        });
    }
}
