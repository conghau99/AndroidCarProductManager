package com.example.motorshop.dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.motorshop.QuanLyPhuTungActivity;
import com.example.motorshop.QuanLyXeActivity;
import com.example.motorshop.R;

public class LuaChonThemXeDialog extends Dialog {

    QuanLyXeActivity quanLyXeActivity;

    public LuaChonThemXeDialog(@NonNull Context context) {
        super(context);
        this.quanLyXeActivity = (QuanLyXeActivity)context;

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dg_nua_chon_them);

        TextView tvThemPhuTung = findViewById(R.id.tvThemPhuTung);
        TextView tvThemXe = findViewById(R.id.tvThemXe);

        tvThemXe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quanLyXeActivity.chuyenDenManThemXe();
                dismiss();
            }
        });

        tvThemPhuTung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quanLyXeActivity.chuyenDenManThemPhuTung();
                dismiss();
            }
        });

    }
}
