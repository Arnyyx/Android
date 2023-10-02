package com.example.arny.Database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.arny.Model.TacGia;

import java.util.ArrayList;
import java.util.List;

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

//    public List<TacGia> getAll(String table_name) {
//        List<TacGia> tacGia = new ArrayList<>();
//        String selectQuery = "SELECT  * FROM " + table_name;
//        SQLiteDatabase db = this.getWritableDatabase();
//        Cursor cursor = db.rawQuery(selectQuery, null);
//        if (cursor.moveToFirst()) {
//            do {
//                TacGia[] obj = new TacGia[2];
//                obj[0] = cursor.getString(cursor.getColumnIndex("maTacGia"));
//                obj[1] = cursor.getInt(cursor.getColumnIndex("tenTacGia"));
//                tacGia.add(obj);
//            } while (cursor.moveToNext());
//        }
//        db.close();
//        return tacGia;
//    }
}
