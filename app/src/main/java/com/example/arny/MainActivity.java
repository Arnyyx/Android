package com.example.arny;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.arny.Controller.AutoComplete_Act;
import com.example.arny.Controller.BMI_Act;
import com.example.arny.Controller.GridView_Act;
import com.example.arny.Controller.HoaDon_Act;
import com.example.arny.Controller.Intent_Parent;
import com.example.arny.Controller.ListView_Act;
import com.example.arny.Controller.Relative_Act;
import com.example.arny.Controller.Spinner2_Act;
import com.example.arny.Controller.Spinner_Act;
import com.example.arny.Controller.ThongTinCaNhan_Act;
import com.example.arny.Controller.ThongTinSV_Act;
import com.example.arny.Controller.ToastCheckboxRadio_Act;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn1).setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, ThongTinCaNhan_Act.class);
            startActivity(intent);
        });

        findViewById(R.id.btn2).setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, BMI_Act.class);
            startActivity(intent);
        });

        findViewById(R.id.btn3).setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, ToastCheckboxRadio_Act.class);
            startActivity(intent);
        });

        findViewById(R.id.btn4).setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, Relative_Act.class);
            startActivity(intent);
        });

        findViewById(R.id.btn5).setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, HoaDon_Act.class);
            startActivity(intent);
        });

        findViewById(R.id.btn6).setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, ListView_Act.class);
            startActivity(intent);
        });
        findViewById(R.id.btn7).setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, Spinner_Act.class);
            startActivity(intent);
        });

        findViewById(R.id.btn8).setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, ThongTinSV_Act.class);
            startActivity(intent);
        });
        findViewById(R.id.btn9).setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, AutoComplete_Act.class);
            startActivity(intent);
        });
        findViewById(R.id.btn10).setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, GridView_Act.class);
            startActivity(intent);
        });
        findViewById(R.id.btn11).setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, Spinner2_Act.class);
            startActivity(intent);
        });
        findViewById(R.id.btn12).setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, Intent_Parent.class);
            startActivity(intent);
        });
    }
}