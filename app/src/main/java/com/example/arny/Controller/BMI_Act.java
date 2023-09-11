package com.example.arny.Controller;

import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.arny.R;


public class BMI_Act extends AppCompatActivity {
    EditText ten, chieuCao, canNang, ketQua, chanDoan;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bmi_layout);

        ten = findViewById(R.id.ten);
        canNang = findViewById(R.id.canNang);
        chieuCao = findViewById(R.id.chieuCao);
        ketQua = findViewById(R.id.BMI);
        chanDoan = findViewById(R.id.chanDoan);

        ten.requestFocus();
        ketQua.setEnabled(false);
        chanDoan.setEnabled(false);

        findViewById(R.id.tinhBtn).setOnClickListener(view -> {
            if (chieuCao.getText().toString().matches("")) {
                Toast.makeText(this, "Bạn chưa nhập chiều cao", Toast.LENGTH_SHORT).show();
                chieuCao.requestFocus();
                return;
            }
            if (canNang.getText().toString().matches("")) {
                Toast.makeText(this, "Bạn chưa nhập cân nặng", Toast.LENGTH_SHORT).show();
                canNang.requestFocus();
                return;
            }
            if (ten.getText().toString().matches("")) {
                Toast.makeText(this, "Hãy nhập tên của bạn", Toast.LENGTH_SHORT).show();
            }

            Handler handler = new Handler();
            float can = Float.parseFloat(canNang.getText().toString());
            float cao = Float.parseFloat(chieuCao.getText().toString());
            float kq = can / (cao * cao);
            ketQua.setText("Đang tính kết quả...");
            chanDoan.setText("Đang tính kết quả...");

            String a = "Người gầy",
                    b = "Người bình thường siu khoẻ mạnh nhaa :33",
                    c = "Người béo phì độ I",
                    d = "Người béo phì độ II",
                    e = "Người béo phì độ III";

            handler.postDelayed(() -> {
                ketQua.setText(String.valueOf(kq));
                if (kq < 18) {
                    chanDoan.setText(a);
                } else if (kq < 25) {
                    chanDoan.setText(b);
                } else if (kq < 30) {
                    chanDoan.setText(c);
                } else if (kq < 35) {
                    chanDoan.setText(d);
                } else chanDoan.setText(e);
            }, 700);
        });

        findViewById(R.id.reset).setOnClickListener(view -> {
            ten.setText("");
            canNang.setText("");
            chieuCao.setText("");
            ketQua.setText("");
            chanDoan.setText("");
            ten.requestFocus();
        });

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle("Tính BMI");
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
