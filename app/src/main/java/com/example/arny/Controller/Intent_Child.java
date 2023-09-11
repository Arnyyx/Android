package com.example.arny.Controller;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.arny.R;

public class Intent_Child extends AppCompatActivity {

    EditText text;
    Integer a;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intent_child);

        text = findViewById(R.id.editText);

        findViewById(R.id.btnLuuBinhPhuong).setOnClickListener(view -> {
            a = Integer.parseInt(text.getText().toString());
            Intent intent = new Intent(this, Intent_Parent.class);
            intent.putExtra("a", a);
            setResult(AppCompatActivity.RESULT_OK, intent);
            finish();
        });

    }
}
