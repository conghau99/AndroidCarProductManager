package com.example.motorshop.object;

public class SanPham {
    private String maSP;
    private String tenSP;
    private String soLuong;
    private String donGia;
    private String hanBH;
    private int path;
    private String maNCC;

    public SanPham() { }

    public SanPham(String maSP, String tenSP, String soLuong, String donGia, String hanBH, int path, String maNCC) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.hanBH = hanBH;
        this.path = path;
        this.maNCC = maNCC;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public String getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(String soLuong) {
        this.soLuong = soLuong;
    }

    public String getDonGia() {
        return donGia;
    }

    public void setDonGia(String donGia) {
        this.donGia = donGia;
    }

    public String getHanBH() {
        return hanBH;
    }

    public void setHanBH(String hanBH) {
        this.hanBH = hanBH;
    }

    public int getPath() {
        return path;
    }

    public void setPath(int path) {
        this.path = path;
    }

    public String getMaNCC() {
        return maNCC;
    }

    public void setMaNCC(String maNCC) {
        this.maNCC = maNCC;
    }
}

