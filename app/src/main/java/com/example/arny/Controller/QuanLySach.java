package com.example.arny.Controller;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.arny.Database.SQLiteDB;
import com.example.arny.R;

public class QuanLySach extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quanlysach_layout);

        Dialog dialog = new Dialog(this);

        findViewById(R.id.btnThemTacGia).setOnClickListener(v -> {
            dialog.setContentView(R.layout.themtacgia);
            dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
            dialog.setCancelable(true);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));


//            dialog.findViewById(R.id.huyBtn).setOnClickListener(v1 -> dialog.dismiss());

            dialog.findViewById(R.id.btnLuuTacGia).setOnClickListener(view -> {
                EditText a = dialog.findViewById(R.id.a);
                EditText b = dialog.findViewById(R.id.b);

                SQLiteDB sq = new SQLiteDB(this, "tacGia", null, 1);
                sq.QueryData("CREATE TABLE IF NOT EXISTS tacGia(maTacGia TEXT PRIMARY KEY, tenTacGia TEXT)");
                sq.QueryData("INSERT INTO tacGia VALUES('" + a.getText().toString() + "','" + b.getText().toString() + "')");
                Cursor c = sq.getData("SELECT * FROM tacGia");
                while (c.moveToNext()) {
                    Toast.makeText(this, c.getString(0) + " " + c.getString(1), Toast.LENGTH_SHORT).show();
                }
                dialog.dismiss();
            });
            dialog.findViewById(R.id.xoaTrangThemBtn).setOnClickListener(view -> {
                EditText a = dialog.findViewById(R.id.a);
                EditText b = dialog.findViewById(R.id.b);
                a.getText().clear();
                b.getText().clear();
            });

            dialog.show();
        });

        findViewById(R.id.btnXemDanhSach).setOnClickListener(view -> {

        });
    }
}
