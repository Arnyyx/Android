package com.example.arny.Controller;


public class SanPham {
    private String maSP, tenSP;

    public SanPham(String maSP, String tenSP) {
        this.maSP = maSP;
        this.tenSP = tenSP;
    }

    @Override
    public String toString() {
        return maSP + " - " + tenSP;
    }
}
