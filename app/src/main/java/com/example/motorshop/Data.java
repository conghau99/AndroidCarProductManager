package com.example.motorshop;

import com.example.motorshop.object.*;

import java.util.ArrayList;


public class Data {
    static Data data;

    static {
        data = new Data();
    }

    public static Data getData() {
        return data;
    }

    public ArrayList<Xe> arrXe = new ArrayList<>();
    public ArrayList<PhuTung> arrPhuTung = new ArrayList<>();
}
