package com.example.arny.Controller;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.arny.Adapter.CustomAdapterKiemTra;
import com.example.arny.Model.SanPham;
import com.example.arny.R;

import java.util.ArrayList;

public class KiemTra extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kiemtra_layout);

        ArrayList<SanPham> arrSP = new ArrayList<>();
        arrSP.add(new SanPham((R.drawable.boy), "San pham 1", "10000"));
        arrSP.add(new SanPham((R.drawable.boy), "San pham 2", "10000"));
        arrSP.add(new SanPham((R.drawable.boy), "San pham 3", "10000"));
        arrSP.add(new SanPham((R.drawable.boy), "San pham 4", "10000"));
        arrSP.add(new SanPham((R.drawable.boy), "San pham 5", "10000"));

        GridView gridView = findViewById(R.id.gridView);
        CustomAdapterKiemTra adapterKiemTra = new CustomAdapterKiemTra(this, R.layout.item_kiemtra_layout, arrSP);
        gridView.setAdapter(adapterKiemTra);


    }
}
