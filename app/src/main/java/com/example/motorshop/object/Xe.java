package com.example.motorshop.object;

import java.util.ArrayList;

public class Xe extends SanPham {
    ArrayList<ThongSoXe> danhSachTSX;

    public Xe() {
        super();
    }

    public Xe(String maSP, String tenSP, String soLuong, String donGia, String hanBH, int path, String maNCC, ArrayList<ThongSoXe> danhSachTSX) {
        super(maSP, tenSP, soLuong, donGia, hanBH, path, maNCC);
        this.danhSachTSX = danhSachTSX;
    }

    public Xe(String maSP, String tenSP, String soLuong, String donGia, String hanBH, int path, String maNCC) {
        super(maSP, tenSP, soLuong, donGia, hanBH, path, maNCC);
    }

    public ArrayList<ThongSoXe> getDanhSachTSX() {
        return danhSachTSX;
    }

    public void setDanhSachTSX(ArrayList<ThongSoXe> danhSachTSX) {
        this.danhSachTSX = danhSachTSX;
    }
}


class ThongSoXe {
    private int tenTS;
    private String noiDungTS;

    public ThongSoXe() { }

    public ThongSoXe(int tenTS, String noiDungTS) {
        this.tenTS = tenTS;
        this.noiDungTS = noiDungTS;
    }

    public int getTenTS() {
        return tenTS;
    }

    public void setTenTS(int tenTS) {
        this.tenTS = tenTS;
    }

    public String getNoiDungTS() {
        return noiDungTS;
    }

    public void setNoiDungTS(String noiDungTS) {
        this.noiDungTS = noiDungTS;
    }
}
