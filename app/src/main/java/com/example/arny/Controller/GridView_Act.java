package com.example.arny.Controller;

import android.os.Bundle;
import android.widget.GridView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.arny.Adapter.CustomAdapterImage_Act;
import com.example.arny.R;

public class GridView_Act extends AppCompatActivity {
    int logos[] = {R.drawable.icon, R.drawable.boy, R.drawable.user1, R.drawable.girl};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gridview_layout);

        GridView gridView = findViewById(R.id.gridView);

        CustomAdapterImage_Act customAdapter = new CustomAdapterImage_Act(this, logos);

        gridView.setAdapter(customAdapter);

    }
}
