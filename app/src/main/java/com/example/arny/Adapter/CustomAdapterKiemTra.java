package com.example.arny.Adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.arny.Controller.KiemTraGioHang;
import com.example.arny.Model.NhanVien;
import com.example.arny.Model.SanPham;
import com.example.arny.R;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Objects;

public class CustomAdapterKiemTra extends ArrayAdapter<SanPham> {
    Activity context;
    ArrayList<SanPham> arrSP;
    int layouID;

    public CustomAdapterKiemTra(Activity context, int resource, ArrayList<SanPham> arrSP) {
        super(context, resource, arrSP);
        this.context = context;
        this.layouID = resource;
        this.arrSP = arrSP;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View item_layout = null;

        LayoutInflater inflater = context.getLayoutInflater();
        convertView = inflater.inflate(layouID, null);

        SanPham sanPham = arrSP.get(position);

        TextView textView = convertView.findViewById(R.id.thongTinSP);
        textView.setText(sanPham.getThongtin());

        ImageView imageView = convertView.findViewById(R.id.logoSP);
        imageView.setImageResource(sanPham.getLogo());

        ImageButton imageButton = convertView.findViewById(R.id.gioHangSP);
        imageButton.setOnClickListener(v -> {
            Intent intent = new Intent(context, KiemTraGioHang.class);
            String spStr = sanPham.getThongtin() + " - " + sanPham.getGia();
            intent.putExtra("sanPham", spStr);
            context.startActivity(intent);
        });

        return convertView;
    }
}
