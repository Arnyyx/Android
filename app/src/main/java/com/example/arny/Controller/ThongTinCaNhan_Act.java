package com.example.arny.Controller;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.arny.R;

public class ThongTinCaNhan_Act extends AppCompatActivity {
    String thongTin = "";
    CheckBox ch1, ch2, ch3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.thongtincanhan_layout);

        EditText editTen = findViewById(R.id.hoTen),
                editCMND = findViewById(R.id.cmnd),
                editBoSung = findViewById(R.id.boSung);

        ch1 = findViewById(R.id.check1);
        ch2 = findViewById(R.id.check2);
        ch3 = findViewById(R.id.check3);

        editTen.requestFocus();

        findViewById(R.id.btnGuiThongTin).setOnClickListener(view -> {
            thongTin = "";
            String ten = "", CMND = "", boSung = "";
            editTen.requestFocus();

            ten = editTen.getText().toString();
            CMND = editCMND.getText().toString();
            boSung = editBoSung.getText().toString();

            String soThich = "";
            if (ch1.isChecked())
                soThich += ch1.getText().toString() + " - ";
            if (ch2.isChecked())
                soThich += ch2.getText().toString() + " - ";
            if (ch3.isChecked())
                soThich += ch3.getText().toString();

            if (ten == "") {
                Toast.makeText(this, "Nhập họ tên", Toast.LENGTH_SHORT).show();
                editTen.requestFocus();
                return;
            }
            if (CMND == "") {
                Toast.makeText(this, "Nhập CMND", Toast.LENGTH_SHORT).show();
                editCMND.requestFocus();
                return;
            }
            RadioGroup radioGroup = findViewById(R.id.groupBangCap);
            if (radioGroup.getCheckedRadioButtonId() == -1) {
                Toast.makeText(ThongTinCaNhan_Act.this, "Hãy chọn bằng cấp", Toast.LENGTH_SHORT).show();
                return;
            }
            RadioButton radioButton = radioGroup.findViewById(radioGroup.getCheckedRadioButtonId());
            String bangCap = radioButton.getText().toString();

            thongTin = "Họ tên: " + ten
                    + "\nCMND: " + CMND
                    + "\nBằng cấp: " + bangCap
                    + "\nSở thích: " + soThich
                    + "\n-----------------------------"
                    + "\nThông tin bổ sung:" + boSung;

            AlertDialog.Builder b = new AlertDialog.Builder(ThongTinCaNhan_Act.this);
            b.setTitle("Thông tin cá nhân");
            b.setMessage(thongTin);
            b.setCancelable(true);
            b.setPositiveButton("Đóng", (dialogInterface, i) -> {
            });
            b.show();
        });

        findViewById(R.id.btnDatLai).setOnClickListener(view -> {
            editTen.requestFocus();
            editTen.setText("");
            editCMND.setText("");
            RadioGroup radioGroup = findViewById(R.id.groupBangCap);
            radioGroup.clearCheck();

            thongTin = "";
        });

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle("Thông tin cá nhân");
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
