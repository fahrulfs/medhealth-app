package com.example.e_medic;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


public class Beranda extends Fragment {
    ImageView toPesan;
    @Nullable
    @Override
    public View onCreateView(@Nullable LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        assert inflater != null;
        View rootView = inflater.inflate(R.layout.fragment_beranda, container, false);
        toPesan = rootView.findViewById(R.id.obat1);
        toPesan.setOnClickListener(view -> {
            Intent intent = new Intent(getActivity(), pesan_screen.class);
            startActivity(intent);
        });
        return rootView;
    }
}