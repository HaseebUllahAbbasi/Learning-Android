package com.example.numberslab7_3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class MyAdapter extends ArrayAdapter {

    Context context;
    int resource;
    List<Numbers> list;
    public MyAdapter(@NonNull Context context, int resource, @NonNull List<Numbers> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.list = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(getContext()).inflate(R.layout.custom_list_layout, parent, false);
       TextView eng_number =  convertView.findViewById(R.id.textView);
       TextView int_number = convertView.findViewById(R.id.textView2);
        ImageView img = convertView.findViewById(R.id.imageView);
       Numbers numbers = list.get(position);
       eng_number.setText(numbers.numbering);
       int_number.setText(numbers.counting);
       img.setImageResource(numbers.img);
       return convertView;
    }
}
