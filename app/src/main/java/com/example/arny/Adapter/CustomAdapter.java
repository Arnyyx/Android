package com.example.arny.Adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.arny.Model.NhanVien;
import com.example.arny.R;

import java.util.ArrayList;
import java.util.Objects;

public class CustomAdapter extends ArrayAdapter<NhanVien> {
    Activity context;
    ArrayList<NhanVien> arrNV;
    int layouID;

    public CustomAdapter(Activity context, int resource, ArrayList<NhanVien> arrNV) {
        super(context, resource, arrNV);
        this.context = context;
        this.layouID = resource;
        this.arrNV = arrNV;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View item_layout = null;

        LayoutInflater inflater = context.getLayoutInflater();
        convertView = inflater.inflate(layouID, null);

        NhanVien nhanVien = arrNV.get(position);

        TextView textView = convertView.findViewById(R.id.item_text);
        textView.setText(arrNV.get(position).toString());

        ImageView imageView = convertView.findViewById(R.id.item_icon);
        if (Objects.equals(nhanVien.getGioiTinh(), "Nam"))
            imageView.setImageResource(R.drawable.boy);
        else imageView.setImageResource(R.drawable.girl);

        return convertView;
    }
}
