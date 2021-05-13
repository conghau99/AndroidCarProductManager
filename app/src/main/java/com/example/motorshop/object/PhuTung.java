package com.example.motorshop.object;

import java.util.ArrayList;

public class PhuTung extends com.example.motorshop.object.SanPham {
    ArrayList<ThongSoPT> danhSachTSPT;

    public PhuTung() {
        super();
    }

    public PhuTung(String maSP, String tenSP, String soLuong, String donGia, String hanBH, int path, String maNCC, ArrayList<ThongSoPT> danhSachTSPT) {
        super(maSP, tenSP, soLuong, donGia, hanBH, path, maNCC);
        this.danhSachTSPT = danhSachTSPT;
    }

    public ArrayList<ThongSoPT> getDanhSachTSPT() {
        return danhSachTSPT;
    }

    public void setDanhSachTSPT(ArrayList<ThongSoPT> danhSachTSPT) {
        this.danhSachTSPT = danhSachTSPT;
    }
}


class ThongSoPT{
    private String tenXe;
    private int donGia;

    public ThongSoPT() { }

    public ThongSoPT(String tenXe, int donGia) {
        this.tenXe = tenXe;
        this.donGia = donGia;
    }

    public String getTenXe() {
        return tenXe;
    }

    public void setTenXe(String tenXe) {
        this.tenXe = tenXe;
    }

    public int getDonGia() {
        return donGia;
    }

    public void setDonGia(int donGia) {
        this.donGia = donGia;
    }
}