package com.example.arny.Controller;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.arny.R;

import java.util.ArrayList;
import java.util.Calendar;

public class ThongTinSV_Act extends AppCompatActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.thongtinsv_layout);

        EditText editNgaySinh = findViewById(R.id.ngaySinh),
                editMaSV = findViewById(R.id.maSV),
                editTenSV = findViewById(R.id.tenSV),
                editNoiSinh = findViewById(R.id.noiSinh);
        editNgaySinh.setEnabled(false);
        ListView listView = findViewById(R.id.listView);
        ArrayList<SinhVien> sinhvien = new ArrayList<>();

        findViewById(R.id.btnDatePicker).setOnClickListener(view -> {
            Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR),
                    month = c.get(Calendar.MONTH),
                    day = c.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog datePickerDialog = new DatePickerDialog(this, (view1, year1, monthOfYear, dayOfMonth) -> {
                editNgaySinh.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year1);
            }, year, month, day);
            datePickerDialog.show();
        });

        findViewById(R.id.btnNhap).setOnClickListener(view -> {
            if (editMaSV.getText().toString().matches("")) {
                Toast.makeText(this, "Bạn chưa nhập mã SV", Toast.LENGTH_SHORT).show();
                editMaSV.requestFocus();
                return;
            }
            if (editTenSV.getText().toString().matches("")) {
                Toast.makeText(this, "Bạn chưa nhập tên SV", Toast.LENGTH_SHORT).show();
                editTenSV.requestFocus();
                return;
            }
            if (editNgaySinh.getText().toString().matches("")) {
                Toast.makeText(this, "Bạn chưa chọn ngày sinh", Toast.LENGTH_SHORT).show();
                editNgaySinh.requestFocus();
                return;
            }
            if (editNoiSinh.getText().toString().matches("")) {
                Toast.makeText(this, "Bạn chưa nhập nơi sinh", Toast.LENGTH_SHORT).show();
                editNoiSinh.requestFocus();
                return;
            }
            RadioGroup radioGroup = findViewById(R.id.gioiTinh);
            RadioButton radioButton = radioGroup.findViewById(radioGroup.getCheckedRadioButtonId());
            if (radioGroup.getCheckedRadioButtonId() == -1) {
                Toast.makeText(this, "Hãy chọn giới tính", Toast.LENGTH_SHORT).show();
                return;
            }
            SinhVien sv = new SinhVien(editMaSV.getText().toString(), editTenSV.getText().toString(), radioButton.getText().toString(),
                    editNgaySinh.getText().toString(), editNoiSinh.getText().toString());

            sinhvien.add(sv);

            ArrayAdapter adapter = new ArrayAdapter(ThongTinSV_Act.this, android.R.layout.simple_list_item_2, android.R.id.text1, sinhvien) {
                @Override
                public View getView(int position, View convertView, ViewGroup parent) {
                    View view = super.getView(position, convertView, parent);
                    TextView text1 = view.findViewById(android.R.id.text1);
                    TextView text2 = view.findViewById(android.R.id.text2);

                    text1.setText(sinhvien.get(position).title());
                    text2.setText(sinhvien.get(position).subtitle());
                    return view;
                }
            };
            listView.setAdapter(adapter);

            adapter.notifyDataSetChanged();
        });


        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle("Thông tin sinh viên");
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
