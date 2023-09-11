package com.example.arny.Controller;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.arny.R;

import java.util.ArrayList;

public class AutoComplete_Act extends AppCompatActivity  {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.autocomplete);

        ArrayList<String> arr = new ArrayList<>();
        arr.add("Ha Noi");
        arr.add("Ha Nam");
        arr.add("Cao Bang");
        arr.add("Bac Ninh");

        ArrayAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arr);
        AutoCompleteTextView ac =  findViewById(R.id.autoComplete);
        ac.setAdapter(adapter);
    }
}
