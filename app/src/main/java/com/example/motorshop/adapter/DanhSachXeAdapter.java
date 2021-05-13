package com.example.motorshop.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.motorshop.R;
import com.example.motorshop.object.*;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DanhSachXeAdapter extends ArrayAdapter {
    Context context;
    int resource;
    public ArrayList<Xe> data;

    public DanhSachXeAdapter(Context context, int resource, ArrayList data) {
        super(context, resource);
        this.context = context;
        this.resource = resource;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Xe getItem(int position)
    {
        return data.get(position);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.item_xe, null);


        if (data.size() > 0) {
            TextView tvTenXe = convertView.findViewById(R.id.tvTenXe);
            TextView tvTenHang = convertView.findViewById(R.id.tvTenHang);
            TextView tvMaXe = convertView.findViewById(R.id.tvMaXe);
            TextView tvSoLuong = convertView.findViewById(R.id.tvSoLuong);
            TextView tvDonGia = convertView.findViewById(R.id.tvDonGia);
            TextView tvHanBaoHanh = convertView.findViewById(R.id.tvHanBaoHanh);

            ImageView ivXe = convertView.findViewById(R.id.ivXe);

            Xe xe = data.get(position);

            tvMaXe.setText(xe.getMaSP());
            tvTenXe.setText(xe.getTenSP());

            if (xe.getMaNCC().toString().equals("HD"))
                tvTenHang.setText("Honda");
            if (xe.getMaNCC().toString().equals("YM"))
                tvTenHang.setText("Yamaha");
            if (xe.getMaNCC().toString().equals("SY"))
                tvTenHang.setText("SYM");

            tvSoLuong.setText(xe.getSoLuong());
            tvDonGia.setText(xe.getDonGia());
            tvHanBaoHanh.setText(xe.getHanBH());
            ivXe.setImageResource(xe.getPath());
        }

        return convertView;
    }
}
