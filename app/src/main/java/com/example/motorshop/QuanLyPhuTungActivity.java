package com.example.motorshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;

import com.example.motorshop.adapter.DanhSachPhuTungAdapter;
import com.example.motorshop.db.DBManager;
import com.example.motorshop.dialog.LuaChonPhuTung;
import com.example.motorshop.dialog.LuaChonThemPhuTungDialog;
import com.example.motorshop.dialog.LuaChonThemXeDialog;
import com.example.motorshop.object.PhuTung;

import java.util.ArrayList;

public class QuanLyPhuTungActivity extends AppCompatActivity {
    ListView lvHienThiPhuTung;
    ArrayList<PhuTung> data = new ArrayList<>();
    EditText edtTenPhuTung;
    String namePhuTung = "";
    DanhSachPhuTungAdapter danhSachPhuTungAdapter ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quan_ly_phu_tung);

        setControl();
        setEvent();
        setClick();
    }

    private void setEvent() {
        danhSachPhuTungAdapter = new DanhSachPhuTungAdapter(this, R.layout.item_phu_tung, data);
        lvHienThiPhuTung.setAdapter(danhSachPhuTungAdapter);

        DBManager database = new DBManager(QuanLyPhuTungActivity.this);
        database.loadPT(data);
        danhSachPhuTungAdapter.notifyDataSetChanged();


    }

    private void setControl() {
        edtTenPhuTung = (EditText) findViewById(R.id.edtTenPhuTung);
        lvHienThiPhuTung = (ListView) findViewById(R.id.lvHienThiPhuTung);
    }

    private void setClick() {
        edtTenPhuTung.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                String s = edtTenPhuTung.getText().toString();
                if (s.length() >= 2) {
                    s.toLowerCase();

                    //Tiến hành kiểm tra và update lại cái list
                }
            }
        });

        lvHienThiPhuTung.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                //new LuaChonXe(QuanLyXeActivity.this, (Xe) adapterView.getItemAtPosition(position)).show();
                new LuaChonPhuTung(QuanLyPhuTungActivity.this, danhSachPhuTungAdapter.data.get(position)).show();

            }
        });
    }


    private void tienHanhKiemTra() {
        //Kiểm tra tên nhập vào
        ArrayList<PhuTung> arrTen;
        if (namePhuTung.length() >= 2) {
            arrTen = new ArrayList<>();
            for (PhuTung pt : Data.getData().arrPhuTung) {
                String tenPhuTung =pt.getTenSP().toLowerCase();
                if (tenPhuTung.indexOf(namePhuTung) >= 0) {
                    arrTen.add(pt);
                }
            }
        } else {
            arrTen = Data.getData().arrPhuTung;
        }
    }

    public void luaChonThem(View view) {
        new LuaChonThemPhuTungDialog(this).show();

    }

    public void chuyenDenManThemXe() {
        Intent i = new Intent(this, ThemXeActivity.class);
        startActivity(i);
    }

    public void chuyenDenManThemPhuTung() {
        Intent i = new Intent(this, ThemPhuTungActivity.class);
        startActivity(i);
    }

    public void quanLyXe(View view) {
        Intent i = new Intent(this, QuanLyXeActivity.class);
        startActivity(i);
    }
}