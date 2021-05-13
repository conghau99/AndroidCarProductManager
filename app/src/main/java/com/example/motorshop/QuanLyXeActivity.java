package com.example.motorshop;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.motorshop.adapter.DanhSachXeAdapter;
import com.example.motorshop.db.DBManager;
import com.example.motorshop.dialog.LuaChonThemXeDialog;
import com.example.motorshop.dialog.LuaChonXe;
import com.example.motorshop.object.Xe;

import java.util.ArrayList;

public class QuanLyXeActivity extends AppCompatActivity {
    ListView lvHienThiXe;
    ArrayList<Xe> data = new ArrayList<>();
    EditText edtTenXe;
    String nameXe = "";
    DanhSachXeAdapter danhSachXeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quan_ly_xe);

        setControl();
        setEvent();
        setClick();
    }

    private void setEvent() {
        danhSachXeAdapter = new DanhSachXeAdapter(this, R.layout.item_xe, data);
        lvHienThiXe.setAdapter(danhSachXeAdapter);

        DBManager database = new DBManager(QuanLyXeActivity.this);
        database.loadXe(data);
        danhSachXeAdapter.notifyDataSetChanged();


    }

    private void setControl() {
        edtTenXe = (EditText) findViewById(R.id.edtTenXe);
        lvHienThiXe = (ListView) findViewById(R.id.lvHienThiXe);
    }

    private void setClick() {
        edtTenXe.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                String s = edtTenXe.getText().toString();
                if (s.length() >= 2) {
                    s.toLowerCase();

                    //Tiến hành kiểm tra và update lại cái list
                }
            }
        });

        lvHienThiXe.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                //new LuaChonXe(QuanLyXeActivity.this, (Xe) adapterView.getItemAtPosition(position)).show();
                new LuaChonXe(QuanLyXeActivity.this, danhSachXeAdapter.data.get(position)).show();

            }
        });
    }

    private void tienHanhKiemTra() {
        //Kiểm tra tên nhập vào
        ArrayList<Xe> arrTen;
        if (nameXe.length() >= 2) {
            arrTen = new ArrayList<>();
            for (Xe x : Data.getData().arrXe) {
                String tenXe = x.getTenSP().toLowerCase();
                if (tenXe.indexOf(nameXe) >= 0) {
                    arrTen.add(x);
                }
            }
        } else {
            arrTen = Data.getData().arrXe;
        }
    }

    public void luaChonThem(View view) {
        new LuaChonThemXeDialog(this).show();

    }

    public void chuyenDenManThemXe() {
        Intent i = new Intent(this, ThemXeActivity.class);
        startActivity(i);
    }

    public void chuyenDenManThemPhuTung() {
        Intent intent = new Intent(this, ThemPhuTungActivity.class);
        startActivity(intent);
    }

    public void quanLyPhuTung(View view) {
        Intent i1 = new Intent(this, QuanLyPhuTungActivity.class);
        startActivity(i1);
    }
}