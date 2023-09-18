package com.example.arny.Controller;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.arny.R;

import java.util.ArrayList;

public class Intent_Parent extends AppCompatActivity {
    ListView listView;
    Integer a;
    ArrayList<Integer> arr = new ArrayList<>();
    ArrayAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intent_parent);

        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arr);

        findViewById(R.id.btn).setOnClickListener(view -> {
            startActivityForResult(new Intent(this, Intent_Child.class), 1);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        listView = findViewById(R.id.listView);
        a = data.getIntExtra("a", 1);
        arr.add(a);
        listView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}