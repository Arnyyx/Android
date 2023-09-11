package com.example.arny.Controller;


public class SanPham2 {
    private String danhMuc, maSP, tenSP;

    public SanPham2(String danhMuc,String maSP, String tenSP) {
        this.danhMuc = danhMuc;
        this.maSP = maSP;
        this.tenSP = tenSP;
    }

    @Override
    public String toString() {
        return maSP + " - " + tenSP;
    }
}