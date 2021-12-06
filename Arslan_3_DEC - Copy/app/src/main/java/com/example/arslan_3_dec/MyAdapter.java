package com.example.arslan_3_dec;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends ArrayAdapter<Persons> {

    public MyAdapter(Context context, ArrayList<Persons> persons)
    {
        super(context,R.layout.mylayout,persons);

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        Persons person = getItem(position);
        if(convertView==null)
        {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.mylayout, parent, false);

        }
            TextView name = (TextView)convertView.findViewById(R.id.name);
            TextView email = (TextView)convertView.findViewById(R.id.email);
            TextView phone = (TextView)convertView.findViewById(R.id.email);
            ImageView imageView = (ImageView) convertView.findViewById(R.id.image_1);

            name.setText(person.getName());
            email.setText(person.getEmail());
            phone.setText(person.getPhone());
            imageView.setImageResource(person.getImg());







            return convertView;
//        return super.getView(position, convertView, parent);
    }
}
