package com.example.arny.Controller;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.arny.Controller.SanPham2;
import com.example.arny.R;

import java.util.ArrayList;

public class Spinner2_Act extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.spinner);

        ArrayList<SanPham2> arrSanPham = new ArrayList<>();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);
        ListView listView = findViewById(R.id.listView);

        Spinner spinner = findViewById(R.id.spinn);
        String[] danhMuc = {"1 - SamSung", "2 - Iphone", "3 - Xiaomi"};
        ArrayAdapter<String> adapterSpinner = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, danhMuc);
        adapterSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapterSpinner);

        EditText editMaSP = findViewById(R.id.maSP),
                editTenSP = findViewById(R.id.tenSP);

        findViewById(R.id.btnNhap).setOnClickListener(view -> {
            SanPham2 sanPham = new SanPham2(spinner.getSelectedItem().toString(), editMaSP.getText().toString(), editTenSP.getText().toString());
            arrSanPham.add(sanPham);
            listView.setAdapter(adapter);
            adapter.setNotifyOnChange(true);
        });
    }
}
