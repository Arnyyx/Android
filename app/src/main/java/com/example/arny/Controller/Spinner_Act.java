package com.example.arny.Controller;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.arny.R;

import java.util.ArrayList;

public class Spinner_Act extends AppCompatActivity {
    ArrayAdapter adapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.spinner);

        EditText editMaSP = findViewById(R.id.maSP),
                editTenSP = findViewById(R.id.tenSP);

        ArrayList<SanPham> arrSam = new ArrayList<>();
        ArrayList<SanPham> arrIP = new ArrayList<>();
        ArrayList<SanPham> arrXiaomi = new ArrayList<>();

        ListView listView = findViewById(R.id.listView);
        Spinner spinner = findViewById(R.id.spinn);
        String[] danhMuc = {"1 - SamSung", "2 - Iphone", "3 - Xiaomi"};
        ArrayAdapter<String> adapterSpinner = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, danhMuc);
        adapterSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapterSpinner);

        findViewById(R.id.btnNhap).setOnClickListener(view -> {
            if (spinner.getSelectedItemPosition() == 0) {
                SanPham sanPham = new SanPham(editMaSP.getText().toString(), editTenSP.getText().toString());
                arrSam.add(sanPham);
                listView.setAdapter(adapter);
                adapter.setNotifyOnChange(true);
            }
            if (spinner.getSelectedItemPosition() == 1) {
                SanPham sanPham = new SanPham(editMaSP.getText().toString(), editTenSP.getText().toString());
                arrIP.add(sanPham);
                listView.setAdapter(adapter);
                adapter.setNotifyOnChange(true);
            }
            if (spinner.getSelectedItemPosition() == 2) {
                SanPham sanPham = new SanPham(editMaSP.getText().toString(), editTenSP.getText().toString());
                arrXiaomi.add(sanPham);
                listView.setAdapter(adapter);
                adapter.setNotifyOnChange(true);
            }
        });


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0) {
                    adapter = new ArrayAdapter<>(Spinner_Act.this, android.R.layout.simple_list_item_1, arrSam);
                    listView.setAdapter(adapter);
                    adapter.setNotifyOnChange(true);
                }
                if (i == 1) {
                    adapter = new ArrayAdapter<>(Spinner_Act.this, android.R.layout.simple_list_item_1, arrIP);
                    listView.setAdapter(adapter);
                    adapter.setNotifyOnChange(true);
                }
                if (i == 2) {
                    adapter = new ArrayAdapter<>(Spinner_Act.this, android.R.layout.simple_list_item_1, arrXiaomi);
                    listView.setAdapter(adapter);
                    adapter.setNotifyOnChange(true);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle("Spinner");
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}