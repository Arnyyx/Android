package com.example.arny.Controller;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.arny.Adapter.CustomAdapter;
import com.example.arny.Model.NhanVien;
import com.example.arny.R;

import java.util.ArrayList;

public class ListView_Act extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_layout);

        ArrayList<NhanVien> arrNV = new ArrayList<>();
        CustomAdapter adapterNV = new CustomAdapter(this, R.layout.item_layout, arrNV);
        ListView listView = findViewById(R.id.lv);
        listView.setAdapter(adapterNV);

        EditText editMaNV = findViewById(R.id.maNV),
                editTenNV = findViewById(R.id.tenNV);

        findViewById(R.id.btnNhap).setOnClickListener(view -> {
            if (editMaNV.getText().toString().matches("")) {
                Toast.makeText(this, "Bạn chưa nhập mã NV", Toast.LENGTH_SHORT).show();
                editMaNV.requestFocus();
                return;
            }
            if (editTenNV.getText().toString().matches("")) {
                Toast.makeText(this, "Bạn chưa nhập tên NV", Toast.LENGTH_SHORT).show();
                editTenNV.requestFocus();
                return;
            }
            RadioGroup radioGroup = findViewById(R.id.groupLoaiNV);
            RadioButton radioButton = radioGroup.findViewById(radioGroup.getCheckedRadioButtonId());
            if (radioGroup.getCheckedRadioButtonId() == -1) {
                Toast.makeText(this, "Hãy chọn giới tính", Toast.LENGTH_SHORT).show();
                return;
            }

            NhanVien nhanVien = new NhanVien(editMaNV.getText().toString(), editTenNV.getText().toString(), radioButton.getText().toString());

//            Bản gốc
            arrNV.add(nhanVien);
            adapterNV.notifyDataSetChanged();

//          Vẫn là cho nhân viên vào listView nhưng nhanVien mới được cho lên đầu

//            listView.post(() -> {
//                arrNV.add(0, nhanVien);
//                adapterNV.notifyDataSetChanged();
//                listView.smoothScrollToPosition(0);
//            });

        });

        findViewById(R.id.btnXoa).setOnClickListener(view -> {
            for (int i = listView.getChildCount() - 1; i >= 0; i--) {
                View v = listView.getChildAt(i);
                CheckBox chk = v.findViewById(R.id.checkItem);
                if (chk.isChecked()) {
                    arrNV.remove(i);
                }
            }
            adapterNV.notifyDataSetChanged();
        });

        findViewById(R.id.btnXoaTatCa).setOnClickListener(view -> {
            for (int i = listView.getChildCount() - 1; i >= 0; i--) {
                View v = listView.getChildAt(i);
                CheckBox chk = v.findViewById(R.id.checkItem);
                arrNV.remove(i);
            }
            adapterNV.notifyDataSetChanged();
        });


        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle("List View");
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

