package com.example.arny.Model;

public class NhanVien {

    private String maNV, tenNV, gioiTinh;

    public NhanVien(String maNV, String tenNV, String gioiTinh) {
        this.maNV = maNV;
        this.tenNV = tenNV;
        this.gioiTinh= gioiTinh;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    @Override
    public String toString() {
        return maNV + " - " + tenNV;
    }
}
