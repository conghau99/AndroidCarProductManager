package com.example.motorshop.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import android.widget.Toast;

import com.example.motorshop.QuanLyPhuTungActivity;
import com.example.motorshop.R;
import com.example.motorshop.SuaPhuTungActivity;
import com.example.motorshop.db.DBManager;
import com.example.motorshop.object.PhuTung;

import java.util.ArrayList;

public class LuaChonPhuTung extends Dialog {

    PhuTung pt;
    QuanLyPhuTungActivity quanLyPhuTungActivity;
    SuaPhuTungActivity suaPhuTungActivity;
    ArrayList<PhuTung> data = new ArrayList<>();

    public LuaChonPhuTung(Context context, PhuTung phuTung) {
        super(context);
        this.pt = phuTung;
        this.quanLyPhuTungActivity = (QuanLyPhuTungActivity) context;

        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.dg_nua_chon_phu_tung);

        //ánh xạ
        TextView tvTenPhuTung = findViewById(R.id.tvTenPhuTung);
        TextView tvSuaThongTinPhuTung = findViewById(R.id.tvSuaThongTinPhuTung);
        TextView tvXoaPhuTung = findViewById(R.id.tvXoaPhuTung);

        //set thông tin
        tvTenPhuTung.setText(pt.getTenSP());
        tvSuaThongTinPhuTung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quanLyPhuTungActivity.startActivity(new Intent(quanLyPhuTungActivity, SuaPhuTungActivity.class));
                dismiss();
            }
        });

        tvXoaPhuTung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBManager database = new DBManager(quanLyPhuTungActivity);
                database.deletePT(pt);
                database.loadPT(data);
                Toast.makeText(quanLyPhuTungActivity, "Xóa Phụ Tùng Thành Công", Toast.LENGTH_SHORT).show();
                dismiss();
                quanLyPhuTungActivity.startActivity(new Intent(quanLyPhuTungActivity, QuanLyPhuTungActivity.class));
            }
        });
    }
}
