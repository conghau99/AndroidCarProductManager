package com.example.motorshop.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.motorshop.object.*;

import java.util.ArrayList;

public class DBManager extends SQLiteOpenHelper {

    public DBManager(Context context) {
        super(context, "dbMOTORSTORE.db", null, 1);
        Log.d("DBManager", "1. Create DB");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        ArrayList<String> createTables = new ArrayList<>();
        createTables.add("CREATE TABLE IF NOT EXISTS BOPHAN (MABP text PRIMARY KEY, TENBP text not null)");
        createTables.add("CREATE TABLE IF NOT EXISTS NHANVIEN(MANV text PRIMARY KEY, HOTEN text not null, SDT text not null, MABP text not null, CONSTRAINT FK_NHANVIEN_BOPHAN FOREIGN KEY (MABP) REFERENCES BOPHAN(MABP))");
        createTables.add("CREATE TABLE IF NOT EXISTS KHACHHANG (SDTKH text PRIMARY KEY, TENKH text not null, DIACHI text not null)");
        createTables.add("CREATE TABLE IF NOT EXISTS NHACUNGCAP (MANCC text PRIMARY KEY, TENNCC text not null, DIACHI text not null, SDT text not null, EMAIL text null)");
        createTables.add("CREATE TABLE IF NOT EXISTS XE (MAXE text PRIMARY KEY, TENXE text not null, SOLUONG text not null, DONGIA text not null, HANBAOHANH text not null, IMAGENAME int null, MANCC text not null, CONSTRAINT FK_XE_NHACUNGCAP FOREIGN KEY (MANCC) REFERENCES NHACUNGCAP(MANCC))");
        createTables.add("CREATE TABLE IF NOT EXISTS PHUTUNG (MAPT text PRIMARY KEY, TENPT text not null, SOLUONG text not null, DONGIA text not null, HANBAOHANH text not null, IMAGENAME int null, MANCC text not null, CONSTRAINT FK_PHUTUNG_NHACUNGCAP FOREIGN KEY (MANCC) REFERENCES NHACUNGCAP(MANCC))");
        createTables.add("CREATE TABLE IF NOT EXISTS THONGSOXE (MATS int PRIMARY KEY, TENTS text not null)");
        createTables.add("CREATE TABLE IF NOT EXISTS CHITIETTHONGSOXE (MAXE text not null, MATS int not null, NOIDUNGTS text not null, CONSTRAINT FK_CHITIETTHONGSOXE_XE FOREIGN KEY (MAXE) REFERENCES XE(MAXE), CONSTRAINT FK_CHITIETTHONGSOXE_THONGSOXE FOREIGN KEY (MATS) REFERENCES THONGSOXE(MATS), PRIMARY KEY (MAXE, MATS))");
        createTables.add("CREATE TABLE IF NOT EXISTS THONGSOPHUTUNG (MAPT text, MAXE text, DONGIA int not null, CONSTRAINT FK_THONGSOPHUTUNG_PHUTUNG FOREIGN KEY (MAPT) REFERENCES PHUTUNG(MAPT), CONSTRAINT FK_THONGSOPHUTUNG_XE FOREIGN KEY (MAXE) REFERENCES XE(MAXE), PRIMARY KEY (MAPT, MAXE))");
        createTables.add("CREATE TABLE IF NOT EXISTS DONDATHANG (MADH text primary key, NGAYDAT text not null, SDTKH text not null, MANV text not null, CONSTRAINT FK_DONDATHANG_KHACHHANG FOREIGN KEY (SDTKH) REFERENCES KHACHHANG(SDTKH), CONSTRAINT FK_DONDATHANG_NHANVIEN FOREIGN KEY (MANV) REFERENCES NHANVIEN(MANV))");
        createTables.add("CREATE TABLE IF NOT EXISTS CHITIETDONDATXE (MADH text not null, MAXE text not null, SOLUONG int not null, DONGIABAN int null, CONSTRAINT FK_CHITIETDONDATXE_DONDATHANG FOREIGN KEY (MADH) REFERENCES DONDATHANG(MADH), CONSTRAINT FK_CHITIETDONDATXE_XE FOREIGN KEY (MAXE) REFERENCES XE(MAXE), PRIMARY KEY (MADH, MAXE))");
        createTables.add("CREATE TABLE IF NOT EXISTS CHITIETDONDATPHUTUNG (MADH text not null, MAPT text not null, SOLUONG int not null, DONGIABAN int null, CONSTRAINT FK_CHITIETDONDATPHUTUNG_DONDATHANG FOREIGN KEY (MADH) REFERENCES DONDATHANG(MADH), CONSTRAINT FK_CHITIETDONDATPHUTUNG_PHUTUNG FOREIGN KEY (MAPT) REFERENCES PHUTUNG(MAPT), PRIMARY KEY (MADH, MAPT))");
        createTables.add("CREATE TABLE IF NOT EXISTS BAOHANH (MABH text primary key, MADH text not null, NGAYBH text not null, CONSTRAINT FK_BAOHANH_DONDATHANG FOREIGN KEY (MADH) REFERENCES DONDATHANG(MADH))");
        createTables.add("CREATE TABLE IF NOT EXISTS CHITIETBAOHANHXE (MABH text not null, MAXE text not null, NOIDUNGBH text not null, PHIBH int null, MANV text not null, CONSTRAINT FK_CHITIETBAOHANHXE_BAOHANH FOREIGN KEY (MABH) REFERENCES BAOHANH(MABH), CONSTRAINT FK_CHITIETBAOHANHXE_XE FOREIGN KEY (MAXE) REFERENCES XE(MAXE), CONSTRAINT FK_CHITIETBAOHANHXE_NHANVIEN FOREIGN KEY (MANV) REFERENCES NHANVIEN(MANV), PRIMARY KEY (MABH, MAXE, NOIDUNGBH))");
        createTables.add("CREATE TABLE IF NOT EXISTS CHITIETBAOHANHPHUTUNG (MABH text not null, MAPT text not null, NOIDUNGBH text not null, PHIBH int null, MANV text not null, CONSTRAINT FK_CHITIETBAOHANHPHUTUNG_BAOHANH FOREIGN KEY (MABH) REFERENCES BAOHANH(MABH), CONSTRAINT FK_CHITIETBAOHANHPHUTUNG_PHUTUNG FOREIGN KEY (MAPT) REFERENCES PHUTUNG(MAPT), CONSTRAINT FK_CHITIETBAOHANHPHUTUNG_NHANVIEN FOREIGN KEY (MANV) REFERENCES NHANVIEN(MANV), PRIMARY KEY (MABH, MAPT, NOIDUNGBH))");

        for (String str : createTables) {
            db.execSQL(str);
            Log.d("DBManager", "2. onCreate: " + str);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS XE");
        onCreate(db);
        Log.d("DBManager", "3. onUpgrade");
    }


    //BO PHAN
    public void insertBP() {
    }

    public void updateBP() {
    }

    public void loadBP() {
    }

    public void deleteBP() {
    }


    //NHAN VIEN
    public void insertNV() {
    }

    public void updateNV() {
    }

    public void loadNV() {
    }

    public void deleteNV() {
    }


    //KHACH HANG
    public void insertKH() {
    }

    public void updateKH() {
    }

    public void loadKH() {
    }

    public void deleteKH() {
    }


    //NHA CUNG CAP
    public void insertNCC() {
    }

    public void updateNCC() {
    }

    public void loadNCC() {
    }

    public void deleteNCC() {
    }


    //XE
    public void insertXe(Xe xe) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("MAXE", xe.getMaSP());
        values.put("TENXE", xe.getTenSP());
        values.put("SOLUONG", xe.getSoLuong());
        values.put("DONGIA", xe.getDonGia());
        values.put("HANBAOHANH", xe.getHanBH());
        values.put("IMAGENAME", xe.getPath());
        values.put("MANCC", xe.getMaNCC());
        db.insert("XE", null, values);
        db.close();
        Log.d("DBManager", "4.1. InsertXe");
    }

    public void updateXe(Xe xe) {
        SQLiteDatabase db = this.getWritableDatabase();
        String sql = "Update  XE  set ";
        sql += "TENXE  = '" + xe.getTenSP() + "' ,  ";
        sql += "SOLUONG  = '" + xe.getSoLuong() + "' ,  ";
        sql += "DONGIA  = '" + xe.getDonGia() + "' ,  ";
        sql += "HANBAOHANH  = '" + xe.getHanBH() + "' ,  ";
        if (xe.getMaNCC().equals("HD"))
            sql += "MANCC  = '" + "Honda" + "' ,  ";
        if (xe.getMaNCC().equals("YM"))
            sql += "MANCC  = '" + "Yamaha" + "' ,  ";
        if (xe.getMaNCC().equals("SY"))
            sql += "MANCC  = '" + "SYM" +"' ,  ";
        sql += "IMAGENAME  = " + xe.getPath();
        sql += "  WHERE MAXE  = '" + xe.getMaSP() + "'";
        db.execSQL(sql);
    }

    public void loadXe(ArrayList<Xe> data) {
        data.clear();
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "select * from XE";
        Cursor cursor = db.rawQuery(query, null);
        if (cursor.moveToFirst()) {
            do {
                Xe xe = new Xe();
                xe.setMaSP(cursor.getString(0));
                xe.setTenSP(cursor.getString(1));
                xe.setSoLuong(cursor.getString(2));
                xe.setDonGia(cursor.getString(3));
                xe.setHanBH(cursor.getString(4));
                xe.setPath(cursor.getInt(5));
                xe.setMaNCC(cursor.getString(6));
                data.add(xe);
            } while (cursor.moveToNext());
        }
    }

    public void deleteXe(Xe xe) {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "DELETE FROM XE WHERE MAXE='" + xe.getMaSP() + "'";
        db.execSQL(query);
        db.close();
        Log.d("DBManager", "5.1. delete");
    }


    //PHU TUNG
    public void insertPT(PhuTung phuTung) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("MAPT", phuTung.getMaSP());
        values.put("TENPT", phuTung.getTenSP());
        values.put("SOLUONG", phuTung.getSoLuong());
        values.put("DONGIA", phuTung.getDonGia());
        values.put("HANBAOHANH", phuTung.getHanBH());
        values.put("IMAGENAME", phuTung.getPath());
        values.put("MANCC", phuTung.getMaNCC());
        db.insert("PHUTUNG", null, values);
        db.close();
        Log.d("DBManager", "4.2. InsertPhuTung");
    }

    public void updatePT(PhuTung phuTung) {
        SQLiteDatabase db = this.getWritableDatabase();
        String sql = "Update  PHUTUNG  set ";
        sql += "TENPT  = '" + phuTung.getTenSP() + "' ,  ";
        sql += "SOLUONG  = '" + phuTung.getSoLuong() + "' ,  ";
        sql += "DONGIA  = '" + phuTung.getDonGia() + "' ,  ";
        sql += "HANBAOHANH  = '" + phuTung.getHanBH() + "' ,  ";
        if (phuTung.getMaNCC().equals("HD"))
            sql += "MANCC  = '" + "Honda" + "' ,  ";
        if (phuTung.getMaNCC().equals("YM"))
            sql += "MANCC  = '" + "Yamaha" + "' ,  ";
        if (phuTung.getMaNCC().equals("SY"))
            sql += "MANCC  = '" + "SYM" +"' ,  ";
        sql += "IMAGENAME  = " + phuTung.getPath();
        sql += "  WHERE MAPT  = '" + phuTung.getMaSP() + "'";
        db.execSQL(sql);
    }

    public void loadPT(ArrayList<PhuTung> data) {
        data.clear();
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "select * from PHUTUNG";
        Cursor cursor = db.rawQuery(query, null);
        if (cursor.moveToFirst()) {
            do {
                PhuTung phuTung = new PhuTung();
                phuTung.setMaSP(cursor.getString(0));
                phuTung.setTenSP(cursor.getString(1));
                phuTung.setSoLuong(cursor.getString(2));
                phuTung.setDonGia(cursor.getString(3));
                phuTung.setHanBH(cursor.getString(4));
                phuTung.setPath(cursor.getInt(5));
                phuTung.setMaNCC(cursor.getString(6));
                data.add(phuTung);
            } while (cursor.moveToNext());
        }
    }

    public void deletePT(PhuTung phuTung) {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "DELETE FROM PHUTUNG WHERE MAPT='" + phuTung.getMaSP() + "'";
        db.execSQL(query);
        db.close();
        Log.d("DBManager", "5.2. delete");
    }


    //THONG SO XE
    public void insertTSX() {
    }

    public void updateTSX() {
    }

    public void loadTSX() {
    }

    public void deleteTSX() {
    }


    //CHI TIET THONG SO XE
    public void insertCTTSX() {
    }

    public void updateCTTSX() {
    }

    public void loadCTTSX() {
    }

    public void deleteCTTSX() {
    }


    //THONG SO PHU TUNG
    public void insertTSPT() {
    }

    public void updateTSPT() {
    }

    public void loadTSPT() {
    }

    public void deleteTSPT() {
    }


    //DON HANG & CHI TIET DON HANG
    //public void insertDH() { }      ->        public void insertCTDH() { }
    public void loadDH() {
    }


//CAC PHAN CON LAI TUONG TU
}



