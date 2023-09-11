package com.example.arny.Controller;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.arny.Model.KhachHang;
import com.example.arny.R;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;

public class HoaDon_Act extends AppCompatActivity {
    ArrayList<KhachHang> listKH = new ArrayList<>();
    EditText editTen, editSoLuongSach, editThanhTien, editTongSoKH, edittongKHVIP, edittongDoanhThu;
    CheckBox checkBoxVIP;
    int tongSoKH = 0, tongKHVIP = 0, tongDoanhThu = 0;
    double thanhTien;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nhaphoadon_layout);

        editTen = findViewById(R.id.ten);
        editSoLuongSach = findViewById(R.id.soLuongSach);
        editThanhTien = findViewById(R.id.thanhTien);
        editTongSoKH = findViewById(R.id.tongSoKH);
        checkBoxVIP = findViewById(R.id.checkVIP);
        edittongKHVIP = findViewById(R.id.tongKHVIP);
        edittongDoanhThu = findViewById(R.id.tongDoanhThu);

        editTen.requestFocus();
        editThanhTien.setEnabled(false);
        editTongSoKH.setEnabled(false);
        edittongKHVIP.setEnabled(false);
        edittongDoanhThu.setEnabled(false);
        findViewById(R.id.btnTiep).setEnabled(false);

        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setGroupingSeparator(' ');
        DecimalFormat df = new DecimalFormat("###,###", symbols);

        findViewById(R.id.btnThanhTien).setOnClickListener(view -> {
            if (editTen.getText().toString().matches("")) {
                Toast.makeText(HoaDon_Act.this, "Bạn chưa nhập tên khách hàng", Toast.LENGTH_SHORT).show();
                editTen.requestFocus();
                return;
            }
            if (editSoLuongSach.getText().toString().matches("")) {
                Toast.makeText(HoaDon_Act.this, "Bạn chưa nhập số lượng sách", Toast.LENGTH_SHORT).show();
                editSoLuongSach.requestFocus();
                return;
            }

            int soLuongSach = Integer.parseInt(editSoLuongSach.getText().toString());

            thanhTien = soLuongSach * 20000;
            if (checkBoxVIP.isChecked()) {
                thanhTien = thanhTien * 0.9;
            }
            editThanhTien.setText((df.format(thanhTien)));

            editTen.setEnabled(false);
            editSoLuongSach.setEnabled(false);
            checkBoxVIP.setEnabled(false);
            findViewById(R.id.btnThanhTien).setEnabled(false);
            findViewById(R.id.btnTiep).setEnabled(true);
        });

        findViewById(R.id.btnTiep).setOnClickListener(view -> {
            tongSoKH = tongSoKH + 1;
            if (checkBoxVIP.isChecked()) {
                tongKHVIP = tongKHVIP + 1;
            }
            tongDoanhThu += thanhTien;

            KhachHang khachHang = new KhachHang(editTen.getText().toString(), Integer.parseInt(editSoLuongSach.getText().toString()), checkBoxVIP.isChecked(), thanhTien);
            listKH.add(khachHang);

//            String KH = editTen.getText().toString() + " " + editSoLuongSach.getText().toString() + editThanhTien.getText().toString();
//            list.add(KH);
            Toast.makeText(this, "Đã lưu khách hàng " + editTen.getText().toString(), Toast.LENGTH_SHORT).show();

            editTen.setText("");
            editSoLuongSach.setText("");
            editThanhTien.setText("");

            editTen.setEnabled(true);
            editTen.requestFocus();
            editSoLuongSach.setEnabled(true);
            findViewById(R.id.btnThanhTien).setEnabled(true);
            findViewById(R.id.btnTiep).setEnabled(false);
        });

        findViewById(R.id.btnHuy).setOnClickListener(view -> {
            editTen.setEnabled(true);
            editSoLuongSach.setEnabled(true);
            checkBoxVIP.setEnabled(true);
            findViewById(R.id.btnThanhTien).setEnabled(true);
            findViewById(R.id.btnTiep).setEnabled(false);
        });

        findViewById(R.id.btnThongKe).setOnClickListener(view -> {
            editTongSoKH.setText(String.valueOf(tongSoKH));
            edittongKHVIP.setText(String.valueOf(tongKHVIP));
            edittongDoanhThu.setText((String.valueOf(tongDoanhThu)));
        });

        findViewById(R.id.btnThoat).setOnClickListener(view -> {
            AlertDialog.Builder b = new AlertDialog.Builder(HoaDon_Act.this);
            b.setTitle("Bạn có muốn thoát?");
            b.setCancelable(true);
            b.setPositiveButton("Đồng ý", (dialogInterface, i) -> finish());
            b.setNegativeButton("Huỷ", (dialogInterface, i) -> {
            });
            b.show();
        });

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle("Nhập hoá đơn");
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

