package com.example.casino_tcuik;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;

public class LiderAdapter extends ArrayAdapter {

    private LayoutInflater inflater;
    private int layout;
    private List<lider_spisok> liderList;


    public LiderAdapter(@NonNull Context context, int resource, @NonNull Object[] objects) {
        super(context, resource, objects);

        this.liderList = liderList;
        this.layout = resource;
        this.inflater = LayoutInflater.from(context);
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        View view = inflater.inflate(this.layout, parent,false);

        TextView nameView = view.findViewById(R.id.name_lider);
        TextView money = view.findViewById(R.id.money);
        ImageView im = view.findViewById(R.id.im);


        lider_spisok lider_spisok = liderList.get(position);

        im.setImageResource(lider_spisok.getImage());
        nameView.setText(lider_spisok.getName_lider());
        money.setText(lider_spisok.getMoney());

        return view;

    }
}

