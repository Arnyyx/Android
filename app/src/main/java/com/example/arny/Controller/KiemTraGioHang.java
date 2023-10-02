package com.example.arny.Controller;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.arny.Model.SanPham;
import com.example.arny.R;
import com.google.gson.Gson;

import java.util.ArrayList;

public class KiemTraGioHang extends AppCompatActivity {
    ArrayList<String> list = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kiemtragiohang_layout);

        Intent intent = getIntent();
        String spStr = intent.getStringExtra("sanPham");

        list.add(spStr);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list);

        GridView gridView = findViewById(R.id.gridView);
        gridView.setAdapter(adapter);

    }
}
