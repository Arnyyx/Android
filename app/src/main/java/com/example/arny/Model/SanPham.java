package com.example.arny.Model;

public class SanPham {
    int logo;
    String thongtin, gia;

    public SanPham(int logo, String thongtin, String gia) {
        this.logo = logo;
        this.thongtin = thongtin;
        this.gia = gia;
    }

    public int getLogo() {
        return logo;
    }

    public String getGia() {
        return gia;
    }

    public void setGia(String gia) {
        this.gia = gia;
    }

    public void setLogo(int logo) {
        this.logo = logo;
    }

    public String getThongtin() {
        return thongtin;
    }

    public void setThongtin(String thongtin) {
        this.thongtin = thongtin;
    }
}
