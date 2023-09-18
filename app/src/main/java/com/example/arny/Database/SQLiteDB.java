package com.example.arny.Database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLiteDB extends SQLiteOpenHelper {
    public SQLiteDB(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void QueryData(String sql) {
        SQLiteDatabase data = getWritableDatabase();
        data.execSQL(sql);
    }

    public Cursor getData(String sql) {
        SQLiteDatabase data = getReadableDatabase();
        return data.rawQuery(sql, null);
    }
}
