package com.example.motorshop.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.motorshop.R;
import com.example.motorshop.object.PhuTung;

import java.util.ArrayList;

public class DanhSachPhuTungAdapter extends ArrayAdapter {
    Context context;
    int resource;
    public ArrayList<PhuTung> data;

    public DanhSachPhuTungAdapter(Context context, int resource, ArrayList data) {
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
    public PhuTung getItem(int position)
    {
        return data.get(position);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.item_phu_tung, null);


        if (data.size() > 0) {
            TextView tvTenPhuTung = convertView.findViewById(R.id.tvTenPhuTung);
            TextView tvTenHang = convertView.findViewById(R.id.tvTenHang);
            TextView tvMaXe = convertView.findViewById(R.id.tvMaXe);
            TextView tvSoLuong = convertView.findViewById(R.id.tvSoLuong);
            TextView tvDonGia = convertView.findViewById(R.id.tvDonGia);
            TextView tvHanBaoHanh = convertView.findViewById(R.id.tvHanBaoHanh);

            ImageView ivPhuTung = convertView.findViewById(R.id.ivPhuTung);

            PhuTung phuTung = data.get(position);

            tvMaXe.setText(phuTung.getMaSP());
            tvTenPhuTung.setText(phuTung.getTenSP());

            if (phuTung.getMaNCC().toString().equals("HD"))
                tvTenHang.setText("Honda");
            if (phuTung.getMaNCC().toString().equals("YM"))
                tvTenHang.setText("Yamaha");
            if (phuTung.getMaNCC().toString().equals("SY"))
                tvTenHang.setText("SYM");

            tvSoLuong.setText(phuTung.getSoLuong());
            tvDonGia.setText(phuTung.getDonGia());
            tvHanBaoHanh.setText(phuTung.getHanBH());
            ivPhuTung.setImageResource(phuTung.getPath());
        }

        return convertView;
    }
}
