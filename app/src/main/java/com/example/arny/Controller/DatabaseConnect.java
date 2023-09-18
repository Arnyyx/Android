package com.example.arny.Controller;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.arny.Database.SQLiteDB;
import com.example.arny.R;

public class DatabaseConnect extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.databaseconnect);

        SQLiteDB sq = new SQLiteDB(this, "tk.db", null, 1);
        sq.QueryData("CREATE TABLE IF NOT EXISTS tk(User TEXT PRIMARY KEY, PASS TEXT)");
        sq.QueryData("INSERT INTO tk VALUES('aaa', '123')");
        Cursor c = sq.getData("SELECT * FROM tk");
        while (c.moveToNext()) {
            Toast.makeText(this, c.getString(0), Toast.LENGTH_SHORT).show();
        }

    }
}
