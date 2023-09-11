package com.example.arny.Controller;

public class SinhVien {
    private String maSV, tenSV, gioiTinh, ngaySinh, noiSinh;

    public SinhVien(String maSV, String tenSV, String gioiTinh, String ngaySinh, String noiSinh) {
        this.maSV = maSV;
        this.tenSV = tenSV;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.noiSinh = noiSinh;
    }

    public String title() {
        return maSV + " - " + tenSV;
    }

    public String subtitle() {
        return gioiTinh + " - " + ngaySinh + " - " + noiSinh;
    }
}
