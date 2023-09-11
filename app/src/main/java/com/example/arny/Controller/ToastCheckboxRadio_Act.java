package com.example.arny.Controller;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.arny.R;

public class ToastCheckboxRadio_Act extends AppCompatActivity {
    String s = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.toast_checkbox_radiobutton_layout);

        findViewById(R.id.btnToastShort).setOnClickListener(view -> Toast.makeText(ToastCheckboxRadio_Act.this, "This is short toast", Toast.LENGTH_SHORT).show());
        findViewById(R.id.btnToastLong).setOnClickListener(view -> Toast.makeText(this, "This is long toast", Toast.LENGTH_LONG).show());


        findViewById(R.id.btnDialog).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder b = new AlertDialog.Builder(ToastCheckboxRadio_Act.this);
                b.setTitle("Hello World");
                b.setMessage("Do you want to exit?");
                b.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                b.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        b.setCancelable(true);
                    }
                });
                b.show();
            }
        });

        CheckBox ch1, ch2, ch3, ch4;
        ch1 = findViewById(R.id.xemBongDa);
        ch2 = findViewById(R.id.phimKiemHiep);
        ch3 = findViewById(R.id.diDuLich);
        ch4 = findViewById(R.id.tuDiMotMinh);

        findViewById(R.id.btnVote).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String msg = "Ban da chon: ";

                if (ch1.isChecked())
                    msg += ch1.getText().toString() + ", ";
                if (ch2.isChecked())
                    msg += ch2.getText().toString() + ", ";
                if (ch3.isChecked())
                    msg += ch3.getText().toString() + ", ";
                if (ch4.isChecked())
                    msg += ch4.getText().toString() + ", ";


                Toast.makeText(ToastCheckboxRadio_Act.this, msg, Toast.LENGTH_LONG).show();
            }
        });

        RadioGroup rGrp = findViewById(R.id.rGrp);

        rGrp.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                RadioButton radioButton = radioGroup.findViewById(i);
                s = radioButton.getText().toString();
            }
        });

        findViewById(R.id.btnVote2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ToastCheckboxRadio_Act.this, s, Toast.LENGTH_SHORT).show();
            }
        });

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
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
