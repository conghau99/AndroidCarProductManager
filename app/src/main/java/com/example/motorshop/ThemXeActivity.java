package com.example.motorshop;

import androidx.appcompat.app.AppCompatActivity;

import com.example.motorshop.db.DBManager;
import com.example.motorshop.object.*;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Calendar;

public class ThemXeActivity extends AppCompatActivity {
    EditText edtMaXe, edtTenXe, edtSoLuong, edtDonGia, edtHanBaoHanh;
    Spinner spnHangXe, spnHinhXe;

    Xe xe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_xe);

        setControl();
        setEvent();
    }

    private void setEvent() {
        ArrayAdapter adapterHang = ArrayAdapter.createFromResource(this, R.array.Hang, R.layout.item_spinner);
        spnHangXe.setAdapter(adapterHang);
        ArrayAdapter adapterHinh = ArrayAdapter.createFromResource(this, R.array.HinhXe, R.layout.item_spinner);
        spnHinhXe.setAdapter(adapterHinh);
    }

    private void setControl() {
        edtMaXe = (EditText) findViewById(R.id.edtMaXe);
        edtSoLuong = (EditText) findViewById(R.id.edtSoLuong);
        edtHanBaoHanh = (EditText) findViewById(R.id.edtHanBaoHanh);
        edtTenXe = (EditText) findViewById(R.id.edtTenXe);
        edtDonGia = (EditText) findViewById(R.id.edtDonGia);
        spnHinhXe = (Spinner) findViewById(R.id.spnHinhXe);
        spnHangXe = (Spinner) findViewById(R.id.spnHangXe);
    }

    private Xe getXe() {
        Xe item = new Xe();
        item.setMaSP(edtMaXe.getText().toString());
        item.setTenSP(edtTenXe.getText().toString());
        item.setSoLuong(edtSoLuong.getText().toString());
        item.setDonGia(edtDonGia.getText().toString());
        item.setHanBH(edtHanBaoHanh.getText().toString());
        if (spnHangXe.getSelectedItem().toString().equals("Honda"))
            item.setMaNCC("HD");
        if (spnHangXe.getSelectedItem().toString().equals("Yamaha"))
            item.setMaNCC("YM");
        if (spnHangXe.getSelectedItem().toString().equals("SYM"))
            item.setMaNCC("SY");
        if (spnHinhXe.getSelectedItem().toString().equals("Vision trắng"))
            item.setPath(R.drawable.vision1);
        if (spnHinhXe.getSelectedItem().toString().equals("Vision đỏ"))
            item.setPath(R.drawable.vision2);
        if (spnHinhXe.getSelectedItem().toString().equals("Vision tím"))
            item.setPath(R.drawable.vision3);
        if (spnHinhXe.getSelectedItem().toString().equals("Wave"))
            item.setPath(R.drawable.xe4);
        return item;
    }

    public void ChonXe(Xe xe) {
        this.xe = xe;
        edtMaXe.setText(xe.getMaSP());
        edtTenXe.setText(xe.getTenSP());
        edtSoLuong.setText(xe.getSoLuong());
        edtDonGia.setText(xe.getDonGia());
        edtHanBaoHanh.setText(xe.getHanBH());
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

    public void themXe(View view) {
        if (!checkNullInfo(edtMaXe)) {
            thongBao("Bị thiếu mã xe");
            return;
        }

        if (!checkNullInfo(edtTenXe)) {
            thongBao("Bị thiếu tên xe");
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

        DBManager database = new DBManager(ThemXeActivity.this);
        Xe xe = getXe();
        database.insertXe(xe);
        Toast.makeText(ThemXeActivity.this, "Thêm Xe Thành Công", Toast.LENGTH_SHORT).show();
        //finish();
        Intent intent = new Intent(this, QuanLyXeActivity.class);
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

    public void quayLaiXe(View view) {
        Intent intent = new Intent(ThemXeActivity.this, QuanLyXeActivity.class);
        startActivity(intent);
    }
}