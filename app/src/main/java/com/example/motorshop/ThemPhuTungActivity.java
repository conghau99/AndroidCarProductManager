package com.example.motorshop;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.motorshop.db.DBManager;
import com.example.motorshop.object.PhuTung;

import java.util.Calendar;

public class ThemPhuTungActivity extends AppCompatActivity {
    EditText edtMaPhuTung, edtTenPhuTung, edtSoLuong, edtDonGia, edtHanBaoHanh;
    Spinner spnHangPhuTung, spnHinhPhuTung;

    PhuTung phuTung;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_phu_tung);

        setControl();
        setEvent();
    }

    private void setEvent() {
        ArrayAdapter adapterHang = ArrayAdapter.createFromResource(this, R.array.Hang, R.layout.item_spinner);
        spnHangPhuTung.setAdapter(adapterHang);
        ArrayAdapter adapterHinh = ArrayAdapter.createFromResource(this, R.array.HinhPhuTung, R.layout.item_spinner);
        spnHinhPhuTung.setAdapter(adapterHinh);
    }

    private void setControl() {
        edtMaPhuTung = (EditText) findViewById(R.id.edtMaPhuTung);
        edtSoLuong = (EditText) findViewById(R.id.edtSoLuong);
        edtHanBaoHanh = (EditText) findViewById(R.id.edtHanBaoHanh);
        edtTenPhuTung = (EditText) findViewById(R.id.edtTenPhuTung);
        edtDonGia = (EditText) findViewById(R.id.edtDonGia);
        spnHinhPhuTung = (Spinner) findViewById(R.id.spnHinhPhuTung);
        spnHangPhuTung = (Spinner) findViewById(R.id.spnHangPhuTung);
    }

    private PhuTung getPhuTung() {
        PhuTung item = new PhuTung();
        item.setMaSP(edtMaPhuTung.getText().toString());
        item.setTenSP(edtTenPhuTung.getText().toString());
        item.setSoLuong(edtSoLuong.getText().toString());
        item.setDonGia(edtDonGia.getText().toString());
        item.setHanBH(edtHanBaoHanh.getText().toString());
        if (spnHangPhuTung.getSelectedItem().toString().equals("Honda"))
            item.setMaNCC("HD");
        if (spnHangPhuTung.getSelectedItem().toString().equals("Yamaha"))
            item.setMaNCC("YM");
        if (spnHangPhuTung.getSelectedItem().toString().equals("SYM"))
            item.setMaNCC("SY");
        if (spnHinhPhuTung.getSelectedItem().toString().equals("Cần khởi động"))
            item.setPath(R.drawable.cankhoidong);
        if (spnHinhPhuTung.getSelectedItem().toString().equals("Xích"))
            item.setPath(R.drawable.xich);
        return item;
    }

    public void ChonPhuTung(PhuTung phuTung) {
        this.phuTung = phuTung;
        edtMaPhuTung.setText(phuTung.getMaSP());
        edtTenPhuTung.setText(phuTung.getTenSP());
        edtSoLuong.setText(phuTung.getSoLuong());
        edtDonGia.setText(phuTung.getDonGia());
        edtHanBaoHanh.setText(phuTung.getHanBH());
    }

    private boolean checkNullInfo(EditText e) {
        String s = "" + e.getText();
        if (s.length() == 0) {
            return false;
        } else {
            return true;
        }
    }

    private void thongBao(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }

    public void themPhuTung(View view) {
        if (!checkNullInfo(edtMaPhuTung)) {
            thongBao("Bị thiếu mã phụ tùng");
            return;
        }

        if (!checkNullInfo(edtTenPhuTung)) {
            thongBao("Bị thiếu tên phụ tùng");
            return;
        }

        if (!checkNullInfo(edtSoLuong)) {
            thongBao("Bị thiếu số lượng");
            return;
        }

        if (!checkNullInfo(edtDonGia)) {
            thongBao("Bị thiếu đơn giá");
            return;
        }


        if (!checkNullInfo(edtHanBaoHanh)) {
            thongBao("Bị thiếu hạn bảo hành");
            return;
        }

        DBManager database = new DBManager(ThemPhuTungActivity.this);
        PhuTung phuTung = getPhuTung();
        database.insertPT(phuTung);
        Toast.makeText(ThemPhuTungActivity.this, "Thêm Phụ Tùng Thành Công", Toast.LENGTH_SHORT).show();
        //finish();
        Intent intent = new Intent(this, QuanLyPhuTungActivity.class);
        startActivity(intent);

        //startActivity(getIntent());
    }

    public void chonHanBaoHanh(View view) {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                String date = dayOfMonth + "/" + (monthOfYear + 1) + "/" + year;
                edtHanBaoHanh.setText(date);
            }
        }, year, month, day);
        datePickerDialog.show();
    }

    public void quayLaiPhuTung(View view) {
        Intent intent = new Intent(ThemPhuTungActivity.this, QuanLyPhuTungActivity.class);
        startActivity(intent);
    }

}